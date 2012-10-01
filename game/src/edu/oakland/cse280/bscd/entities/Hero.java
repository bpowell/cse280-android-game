package edu.oakland.cse280.bscd.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Hero extends Mobs
{
	public Hero(Bitmap image,int direction, int x, int y)
	{
		super(image, direction, x, y);
	}

	public void move()
	{
		setX_pos(getX_pos()+1);
		setY_pos(getY_pos()+1);
	}
}
