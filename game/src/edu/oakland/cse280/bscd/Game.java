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

	public Game(Context context)
	{
		super(context);
		getHolder().addCallback(this);

		this.context = context;

		hero = new Hero(BitmapFactory.decodeResource(getResources(), R.drawable.hero), 0, new Rect(20,20,0,0));
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

		Log.i("LOLCATIONS: ", ""+dright.left+","+dright.top+","+dright.right+","+dright.bottom);

		Rect a = ui_buttons.get_A();
		Rect b = ui_buttons.get_B();

		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			int x,y;
			x = (int)event.getX();
			y = (int)event.getY();

			if(dleft.intersect(x,y,x+20,y+20))
				Log.i("HFHSDLFHSDLFHSDLKFHSDFS", "Left dpad pressed");
			else if(dright.intersect(x,y,x+20,y+20))
				Log.i("HFHSDLFHSDLFHSDLKFHSDFS", "Right dpad pressed");
			else if(dtop.intersect(x,y,x+20,y+20))
				Log.i("HFHSDLFHSDLFHSDLKFHSDFS", "Top dpad pressed");
			else if(dbottom.intersect(x,y,x+20,y+20))
				Log.i("HFHSDLFHSDLFHSDLKFHSDFS", "Bottom dpad pressed");

			Log.i("DSDHASDHASKDHAKSDH", ""+x+","+y);
		}
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		if(game_loop.getRunning()==false)
			return;

		canvas.drawColor(Color.WHITE);

		//Rect cancord = canvas.getClipBounds();
		//Log.i("DASDASDSADASDASD", ""+cancord.left+","+cancord.right+","+cancord.top+","+cancord.bottom);

		map.draw(canvas);
		ui_buttons.draw(canvas);
		hero.draw(canvas);
	}
}
