package edu.oakland.cse280.bscd.graphics.UI;

import edu.oakland.cse280.bscd.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class UIButtons
{
	private Bitmap dpad;
	private Rect dpad_location;

	private Bitmap a_button;
	private Rect a_button_location;

	private Bitmap b_button;
	private Rect b_button_location;

	private Context context;

	public UIButtons(Context context)
	{
		this.context = context;

		dpad = BitmapFactory.decodeResource(context.getResources(), R.drawable.dpad);
		a_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.a_button);
		b_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.b_button);
	}
}
