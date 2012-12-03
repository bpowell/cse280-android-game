package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.entities.EnemyMob;

import edu.oakland.cse280.bscd.graphics.UI.FightUI;
import edu.oakland.cse280.bscd.entities.Hero;

import android.content.Context;
import android.util.Log;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fight
{
	private ArrayList<EnemyMob> enemyMob;
	private Context context;
	private String data[];

	public Fight(Context context)
	{
		this.context = context;
		enemyMob = new ArrayList<EnemyMob>();

		open_enemy_file();
		read_data();
	}

	private void open_enemy_file()
	{
		StringBuffer sb = new StringBuffer();
		InputStream is;

		try
		{
			is = context.getAssets().open("enemy.txt");
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
			Log.e("Fight/open_map_file", "Cannot open enemy.txt for reading.\n");
		}
	}

	private void read_data()
	{
		String line;
		int i;
		
		for(i = 0; i<data.length; i++)
		{
			String e[] = data[i].split(",");
			int t[] = new int[10];

			for(int j=1; j<e.length; j++)
				t[j-1] = Integer.parseInt(e[j]);

			enemyMob.add(new EnemyMob(0, e[0], t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9]));
		}
	}

	public boolean check_for_fight(int fight_chance)
	{
		Random r = new Random();
		int n = r.nextInt(1000);

		if( n < (fight_chance * 100) )
			return true;

		return false;
	}

	public EnemyMob fight_who()
	{
		Random r = new Random();
		int who = r.nextInt(enemyMob.size());

		return enemyMob.get(who).copy();
	}

	public EnemyMob prepare_fight(FightUI fightUI, int hero_hp)
	{
		EnemyMob who = fight_who();
		fightUI.setup_fight(who.getName(), Integer.toString(who.getHP()), Integer.toString(hero_hp), who.getR(), who.getG(), who.getB());
		return who;
	}

	public void update_fight(FightUI fightUI, String mob, String hero)
	{
		fightUI.update(mob, hero);
	}
}
