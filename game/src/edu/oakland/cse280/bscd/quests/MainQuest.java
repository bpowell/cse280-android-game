package edu.oakland.cse280.bscd.quests;

import edu.oakland.cse280.bscd.graphics.entities.NPC;

import android.content.Context;
import android.widget.Toast;

public class MainQuest extends Quest
{
	private Context context;
	private NPC quest_giver;
	private boolean is_started;

	public MainQuest(Context context, String name, int progress, NPC giver)
	{
		super(name, progress);
		this.context = context;
		this.quest_giver = giver;
		is_started = false;
	}

	public void start_quest()
	{
		is_started = true;
		Toast.makeText(context, "...", Toast.LENGTH_LONG).show();
	}
}
