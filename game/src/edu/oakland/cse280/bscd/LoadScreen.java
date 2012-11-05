package edu.oakland.cse280.bscd;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoadScreen extends Activity
{
    private TextView save1;
    private TextView save2;
    private TextView save3;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.load_screen);
        save1 = (TextView)findViewById(R.id.save1);
        save2 = (TextView)findViewById(R.id.save2);
        save3 = (TextView)findViewById(R.id.save3);

        save1.setText("Hero 1\r\nLevel 1\r\n");
        save2.setText("New Game");
        save3.setText("New Game");
	}

    public void save1(View view)
    {
        for(int i=0;i<10;i++)
            Log.i("save1 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
    }
    
    public void save2(View view)
    {
        for(int i=0;i<10;i++)
            Log.i("save2 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
    }

    public void save3(View view)
    {
        for(int i=0;i<10;i++)
            Log.i("save3 ", "was Clicked");
        Intent i = new Intent(LoadScreen.this, MainGameActivity.class);                      
        startActivity(i);
    }


}
