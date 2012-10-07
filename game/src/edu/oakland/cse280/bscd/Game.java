package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.entities.Hero;
import edu.oakland.cse280.bscd.models.Map;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Camera;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	private GameThread game_loop;
	private Hero hero;
	private Map map;

	public Game(Context context)
	{
		super(context);
		getHolder().addCallback(this);

		AssetManager assetMan = context.getAssets();
		map = new Map(context, assetMan, "map01.txt", 0, 0);

		hero = new Hero(BitmapFactory.decodeResource(getResources(), R.drawable.hero),0,20,20);
		game_loop = new GameThread(getHolder(), this);

		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		game_loop.setRunning(true);
		game_loop.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.WHITE);

		//Camera camera = new Camera();
		//camera.translate(-(float)hero.getY_pos()/2+10, (float)hero.getX_pos()/2+10, 0.0f);
		//camera.applyToCanvas(canvas);
		int h = canvas.getHeight();
		int w = canvas.getWidth();
		canvas.translate(-(hero.getX_pos()-w/2), -(hero.getY_pos()-h/2));
		hero.move();
		map.draw(canvas);
		hero.draw(canvas);
	}
}
