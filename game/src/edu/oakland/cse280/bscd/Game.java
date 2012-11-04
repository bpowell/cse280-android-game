package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.graphics.entities.Hero;
import edu.oakland.cse280.bscd.graphics.models.Map;
import edu.oakland.cse280.bscd.graphics.UI.UIButtons;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	private GameThread game_loop;
	private Hero hero;
	private Map map;
	private UIButtons ui_buttons;

	private Context context;
	private int SCREEN_WDITH;
	private int SCREEN_HEIGHT;

	public Game(Context context)
	{
		super(context);
		getHolder().addCallback(this);

		this.context = context;

		hero = new Hero(BitmapFactory.decodeResource(getResources(), R.drawable.hero), 0, new Rect(0, 0, Settings.TOON_WIDTH, Settings.TOON_HEIGHT));
		map = new Map(context, "map02.txt", hero.getLocation());
		ui_buttons = new UIButtons(context);
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		if(game_loop == null || !game_loop.isAlive())
		{
			game_loop = new GameThread(getHolder(), this);
			game_loop.setRunning(true);
		}

		game_loop.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		while(true)
		{
			try
			{
				game_loop.setRunning(false);
				game_loop.join();
				return;
			}
			catch(Exception e)
			{
				Log.d("Game/surfaceDestroyed", "Cannot end game_loop thread.");
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{

		Rect dleft = ui_buttons.get_DLEFT();
		Rect dright = ui_buttons.get_DRIGHT();
		Rect dtop  = ui_buttons.get_DTOP();
		Rect dbottom = ui_buttons.get_DBOTTOM();

		Rect a = ui_buttons.get_A();
		Rect b = ui_buttons.get_B();

		int x,y;
		x = (int)event.getX();
		y = (int)event.getY();

		if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction()==MotionEvent.ACTION_MOVE)
		{
			if(dleft.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
				hero.move(-(Settings.TOON_WIDTH/2),0, Settings.TOON_FACE_LEFT);
			else if(dright.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
				hero.move((Settings.TOON_WIDTH/2),0, Settings.TOON_FACE_RIGHT);
			else if(dtop.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
				hero.move(0,-(Settings.TOON_HEIGHT/2), Settings.TOON_FACE_FRONT);
			else if(dbottom.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
				hero.move(0,(Settings.TOON_HEIGHT/2), Settings.TOON_FACE_BACK);
		}
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		if(game_loop.getRunning()==false)
			return;

		canvas.drawColor(Color.WHITE);
		int top, left;

		Rect hero_location = hero.getLocation();
		Rect canvas_rect = canvas.getClipBounds();
		int mwidth = map.getWidth();
		int mheight = map.getHeight();

		if(hero_location.bottom >= mheight)
			top = -(mheight-2*Settings.TILE_HEIGHT);
		else if(hero_location.top <= (canvas.getHeight()/2))
			top = 0;
		else
			top = -(hero_location.top-(canvas.getHeight()/2));

		if(hero_location.right >= mwidth)
			left = -(mwidth-2*Settings.TILE_WIDTH);
		else if(hero_location.left <= (canvas.getWidth()/2))
			left = 0;
		else
			left = -(hero_location.left-(canvas.getWidth()/2));


		//canvas.translate(-(hero_location.left-(canvas.getWidth()/2)), -(hero_location.top-(canvas.getHeight()/2)));
		canvas.translate(left, top);

		map.draw(canvas);
		ui_buttons.draw(canvas);
		hero.draw(canvas, map.getLoaded_tiles(), map.getNon_passable_tiles());
	}
}
