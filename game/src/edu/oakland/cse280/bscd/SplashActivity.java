package edu.oakland.cse280.bscd;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

/**
 * Splash screen activity to load the Splash Screen.
 *
 * @author  Skye Schneider
 */
public class SplashActivity extends Activity
{
    private final int SPLASHLENGTH = 4000;

    /**
     * Called when the activity is first created. 
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
    }

    /**
     * Called when the activity is resumed.
     * Sets up a shared preferences manager and tests to see if it is 
     * enabled.
     */
    @Override
    public void onResume()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isSplashEnabled = sp.getBoolean("isSplashEnabled" , true);
        super.onResume();


        if(isSplashEnabled)
        {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run()
                {
                    SplashActivity.this.finish();
                    Intent mainIntent = new Intent(SplashActivity.this, LoadScreen.class);
                    SplashActivity.this.startActivity(mainIntent);              
                }
            }, SPLASHLENGTH);
        }
        else
        {
            finish();
            Intent mainIntent = new Intent(SplashActivity.this, LoadScreen.class);
            SplashActivity.this.startActivity(mainIntent);

        }
    }
}
