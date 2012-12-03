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

		setContentView(new Game(this));

        Bundle b = this.getIntent().getExtras();
        hero = (Hero)b.get("hero");

        for (int j=0; j<20; j++)
            Log.i("hero ", "name = " +  hero.getName() + "id = " + hero.getId());
	}

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(MainGameActivity.this, LoadScreen.class);
        startActivity(intent);
        this.finish();
    }
}
