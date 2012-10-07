package edu.oakland.cse280.bscd.models;

import android.content.res.AssetManager;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.ArrayList;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.oakland.cse280.bscd.R;

public class Map
{
	private String map_name;
	private int MAP_HEIGHT;
	private int MAP_WIDTH;
	private int player_location_x;
	private int player_location_y;
	private AssetManager assetMan;
	private ArrayList<Tiles> tiles;
	private ClipTiles clip;

	public Map(Context context, AssetManager assetMan, String map_name, int player_location_x, int player_location_y)
	{
		this.assetMan = assetMan;
		this.map_name = map_name;
		this.player_location_x = player_location_x;
		this.player_location_y = player_location_y;

		StringBuffer raw_file = new StringBuffer();
		InputStream is;
		try{
			is = assetMan.open(map_name);
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			if(is!=null)
			{
				String temp = "";
				while( (temp= bf.readLine()) != null)
				{
					raw_file.append(temp+"\n");
				}
			}
			bf.close();
			is.close();

			String[] lines = raw_file.toString().split("\n");
			if(lines.length<3)
			{
				Log.d("LENGTH", "NOT BIG ENOUGH");
				return;
			}

			raw_file = null;

			String tileset_name = lines[0];
			MAP_WIDTH = Integer.parseInt(lines[1].split(",")[0]);
			MAP_HEIGHT = Integer.parseInt(lines[1].split(",")[1]);

			Bitmap tile_sheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles);
			clip = new ClipTiles(tile_sheet, 1, 4);

			int base[][] = new int[MAP_HEIGHT][MAP_WIDTH];

			int i;
			int j;
			tiles = new ArrayList<Tiles>();
			for(i=2; i<lines.length; i++)
			{
				Log.d("LOOPING", "IN DA LOOP");
				String t[] = lines[i].split(" ");
				for(j=0; j<t.length; j++)
				{
					//base[i][j] = Integer.parseInt(t[j]);
					tiles.add(new Tiles(Integer.parseInt(t[j]), j*120, (i-2)*120));
					Log.d("MAP", "Added ");
				}
			}


		}catch(Exception e)
		{
			Log.d("EXCEPTION!!!!!!!!!", "ERRRRORORRRR");
		}
	}

	public void draw(Canvas canvas)
	{
		if(tiles==null)
			Log.i("WE GOTTA NULL", "NULLLLZZZZ");

		for(int i=0; i<tiles.size(); i++)
		{
			clip.draw(canvas, tiles.get(i));
		}
	}
}
