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
	}

    public void part1()
    {
        Toast.makeText(context, "Mayor - Hello. I do not recall seeing you around here before.", Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Mayor - It is a pleasure to meet you. You're a traveler? I see. Well, welcome to...", Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Mayor - My city! ... It is destroyed! What could have caused such destruction in such a short period of time?!?!?", Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Mayor - Where is my son? How could everyone disappear like that?!?!? Could you investigate this for me?", Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Mayor - I have a suspicion that the old abandoned dungeon might have something to do with this. Please check it out!", Toast.LENGTH_LONG).show();
    }

}
