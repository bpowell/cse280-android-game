package edu.oakland.cse280.bscd.models;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class Chunk
{
	private ArrayList<Tiles> tiles = new ArrayList<Tiles>(100);

	public ArrayList getTiles()
	{
		return tiles;
	}

	public Chunk(ArrayList<Tiles> tiles)
	{
		this.tiles = tiles;
	}
}
