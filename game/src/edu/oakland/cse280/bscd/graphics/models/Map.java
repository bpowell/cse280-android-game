package edu.oakland.cse280.bscd.graphics.models;

import edu.oakland.cse280.bscd.Settings;

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
	private Settings settings;

	private String map_name;
	private int MAP_HEIGHT;
	private int MAP_WIDTH;

	private int NUM_ROWS_TILES;
	private int NUM_COLS_TILES;

	private String data[];
	private int map_id;
	private ClipTiles clips;
	private ArrayList<Tile> tiles;
	private ArrayList<Tile> loaded_tiles;
	private ArrayList<Integer> non_passable_tiles;
	private ArrayList<Teleport> teleport;
	private int fight_chance;

	private Rect player_location;

	private Context context;

	public Map(Context context, String map_name, Rect player_location)
	{
		this.context = context;
		this.map_name = map_name;
		this.player_location = player_location;

		loaded_tiles = new ArrayList<Tile>();
		non_passable_tiles = new ArrayList<Integer>();
		teleport = new ArrayList<Teleport>();

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


		String tmp[] = data[2].split(",");
		int i=0;
		for(i=0; i<tmp.length; i++)
		{
			non_passable_tiles.add(Integer.parseInt(tmp[i]));
		}

		String tele[] = data[3].split(":");
		for(i=0; i<tele.length; i++)
		{
			String info[] = tele[i].split(",");
			int tx, ty;
			String tm;
			int hx, hy;

			tx=Integer.parseInt(info[0]);
			ty=Integer.parseInt(info[1]);
			tm=info[2];
			hx=Integer.parseInt(info[3]);
			hy=Integer.parseInt(info[4]);

			teleport.add(new Teleport(tx,ty,tm,hx,hy));
		}

		fight_chance = Integer.parseInt(data[4]);

		MAP_WIDTH = Integer.parseInt(data[5].split(",")[0]);
		MAP_HEIGHT = Integer.parseInt(data[5].split(",")[1]);

		map_id = context.getResources().getIdentifier(tileset_name, "drawable", context.getPackageName());
	}

	private void load_data()
	{
		Bitmap tile_sheet = BitmapFactory.decodeResource(context.getResources(), map_id);
		clips = new ClipTiles(tile_sheet, NUM_ROWS_TILES, NUM_COLS_TILES);

		int base[][] = new int[MAP_HEIGHT][MAP_WIDTH];

		int i, j;
		tiles = new ArrayList<Tile>();
		for(i=6; i<data.length; i++)
		{
			String t[] = data[i].split(" ");
			for(j=0; j<t.length; j++)
			{
				tiles.add(new Tile(Integer.parseInt(t[j]), new Rect(j*settings.TILE_WIDTH, (i-4)*settings.TILE_HEIGHT, (j*settings.TILE_WIDTH)+settings.TILE_WIDTH, ((i-4)*settings.TILE_HEIGHT)+settings.TILE_HEIGHT)));
			}
		}
	}

	public void draw(Canvas canvas)
	{
		if(tiles == null)
			return;

		Rect coords = canvas.getClipBounds();
		coords.bottom += 100;
		coords.right += 100;
		coords.left -= 100;
		coords.top -= 100;

		loaded_tiles.clear();

		for(int i=0; i<tiles.size(); i++)
		{
			Tile tile = tiles.get(i);

			Rect location = tile.getLocation();

			if( (location.left>=coords.left) && (location.right<=coords.right) && (location.bottom<=coords.bottom) && (location.top>=coords.top) )
			{
				clips.draw(canvas, tile);
				loaded_tiles.add(tile);
			}
		}
	}

	public int getHeight()
	{
		return MAP_HEIGHT;
	}

	public int getWidth()
	{
		return MAP_WIDTH;
	}

	public ArrayList getLoaded_tiles()
	{
		return (ArrayList)loaded_tiles.clone();
	}

	public ArrayList getNon_passable_tiles()
	{
		return non_passable_tiles;
	}

	public ArrayList getTeleports()
	{
		return teleport;
	}

	public int getFight_chance()
	{
		return this.fight_chance;
	}

	public void setFight_chance(int  fight_chance)
	{
		this.fight_chance = fight_chance;
	}
}
