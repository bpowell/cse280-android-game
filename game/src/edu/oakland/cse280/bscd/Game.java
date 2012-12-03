package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.graphics.entities.GHero;
import edu.oakland.cse280.bscd.entities.Hero;
import edu.oakland.cse280.bscd.entities.EnemyMob;
import edu.oakland.cse280.bscd.graphics.entities.NPC;
import edu.oakland.cse280.bscd.graphics.models.Map;
import edu.oakland.cse280.bscd.graphics.models.Teleport;
import edu.oakland.cse280.bscd.graphics.UI.UIButtons;
import edu.oakland.cse280.bscd.graphics.UI.FightUI;
import edu.oakland.cse280.bscd.quests.MainQuest;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	private GameThread game_loop;
	private GHero ghero;
	private Hero hero;
	private EnemyMob enemy;
	private NPC mayor;
	private Map map;
	private MainQuest mainQuest;
	private UIButtons ui_buttons;
	private FightUI fight_ui;
	private Fight fight;

	private Context context;
	private int SCREEN_WDITH;
	private int SCREEN_HEIGHT;

	private boolean IS_FIGHTING;
	private boolean DEAD;
	private boolean WIN;

	public Game(Context context)
	{
		super(context);
		getHolder().addCallback(this);

		this.context = context;

		fight_ui = new FightUI(context);

		ghero = new GHero(BitmapFactory.decodeResource(getResources(), R.drawable.hero), 0, new Rect(0, 90, Settings.TOON_WIDTH, 2*Settings.TOON_HEIGHT));
		hero = new Hero(0, "Hero", 10, 10, 10, 10);
		mayor = new NPC(BitmapFactory.decodeResource(getResources(), R.drawable.mayor), 0, new Rect(18*90, 2*90, 18*90+Settings.TOON_WIDTH, 2*90+Settings.TOON_HEIGHT));
		map = new Map(context, "map02.txt", ghero.getLocation());
		mainQuest = new MainQuest("main quest", 0, mayor);
		ui_buttons = new UIButtons(context);
		setFocusable(true);
		fight = new Fight(context);

		IS_FIGHTING = false;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		if(game_loop == null || !game_loop.isAlive())
		{
			game_loop = new GameThread(getHolder(), this);
			game_loop.setRunning(true);
		}

		game_loop.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		while(true)
		{
			try
			{
				game_loop.setRunning(false);
				game_loop.join();
				return;
			}
			catch(Exception e)
			{
				Log.d("Game/surfaceDestroyed", "Cannot end game_loop thread.");
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int x,y;
		x = (int)event.getX();
		y = (int)event.getY();

		if( IS_FIGHTING )
		{
			Rect f = fight_ui.getFIGHT_LOC();
			Rect i = fight_ui.getITEM_LOC();
			Rect r = fight_ui.getRUN_LOC();

			if(event.getAction() == MotionEvent.ACTION_DOWN)
			{
				if(r.intersect(x,y,x+20,y+20))
					IS_FIGHTING = false;
				else if(f.intersect(x,y,x+20,y+20))
				{
					if(enemy.getAttack()>hero.getAttack())
					{
						hero.doDamage(enemy.getMin(), enemy.getMax(), enemy.getStrength());
						if(hero.getHP()<=0)
						{
							Toast.makeText(context, "You have died...", Toast.LENGTH_LONG).show();
							IS_FIGHTING = false;
						}
						else 
							enemy.doDamage(1, 10, hero.getStrength());

						if(enemy.getHP()<=0)
						{
							Toast.makeText(context, "You have killed the enemy.", Toast.LENGTH_LONG).show();
							IS_FIGHTING = false;
						}
					}
					else
					{
						enemy.doDamage(1, 10, hero.getStrength());
						if(enemy.getHP()<=0)
						{
							Toast.makeText(context, "You have killed the enemy.", Toast.LENGTH_LONG).show();
							IS_FIGHTING = false;
						}
						else
							hero.doDamage(enemy.getMin(), enemy.getMax(), enemy.getStrength());

						if(hero.getHP()<=0)
						{
							Toast.makeText(context, "You have died...", Toast.LENGTH_LONG).show();
							IS_FIGHTING = false;
						}
					}

					fight.update_fight(fight_ui, Integer.toString(enemy.getHP()), Integer.toString(hero.getHP()));
				}
			}
		}
		else
		{
			Rect dleft = ui_buttons.get_DLEFT();
			Rect dright = ui_buttons.get_DRIGHT();
			Rect dtop  = ui_buttons.get_DTOP();
			Rect dbottom = ui_buttons.get_DBOTTOM();

			Rect a = ui_buttons.get_A();
			Rect b = ui_buttons.get_B();

			boolean check_fight = false;

			Teleport t = null;

			if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction()==MotionEvent.ACTION_MOVE)
			{
				synchronized(this)
				{
					if(dleft.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
						t = ghero.move(-(Settings.TOON_WIDTH/4),0, Settings.TOON_FACE_LEFT, map.getLoaded_tiles(), map.getNon_passable_tiles(), map.getTeleports());
					else if(dright.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
						t = ghero.move((Settings.TOON_WIDTH/4),0, Settings.TOON_FACE_RIGHT, map.getLoaded_tiles(), map.getNon_passable_tiles(), map.getTeleports());
					else if(dtop.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
						t = ghero.move(0,-(Settings.TOON_HEIGHT/4), Settings.TOON_FACE_FRONT, map.getLoaded_tiles(), map.getNon_passable_tiles(), map.getTeleports());
					else if(dbottom.intersect(x,y,x+Settings.DPAD_SIZE,y+Settings.DPAD_SIZE))
						t = ghero.move(0,(Settings.TOON_HEIGHT/4), Settings.TOON_FACE_BACK, map.getLoaded_tiles(), map.getNon_passable_tiles(), map.getTeleports());
				
					check_fight = fight.check_for_fight(map.getFight_chance());
				}
			}

			if(t!=null)
			{
				ghero.setLocation(t.getHero());
				map = new Map(context, t.getMap(), t.getHero());
			}
			else if(check_fight)
			{
				IS_FIGHTING = check_fight;
				enemy = fight.prepare_fight(fight_ui, hero.getHP());
			}
		}

		return true;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		if(game_loop.getRunning()==false)
			return;

		canvas.drawColor(Color.WHITE);

		if( IS_FIGHTING )
		{
			fight_ui.draw(canvas);
		}
		else
		{

			int top, left;

			Rect hero_location = ghero.getLocation();
			Rect canvas_rect = canvas.getClipBounds();
			int mwidth = map.getWidth();
			int mheight = map.getHeight();

			if(hero_location.bottom >= mheight)
				top = -(mheight-2*Settings.TILE_HEIGHT);
			else if(hero_location.top <= (canvas.getHeight()/2))
				top = 0;
			else
				top = -(hero_location.top-(canvas.getHeight()/2));

			if(hero_location.right >= mwidth)
				left = -(mwidth-2*Settings.TILE_WIDTH);
			else if(hero_location.left <= (canvas.getWidth()/2))
				left = 0;
			else
				left = -(hero_location.left-(canvas.getWidth()/2));


			//canvas.translate(-(hero_location.left-(canvas.getWidth()/2)), -(hero_location.top-(canvas.getHeight()/2)));
			canvas.translate(left, top);

			map.draw(canvas);
			mayor.draw(canvas);
			ui_buttons.draw(canvas);
			ghero.draw(canvas);
		}
	}
}
