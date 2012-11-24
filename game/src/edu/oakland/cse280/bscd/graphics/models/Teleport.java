package edu.oakland.cse280.bscd.graphics.models;

import edu.oakland.cse280.bscd.Settings;

import android.graphics.Rect;

public class Teleport
{
	private Rect tile;
	private String map;
	private Rect hero;

	public Teleport(Rect tile, String map, Rect hero)
	{
		this.tile = new Rect();
		this.hero = new Rect();
		this.tile = tile;
		this.map = map;
		this.hero = hero;
	}

	public Teleport(int tx, int ty, String map, Rect hero)
	{
		this.tile = new Rect();
		this.hero = new Rect();
		this.tile.top = ty;
		this.tile.left = tx;
		this.tile.right = tile.left+Settings.TILE_WIDTH;
		this.tile.bottom = tile.top+Settings.TILE_HEIGHT;

		this.map = map;
		this.hero = hero;
	}

	public Teleport(int tx, int ty, String map, int hx, int hy)
	{
		this.tile = new Rect();
		this.hero = new Rect();

		this.tile.top = ty;
		this.tile.left = tx;
		this.tile.right = tile.left+Settings.TILE_WIDTH;
		this.tile.bottom = tile.top+Settings.TILE_HEIGHT;

		this.map = map;

		this.hero.top = hy;
		this.hero.left = hx;
		this.hero.right = hero.left+Settings.TOON_WIDTH;
		this.hero.bottom = hero.top+Settings.TOON_HEIGHT;
	}

	public Rect getTile()
	{
		return this.tile;
	}

	public void setTile(Rect  tile)
	{
		this.tile = tile;
	}

	public String getMap()
	{
		return this.map;
	}

	public void setMap(String  map)
	{
		this.map = map;
	}

	public Rect getHero()
	{
		return this.hero;
	}

	public void setHero(Rect  hero)
	{
		this.hero = hero;
	}
}
