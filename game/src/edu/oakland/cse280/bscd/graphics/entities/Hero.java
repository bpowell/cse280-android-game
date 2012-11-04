package edu.oakland.cse280.bscd.graphics.entities;

import edu.oakland.cse280.bscd.Settings;
import edu.oakland.cse280.bscd.Physics;
import edu.oakland.cse280.bscd.graphics.models.Tile;

import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;

public class Hero extends Mobs
{
	Rect old_location;

	public Hero(Bitmap sheet, int direction, Rect starting_position)
	{
		super(sheet, direction, starting_position);
		old_location = starting_position;
	}

	public synchronized void move(int x, int y, int direction, ArrayList<Tile> tiles, ArrayList<Integer> blocking)
	{
		old_location = new Rect(location);

		location.left += x;
		location.top += y;

		location.right = location.left + Settings.TOON_WIDTH;
		location.bottom = location.top + Settings.TOON_HEIGHT;

		synchronized(this)
		{
			for(Tile tile : tiles)
			{
				if(blocking.contains(tile.getType()) && Physics.check_collision(tile.getLocation(), location))
				{
					location = old_location;
					Log.d("SHFSDHFKSDJHFSKDHF", "SHOULD BE MOVED BACK: " + tile.getType() + "," );
				}
			}
		}

		this.direction = direction;
	}

	public void draw(Canvas canvas)
	{
		Bitmap hero = image.get(direction);
		canvas.drawBitmap(hero, location.left, location.top, null);
	}
}
