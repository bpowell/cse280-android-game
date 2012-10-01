package edu.oakland.cse280.bscd.models;

import android.graphics.Bitmap;

public class Tiles
{
	int tile_type;
	Bitmap image;
	int is_passable;

	public int getTile_type()
	{
		return this.tile_type;
	}

	public Bitmap getImage()
	{
		return this.image;
	}

	public int getIs_passable()
	{
		return this.is_passable;
	}

	public Tiles(Bitmap image, int tile_type, int is_passable)
	{
		this.image = image;
		this.tile_type = tile_type;
		this.is_passable = is_passable;
	}
}
