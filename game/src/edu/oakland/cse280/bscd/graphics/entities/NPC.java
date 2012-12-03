package edu.oakland.cse280.bscd.graphics.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;

public class NPC extends Mobs
{
	private boolean is_talking;
	private String speech;

	public NPC(Bitmap sheet, int direction, Rect starting_position)
	{
		super(sheet, direction, starting_position);
		is_talking = false;
	}

	public void set_is_talking(boolean talk)
	{
		this.is_talking = talk;
	}

	public boolean get_is_talking()
	{
		return this.is_talking;
	}

	public String getSpeech()
	{
		return this.speech;
	}

	public void setSpeech(String  speech)
	{
		this.speech = speech;
	}

	public void draw(Canvas canvas)
	{
		Rect bounds = canvas.getClipBounds();
		super.draw(canvas);
	}
}
