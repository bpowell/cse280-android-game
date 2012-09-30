package edu.oakland.cse280.bscd;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread
{
	private SurfaceHolder holder;
	private Game game;

	private boolean running;

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
	}

	@Override
	public void run()
	{
		Canvas canvas;
		while(running)
		{
			canvas = null;
			try{
				canvas = this.holder.lockCanvas();
				synchronized(this.holder)
				{
					this.game.onDraw(canvas);
				}
			}
			finally{
				if(canvas != null)
					this.holder.unlockCanvasAndPost(canvas);
			}
		}
	}
}

