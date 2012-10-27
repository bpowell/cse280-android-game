package edu.oakland.cse280.bscd.graphics.UI;

import edu.oakland.cse280.bscd.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;

import java.util.ArrayList;

public class UIButtons
{
	public static int LEFT = 0;
	public static int RIGHT = 1;
	public static int TOP = 2;
	public static int BOTTOM = 3;

	private Paint opake;

	private Bitmap dpad;
	private ArrayList<Rect> dpad_locations;

	private Bitmap a_button;
	private Rect a_button_location;

	private Bitmap b_button;
	private Rect b_button_location;

	private Context context;

	public UIButtons(Context context)
	{
		this.context = context;

		dpad = BitmapFactory.decodeResource(context.getResources(), R.drawable.dpad_part);
		a_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.a_button);
		b_button = BitmapFactory.decodeResource(context.getResources(), R.drawable.b_button);

		dpad_locations = new ArrayList<Rect>();
		for(int i=0; i<4; i++)
			dpad_locations.add(new Rect());

		a_button_location = new Rect();
		b_button_location = new Rect();

		opake = new Paint();
		opake.setAlpha(200);
	}

	public void draw(Canvas canvas)
	{
		Rect bounds = canvas.getClipBounds();

		dpad_locations.get(LEFT).left = bounds.left+10;
		dpad_locations.get(LEFT).top = bounds.bottom-50;
		dpad_locations.get(LEFT).right = dpad_locations.get(LEFT).left+20;
		dpad_locations.get(LEFT).bottom = dpad_locations.get(LEFT).top+20;
		canvas.drawBitmap(dpad, dpad_locations.get(LEFT).left, dpad_locations.get(LEFT).top, opake);

		a_button_location.left = bounds.right-70;
		a_button_location.top = bounds.bottom-150;
		a_button_location.right = a_button_location.left+60;
		a_button_location.bottom = a_button_location.top+60;
		canvas.drawBitmap(a_button, a_button_location.left, a_button_location.top, opake);

		b_button_location.left = bounds.right-70;
		b_button_location.top = bounds.bottom-70;
		b_button_location.right = b_button_location.left+60;
		b_button_location.bottom = b_button_location.top+60;
		canvas.drawBitmap(b_button, b_button_location.left, b_button_location.top, opake);
	}

	public Rect getAbutton_location()
	{
		return a_button_location;
	}

	public Rect getBbutton_location()
	{
		return b_button_location;
	}
}
