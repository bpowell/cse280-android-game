package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.entities.EnemyMob;

import android.content.Context;

import java.util.Random;
import java.util.ArrayList;

public class Fight
{
	ArrayList<EnemyMob> enemyMob;
	Context context;

	public Fight(Context context)
	{
		this.context = context;
		enemyMob = new ArrayList<EnemyMob>();
	}

	public boolean check_for_fight(int fight_chance)
	{
		Random r = new Random();
		int n = r.nextInt(1000);

		if( n < (fight_chance * 100) )
			return true;

		return false;
	}
}
