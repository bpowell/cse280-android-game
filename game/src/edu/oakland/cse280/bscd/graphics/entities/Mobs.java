package edu.oakland.cse280.bscd.graphics.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

public class Mobs
{
	private static int HEIGHT = 80;
	private static int WIDTH  = 40;

	private ArrayList<Bitmap> image;
	private int direction;
	private Rect location;

	public Mobs(Bitmap sheet, int direction, Rect starting_position)
	{
		image = new ArrayList<Bitmap>();

		image.add(Bitmap.createBitmap(sheet,0*WIDTH,0,WIDTH,HEIGHT));
		image.add(Bitmap.createBitmap(sheet,1*WIDTH,0,WIDTH,HEIGHT));
		image.add(Bitmap.createBitmap(sheet,2*WIDTH,0,WIDTH,HEIGHT));
		image.add(Bitmap.createBitmap(sheet,3*WIDTH,0,WIDTH,HEIGHT));

		this.direction = direction;
		this.location = starting_position;
	}

	public Rect getLocation()
	{
		return location;
	}

	public setLocation(Rect location)
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
