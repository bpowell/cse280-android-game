package edu.oakland.cse280.bscd.quests;

import edu.oakland.cse280.bscd.graphics.entities.NPC;

public class MainQuest extends Quest
{
	private NPC quest_giver;

	public MainQuest(String name, int progress, NPC giver)
	{
		super(name, progress);
		this.quest_giver = giver;

		quest_giver.set_is_talking(true);
		quest_giver.setSpeech("Yo dawg");
	}
}
