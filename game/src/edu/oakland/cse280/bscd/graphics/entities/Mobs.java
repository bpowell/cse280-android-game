package edu.oakland.cse280.bscd.graphics.entities;

import edu.oakland.cse280.bscd.Settings;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

public class Mobs
{
	private Settings settings;

	private ArrayList<Bitmap> image;
	private int direction;
	private Rect location;

	public Mobs(Bitmap sheet, int direction, Rect starting_position)
	{
		image = new ArrayList<Bitmap>();

		image.add(Bitmap.createBitmap(sheet,0*settings.TOON_WIDTH,0,settings.TOON_WIDTH,settings.TOON_HEIGHT));
		image.add(Bitmap.createBitmap(sheet,1*settings.TOON_WIDTH,0,settings.TOON_WIDTH,settings.TOON_HEIGHT));
		image.add(Bitmap.createBitmap(sheet,2*settings.TOON_WIDTH,0,settings.TOON_WIDTH,settings.TOON_HEIGHT));
		image.add(Bitmap.createBitmap(sheet,3*settings.TOON_WIDTH,0,settings.TOON_WIDTH,settings.TOON_HEIGHT));

		this.direction = direction;
		this.location = starting_position;
	}

	public Rect getLocation()
	{
		return location;
	}

	public void setLocation(Rect location)
	{
		this.location = location;
	}

	public int getDirection()
	{
		return direction;
	}

	public void setDirection(int direction)
	{
		this.direction = direction;
	}

	public void draw(Canvas canvas)
	{
		Bitmap mob = image.get(direction);
		canvas.drawBitmap(mob, location.left, location.top, null);
	}
}
