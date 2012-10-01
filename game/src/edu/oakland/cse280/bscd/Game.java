package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.entities.Hero;
import android.app.Activity;
import android.content.Context;
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
	private Camera camera;
	private Hero hero;

	public Game(Context context)
	{
		super(context);
		getHolder().addCallback(this);

		hero = new Hero(BitmapFactory.decodeResource(getResources(), R.drawable.hero),0,20,20);
		camera = new Camera();
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

		camera.save();
		camera.translate(5f,5f,0f);
		camera.applyToCanvas(canvas);
		hero.move();
		hero.draw(canvas);
	}
}
