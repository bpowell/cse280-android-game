package edu.oakland.cse280.bscd.graphics.UI;

import edu.oakland.cse280.bscd.R;
import edu.oakland.cse280.bscd.Settings;

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
    private Bitmap save_button;

	private Rect dlef_loc;
	private Rect drig_loc;
	private Rect dtop_loc;
	private Rect dbot_loc;

	private Rect a_loc;
	private Rect b_loc;

    private Rect save_loc;

	private Context context;

	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int LEFT_MARGIN;
	private int BOTTOM_MARGIN;

	public UIButtons(Context context)
	{
		this.context = context;
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		SCREEN_WIDTH = wm.getDefaultDisplay().getWidth();
		SCREEN_HEIGHT = wm.getDefaultDisplay().getHeight();
		LEFT_MARGIN = 15;
		BOTTOM_MARGIN = 20;

		dlef_loc = new Rect(LEFT_MARGIN, SCREEN_HEIGHT-(BOTTOM_MARGIN+2*Settings.DPAD_SIZE), LEFT_MARGIN+Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+Settings.DPAD_SIZE));
		drig_loc = new Rect(LEFT_MARGIN+2*Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+2*Settings.DPAD_SIZE), LEFT_MARGIN+3*Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+Settings.DPAD_SIZE));
		dbot_loc = new Rect(LEFT_MARGIN+1*Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+Settings.DPAD_SIZE), LEFT_MARGIN+2*Settings.DPAD_SIZE, SCREEN_HEIGHT-BOTTOM_MARGIN);
		dtop_loc = new Rect(LEFT_MARGIN+1*Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+3*Settings.DPAD_SIZE), LEFT_MARGIN+2*Settings.DPAD_SIZE, SCREEN_HEIGHT-(BOTTOM_MARGIN+2*Settings.DPAD_SIZE));

		a_loc = new Rect(SCREEN_WIDTH-70, SCREEN_HEIGHT-150, SCREEN_WIDTH-50, SCREEN_HEIGHT-130);
		b_loc = new Rect(SCREEN_WIDTH-70, SCREEN_HEIGHT-70, SCREEN_WIDTH-50, SCREEN_HEIGHT-50);

        save_loc = new Rect(SCREEN_WIDTH/2-20, SCREEN_HEIGHT - 50, SCREEN_WIDTH/2+20, SCREEN_HEIGHT - 10);

		dpad = BitmapFactory.decodeResource(context.getResources(), R.drawable.dpad_part);
		a_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.a_button);
		b_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.b_button);
        save_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.save_btn);

		opake = new Paint();
		opake.setAlpha(200);
	}

	public void draw(Canvas canvas)
	{
		Rect bounds = canvas.getClipBounds();
		int left, top;

		left = bounds.left+LEFT_MARGIN;
		top = bounds.bottom-(BOTTOM_MARGIN+2*Settings.DPAD_SIZE);
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.left+LEFT_MARGIN+2*Settings.DPAD_SIZE;
		top = bounds.bottom-(BOTTOM_MARGIN+2*Settings.DPAD_SIZE);
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.left+LEFT_MARGIN+1*Settings.DPAD_SIZE;
		top = bounds.bottom-(BOTTOM_MARGIN+Settings.DPAD_SIZE);
		canvas.drawBitmap(dpad, left, top, opake);
		
		left = bounds.left+LEFT_MARGIN+1*Settings.DPAD_SIZE;
		top = bounds.bottom-(BOTTOM_MARGIN+3*Settings.DPAD_SIZE);
		canvas.drawBitmap(dpad, left, top, opake);

		left = bounds.right-70;
		top = bounds.bottom-150;
		canvas.drawBitmap(a_button, left, top, opake);

		left = bounds.right-70;
		top = bounds.bottom-70;
		canvas.drawBitmap(b_button, left, top, opake);

        left = bounds.left + ((bounds.right - bounds.left) / 2);
        top = bounds.bottom - 50;
        canvas.drawBitmap(save_button, left, top, opake);
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

    public Rect get_SAVE()
    {
        return save_loc;
    }
}
