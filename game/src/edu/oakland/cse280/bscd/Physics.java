package edu.oakland.cse280.bscd;

import android.graphics.Rect;

public class Physics
{
	public static boolean check_collision(Rect a, Rect b)
	{
		if(a.bottom<=b.top)
			return false;
		if(a.top>=b.bottom)
			return false;
		if(a.right<=b.left)
			return false;
		if(a.left>=b.right)
			return false;

		return true;
	}
}
