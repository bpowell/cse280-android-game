package edu.oakland.cse280.bscd.graphics.models;

import edu.oakland.cse280.bscd.Settings;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

public class ClipTiles
{
	private ArrayList<Bitmap> cliptiles;
	private Settings settings;

	public ClipTiles(Bitmap sheet, int rows, int cols)
	{
		cliptiles = new ArrayList<Bitmap>();

		int i, j;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				cliptiles.add(Bitmap.createBitmap(sheet, j*settings.TILE_WIDTH, i*settings.TILE_HEIGHT, settings.TILE_WIDTH, settings.TILE_HEIGHT));
			}
		}
	}

	public void draw(Canvas canvas, Tile tile)
	{
		Bitmap b = cliptiles.get(tile.getType());
		canvas.drawBitmap(b, tile.getLocation().left, tile.getLocation().top, null);
	}
}
