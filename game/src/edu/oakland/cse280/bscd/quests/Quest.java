package edu.oakland.cse280.bscd.quests;

public class Quest
{
	private String quest_name;
	private int quest_progress;

	public Quest(String name, int progress)
	{
		this.quest_name = name;
		this.quest_progress = progress;
	}
}
