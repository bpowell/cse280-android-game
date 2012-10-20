package edu.oakland.cse280.bscd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	private GameThread game_loop;
	//private Hero hero;
	//private Map map;

	private Context context;

	public Game(Context context)
	{
		super(context);
		this.context = context;
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
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
	}
}
