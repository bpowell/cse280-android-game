package edu.oakland.cse280.bscd.graphics.models;

import android.content.Context;
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

	private Rect player_location;

	private Context context;

	public Map(Context context, String map_name, Rect player_location)
	{
		this.context = context;
		this.map_name = map_name;
		this.player_location = player_location;

		String data[] = open_map_file();
	}

	private String[] open_map_file()
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

			String[] data = sb.toString().split("\n");

			return data;
		}
		catch(Exception e)
		{
			Log.d("Map/open_map_file", "Failed to read map file.");
			return null;
		}
	}
}
