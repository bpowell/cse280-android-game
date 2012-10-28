package edu.oakland.cse280.bscd.graphics.UI;

import edu.oakland.cse280.bscd.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.util.Log;
import android.view.WindowManager;

public class UIButtons
{
	private Paint opake;

	private Bitmap dpad;
	private Bitmap a_button;
	private Bitmap b_button;

	private Rect dlef_loc;
	private Rect drig_loc;
	private Rect dtop_loc;
	private Rect dbot_loc;

	private Rect a_loc;
	private Rect b_loc;

	private Context context;

	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;

	public UIButtons(Context context)
	{
		this.context = context;
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		SCREEN_WIDTH = wm.getDefaultDisplay().getWidth();
		SCREEN_HEIGHT = wm.getDefaultDisplay().getHeight();

		dlef_loc = new Rect(15, SCREEN_HEIGHT-50, 35, SCREEN_HEIGHT-30);
		drig_loc = new Rect(55, SCREEN_HEIGHT-50, 75, SCREEN_HEIGHT-30);
		dtop_loc = new Rect(35, SCREEN_HEIGHT-70, 55, SCREEN_HEIGHT-50);
		dbot_loc = new Rect(35, SCREEN_HEIGHT-30, 55, SCREEN_HEIGHT-10);

		a_loc = new Rect(SCREEN_WIDTH-70, SCREEN_HEIGHT-150, SCREEN_WIDTH-50, SCREEN_HEIGHT-130);
		b_loc = new Rect(SCREEN_WIDTH-70, SCREEN_HEIGHT-70, SCREEN_WIDTH-50, SCREEN_HEIGHT-50);

		dpad = BitmapFactory.decodeResource(context.getResources(), R.drawable.dpad_part);
		a_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.a_button);
		b_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.b_button);

		opake = new Paint();
		opake.setAlpha(200);
	}

	public void draw(Canvas canvas)
	{
		Rect bounds = canvas.getClipBounds();
		int left, top;

		left = bounds.left+15;
		top = bounds.bottom-50;
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.left+55;
		top = bounds.bottom-50;
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.left+35;
		top = bounds.bottom-70;
		canvas.drawBitmap(dpad, left, top, opake);
		
		left = bounds.left+35;
		top = bounds.bottom-30;
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.right-70;
		top = bounds.bottom-150;
		canvas.drawBitmap(a_button, left, top, opake);

		left = bounds.right-70;
		top = bounds.bottom-70;
		canvas.drawBitmap(b_button, left, top, opake);
	}

	public Rect get_DLEFT()
	{
		return dlef_loc;
	}

	public Rect get_DRIGHT()
	{
		return drig_loc;
	}

	public Rect get_DTOP()
	{
		return dtop_loc;
	}

	public Rect get_DBOTTOM()
	{
		return dbot_loc;
	}

	public Rect get_A()
	{
		return a_loc;
	}

	public Rect get_B()
	{
		return b_loc;
	}
}
