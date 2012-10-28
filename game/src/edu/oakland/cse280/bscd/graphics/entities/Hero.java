package edu.oakland.cse280.bscd.graphics.entities;

import edu.oakland.cse280.bscd.Settings;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Hero extends Mobs
{
	public Hero(Bitmap sheet, int direction, Rect starting_position)
	{
		super(sheet, direction, starting_position);
	}

	public void move(int x, int y, int direction)
	{
		location.left += x;
		location.top += y;

		location.right = location.left + Settings.TOON_WIDTH;
		location.bottom = location.top + Settings.TOON_HEIGHT;

		this.direction = direction;
	}
}
