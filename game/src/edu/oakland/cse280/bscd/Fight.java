package edu.oakland.cse280.bscd;

public class Fight
{
	public boolean check_for_fight(int fight_chance)
	{
		Random r = new Random();
		int n = r.nextInt(1000);

		if( n < (fight_chance * 100) )
			return true;

		return false;
	}
}
