package edu.oakland.cse280.bscd;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import edu.oakland.cse280.bscd.DatabaseHandler;
import edu.oakland.cse280.bscd.entities.Hero;

public class LoadScreen extends Activity
{
    private TextView save1;
    private TextView save2;
    private TextView save3;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;
    private DatabaseHandler db;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.load_screen);
        save1 = (TextView)findViewById(R.id.save1);
        save2 = (TextView)findViewById(R.id.save2);
        save3 = (TextView)findViewById(R.id.save3);

        db = new DatabaseHandler(this);
      //  if (db.getHerosCount() < 1) 
      //  {
      //      for(int i=0;i<100;i++)
      //      Log.d("Insert: ", "Inserting ..");
      //      db.addHero(new Hero(1, "Bob", 2));
      //      db.addHero(new Hero(2, "Ted", 5));
      //    //  db.addHero(new Hero(3, "Johnny", 1));
      //  }

        List<Hero> heros = db.getAllHeros();       
 
        for (Hero h : heros) {
            switch(h.getId())
            {
                case 1:
                {
                    hero1 = new Hero(h.getId(), h.getName(), h.getLevel());
                    break;
                }
                case 2:
                {
                    hero2 = new Hero(h.getId(), h.getName(), h.getLevel());
                    break;
                }
                case 3:
                {
                    hero3 = new Hero(h.getId(), h.getName(), h.getLevel());
                    break;
                }
            }
    }
        // diplay the save information on the buttons
        if(hero1 != null)
            save1.setText(hero1.getName()+"\r\nLevel: " + hero1.getLevel());
        else
            save1.setText("New Game");
        if(hero2 != null)
            save2.setText(hero2.getName()+"\r\nLevel: " + hero2.getLevel());
        else
            save2.setText("New Game");
        if(hero3 != null)
            save3.setText(hero3.getName()+"\r\nLevel: " + hero3.getLevel());
        else
            save3.setText("New Game");
	}

    public void save1(View view)
    {
        if(hero1 == null) // add a new hero to the database if it is a new game
            db.addHero(new Hero(1, "hero1", 1));
        for(int i=0;i<10;i++)
            Log.i("save1 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
        this.finish();
    }
    
    public void save2(View view)
    {
        if(hero2 == null)// add a new hero to the database if it is a new game
            db.addHero(new Hero(2, "hero2", 1));
        for(int i=0;i<10;i++)
            Log.i("save2 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
        this.finish();
    }

    public void save3(View view)
    { 
        if(hero3 == null)// add a new hero to the database if it is a new game
            db.addHero(new Hero(3, "hero3", 1));
        for(int i=0;i<10;i++)
            Log.i("save3 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
        this.finish();
    }


}
