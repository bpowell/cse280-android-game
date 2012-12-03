package edu.oakland.cse280.bscd;

import edu.oakland.cse280.bscd.entities.Hero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainGameActivity extends Activity
{

    private Hero hero = new Hero();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Bundle b = this.getIntent().getExtras();
        Integer hero_number = (Integer)b.get("hero");

		setContentView(new Game(this, hero_number));
	}

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(MainGameActivity.this, LoadScreen.class);
        startActivity(intent);
        this.finish();
    }
}
