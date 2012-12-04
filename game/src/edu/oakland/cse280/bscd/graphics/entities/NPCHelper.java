package edu.oakland.cse280.bscd.graphics.entities;

import android.graphics.Rect;

public class NPCHelper
{
	public boolean near_npc(Rect hero, Rect npc)
	{
		int offset = 90;
		Rect tmp = new Rect(hero);
		tmp.top -= offset;
		tmp.bottom += offset;
		tmp.left -= offset;
		tmp.right += offset;

		return Rect.intersects(hero,npc);
	}
}
