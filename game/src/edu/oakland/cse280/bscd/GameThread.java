package edu.oakland.cse280.bscd;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.lang.System;

public class GameThread extends Thread
{
	private SurfaceHolder holder;
	private Game game;

	private boolean running;
	private long start_time;

	public boolean getRunning()
	{
		return this.running;
	}

	public void setRunning(boolean  running)
	{
		this.running = running;
	}

	public GameThread(SurfaceHolder holder, Game game)
	{
		super();
		this.holder = holder;
		this.game = game;

		start_time = System.currentTimeMillis();
	}

	@Override
	public void run()
	{
		Canvas canvas;
		while(running)
		{
			canvas = null;
			try{
				long end_time = System.currentTimeMillis();
				long dt = end_time - start_time;

				if(dt < 33)
					this.sleep(33 - dt);

				start_time = System.currentTimeMillis();

				canvas = this.holder.lockCanvas();
				synchronized(this.holder)
				{
					this.game.onDraw(canvas);
				}
			}
			catch(Exception e)
			{
				this.interrupt();
			}
			finally{
				if(canvas != null)
					this.holder.unlockCanvasAndPost(canvas);
			}
		}
	}
}

