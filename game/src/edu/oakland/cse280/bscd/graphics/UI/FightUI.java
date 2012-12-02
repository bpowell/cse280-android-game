package edu.oakland.cse280.bscd.graphics.UI;

import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Paint;

public class FightUI
{
	private String FIGHT;
	private String ITEM;
	private String RUN;
	private String HERO_HP;
	private String MOB_HP;
	private String HP;
	private int text_height;
	private int text_width;
	private Paint text_style;
	private Paint mob_paint;

	private Bitmap MOB_IMG;

	private Rect FIGHT_LOC;
	private Rect ITEM_LOC;
	private Rect RUN_LOC;

	public FightUI()
	{
		FIGHT = "Fight";
		ITEM = "Item";
		RUN = "Run";
		HP = "HP: ";

		text_height = 22;
		text_width = 42;
		text_style = new Paint();
		text_style.setARGB(200, 0,0,0);
		text_style.setTextSize(text_height);

		FIGHT_LOC = new Rect();
		ITEM_LOC = new Rect();
		RUN_LOC = new Rect();

		HERO_HP = "00";
		MOB_HP = "00";
		mob_paint = null;
	}

	public void draw(Canvas canvas)
	{
		Rect clip = canvas.getClipBounds();
		int bottom_offset = 20;
		int left_offset = 10;
		int space = 100;

		FIGHT_LOC.bottom = clip.bottom - bottom_offset;
		FIGHT_LOC.top = FIGHT_LOC.bottom - text_height;
		FIGHT_LOC.left = left_offset;
		FIGHT_LOC.right = left_offset + text_width;

		ITEM_LOC.bottom = clip.bottom - bottom_offset;
		ITEM_LOC.top = ITEM_LOC.bottom - text_height;
		ITEM_LOC.left = space + left_offset;
		ITEM_LOC.right = space + left_offset + text_width;

		RUN_LOC.bottom = clip.bottom - bottom_offset;
		RUN_LOC.top = RUN_LOC.bottom - text_height;
		RUN_LOC.left = 2 * space + left_offset;
		RUN_LOC.right = 2 * space + left_offset + text_width;

		canvas.drawText(FIGHT, FIGHT_LOC.left, FIGHT_LOC.top, text_style);
		canvas.drawText(ITEM, ITEM_LOC.left, ITEM_LOC.top, text_style);
		canvas.drawText(RUN, RUN_LOC.left, RUN_LOC.top, text_style);

		//HP
		int hp_offset = 10;
		canvas.drawText(HP, 0,0, text_style);
		canvas.drawText(MOB_HP, clip.left + hp_offset, 
				clip.top + hp_offset, text_style);
		canvas.drawText(HERO_HP, clip.left + hp_offset,
				clip.top + 2 * text_height, text_style);

		//Mob image
		//canvas.drawBitmap(MOB_IMG, clip.left+ text_width + hp_offset,
				//clip.top + hp_offset, mob_paint);
		
	}

	public Rect getFIGHT_LOC()
	{
		return this.FIGHT_LOC;
	}

	public Rect getITEM_LOC()
	{
		return this.ITEM_LOC;
	}

	public Rect getRUN_LOC()
	{
		return this.RUN_LOC;
	}
}
