package edu.oakland.cse280.bscd.models;

import android.graphics.Bitmap;

public class Tiles
{
	private int tile_type;
	private int x;
	private int y;

	public int getTile_type()
	{
		return this.tile_type;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public Tiles(int tile_type, int x, int y)
	{
		this.tile_type = tile_type;
		this.x = x;
		this.y = y;
	}
}
