package edu.oakland.cse280.bscd.graphics.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map
{
	private String map_name;
	private int MAP_HEIGHT;
	private int MAP_WIDTH;

	private int NUM_ROWS_TILES;
	private int NUM_COLS_TILES;

	private String data[];
	private int map_id;
	private ClipTiles clips;
	private ArrayList<Tile> tiles;

	private Rect player_location;

	private Context context;

	public Map(Context context, String map_name, Rect player_location)
	{
		this.context = context;
		this.map_name = map_name;
		this.player_location = player_location;

		open_map_file();
		read_data();
		load_data();
	}

	private void open_map_file()
	{
		StringBuffer sb = new StringBuffer();
		InputStream is;

		try
		{
			is = context.getAssets().open(map_name);
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));

			if(is!=null)
			{
				String temp = "";
				while( (temp=bf.readLine()) != null )
				{
					sb.append(temp+"\n");
				}
			}

			is.close();
			bf.close();

			data = sb.toString().split("\n");
		}
		catch(Exception e)
		{
			Log.d("Map/open_map_file", "Failed to read map file.");
		}
	}

	private void read_data()
	{
		String tileset_name = data[0];
		NUM_ROWS_TILES = Integer.parseInt(data[1].split(",")[0]);
		NUM_COLS_TILES = Integer.parseInt(data[1].split(",")[1]);
		MAP_WIDTH = Integer.parseInt(data[2].split(",")[0]);
		MAP_HEIGHT = Integer.parseInt(data[2].split(",")[1]);

		map_id = context.getResources().getIdentifier(tileset_name, "drawable", context.getPackageName());
	}

	private void load_data()
	{
		Bitmap tile_sheet = BitmapFactory.decodeResource(context.getResources(), map_id);
		clips = new ClipTiles(tile_sheet, NUM_ROWS_TILES, NUM_COLS_TILES);

		int base[][] = new int[MAP_HEIGHT][MAP_WIDTH];

		int i, j;
		tiles = new ArrayList<Tile>();
		for(i=3; i<data.length; i++)
		{
			String t[] = data[i].split(" ");
			for(j=0; j<t.length; j++)
			{
				tiles.add(new Tile(Integer.parseInt(t[j]), new Rect(j*80, (i-3)*80, (j*80)+80, ((i-3)*80)+80)));
			}
		}
	}

	public void draw(Canvas canvas)
	{
		if(tiles == null)
			return;

		Rect coords = canvas.getClipBounds();

		for(int i=0; i<tiles.size(); i++)
		{
			Tile tile = tiles.get(i);

			Rect location = tile.getLocation();

			if( (location.left>=coords.left) && (location.right<=coords.right) && (location.bottom<=coords.bottom) && (location.top>=coords.top) )
				clips.draw(canvas, tile);
		}
	}
}
