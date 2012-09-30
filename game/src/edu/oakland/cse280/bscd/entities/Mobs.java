package edu.oakland.cse280.bscd.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Mobs
{
	private static int HEIGHT = 50;
	private static int WIDTH = 50;

	private Bitmap[] image;
	private int x_pos;
	private int y_pos;
	private int direction;

	public Mobs(Bitmap sheet, int direction, int x, int y)
	{
		image = new Bitmap[4];

		image[0] = Bitmap.createBitmap(sheet,0*WIDTH,0,WIDTH,HEIGHT);
		image[1] = Bitmap.createBitmap(sheet,1*WIDTH,0,WIDTH,HEIGHT);
		image[2] = Bitmap.createBitmap(sheet,2*WIDTH,0,WIDTH,HEIGHT);
		image[3] = Bitmap.createBitmap(sheet,3*WIDTH,0,WIDTH,HEIGHT);
		this.direction = direction;
		this.x_pos = x;
		this.y_pos = y;
	}

	public int getX_pos()
	{
		return this.x_pos;
	}

	public void setX_pos(int  x_pos)
	{
		this.x_pos = x_pos;
	}

	public int getY_pos()
	{
		return this.y_pos;
	}

	public void setY_pos(int  y_pos)
	{
		this.y_pos = y_pos;
	}

	public void draw(Canvas canvas)
	{
		Bitmap b = image[direction];
		canvas.drawBitmap(b, x_pos , y_pos , null);
	}

	public int getDirection()
	{
		return this.direction;
	}

	public void setDirection(int  direction)
	{
		this.direction = direction;
	}

	public Bitmap[] getImage()
	{
		return this.image;
	}

	public void setImage(Bitmap[]  image)
	{
		this.image = image;
	}
}
