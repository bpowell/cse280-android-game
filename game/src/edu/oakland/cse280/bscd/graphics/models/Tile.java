package edu.oakland.cse280.bscd.graphics.models;

public class Tile
{
	private int type;
	private Rect location;

	public Tile(int type, Rect location)
	{
		this.type = type;
		this.location = location;
	}

	public int getType()
	{
		return this.type;
	}

	public Rect getLocation()
	{
		return this.location;
	}
}
