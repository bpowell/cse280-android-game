package edu.oakland.cse280.bscd.models;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

public class ClipTiles
{
	private ArrayList<Bitmap> cliptiles;

	private int TILE_WIDTH;
	private int TILE_HEIGHT;

	public ClipTiles(Bitmap sheet, int rows, int cols)
	{
		TILE_WIDTH = 80;
		TILE_HEIGHT = 80;
		cliptiles = new ArrayList<Bitmap>();

		Log.i("HSDHASKDHASKDHASKDHASKDHA", "SIZE OF sheet: " + sheet.getHeight() + " " + sheet.getWidth());

		int i, j;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				cliptiles.add(Bitmap.createBitmap(sheet, j*TILE_WIDTH, i*TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT));
			}
		}
	}

	public void draw(Canvas canvas, Tiles tile)
	{
		Bitmap b = cliptiles.get(tile.getTile_type());
		canvas.drawBitmap(b, tile.getX(), tile.getY(), null);
	}
}
