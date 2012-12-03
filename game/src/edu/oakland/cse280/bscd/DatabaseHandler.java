package edu.oakland.cse280.bscd;
 
import java.util.ArrayList;
import java.util.List;

import edu.oakland.cse280.bscd.entities.Hero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "herosManager";
 
    // Heros table name
    private static final String TABLE_HEROS = "heros";
 
    // Heros Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_VIT = "vit";
    private static final String KEY_STRENGTH = "strength";
    private static final String KEY_ATTACK = "attack";
    private static final String KEY_DEFENSE = "defense";
    private static final String KEY_X = "X";
    private static final String KEY_Y = "Y";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {String CREATE_HEROS_TABLE = "CREATE TABLE " + TABLE_HEROS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LEVEL + " TEXT," + KEY_VIT + " TEXT" + KEY_STRENGTH + "TEXT" + KEY_ATTACK + "TEXT"
                + KEY_DEFENSE + "TEXT" + KEY_X + "TEXT" + KEY_Y + "TEXT" + ")";
        db.execSQL(CREATE_HEROS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HEROS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new hero
    void addHero(Hero hero) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, hero.getId()); // Hero ID
        values.put(KEY_NAME, hero.getName()); // Hero Name
        values.put(KEY_LEVEL, hero.getLevel()); // Hero Level
        values.put(KEY_VIT, hero.getVit());// hero vitality
        values.put(KEY_STRENGTH, hero.getStrength());// hero vitality
        values.put(KEY_ATTACK, hero.getAttack());// hero vitality
        values.put(KEY_DEFENSE, hero.getDefense());// hero vitality
        values.put(KEY_X, hero.getX());// hero vitality
        values.put(KEY_Y, hero.getY());// hero vitality
 
        // Inserting Row
        db.insert(TABLE_HEROS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single hero
    Hero getHero(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_HEROS, new String[] { KEY_ID,
                KEY_NAME, KEY_LEVEL, KEY_VIT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Hero hero = new Hero(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)));
        // return hero
        return hero;
    }
 
    // Getting All Heros
    public List<Hero> getAllHeros() {
        List<Hero> heroList = new ArrayList<Hero>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HEROS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                for(int i=0;i<10;i++)
                    Log.i("ajdfjaihfhwaedrfahwfoawofedjwa", ""+Integer.parseInt(cursor.getString(3)));
                Hero hero = new Hero();
                hero.setId(Integer.parseInt(cursor.getString(0)));
                hero.setName(cursor.getString(1));
                hero.setLevel(Integer.parseInt(cursor.getString(2)));
                hero.setVit(Integer.parseInt(cursor.getString(3)));
                hero.setStrength(Integer.parseInt(cursor.getString(4)));
                hero.setAttack(Integer.parseInt(cursor.getString(5)));
                hero.setDefense(Integer.parseInt(cursor.getString(6)));
                hero.setX(Integer.parseInt(cursor.getString(7)));
                hero.setY(Integer.parseInt(cursor.getString(8)));
                // Adding hero to list
                heroList.add(hero);
            } while (cursor.moveToNext());
        }
 
        // return hero list
        return heroList;
    }
 
    // Updating single hero
    public int updateHero(Hero hero) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, hero.getId());
        values.put(KEY_NAME, hero.getName());
        values.put(KEY_LEVEL, hero.getLevel());
        values.put(KEY_VIT, hero.getVit());
        values.put(KEY_STRENGTH, hero.getStrength());
        values.put(KEY_ATTACK, hero.getAttack());
        values.put(KEY_DEFENSE, hero.getDefense());
        values.put(KEY_X, hero.getX());
        values.put(KEY_Y, hero.getY());
 
        // updating row
        return db.update(TABLE_HEROS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(hero.getId()) });
    }
 // Deleting single hero
    public void deleteHero(Hero hero) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HEROS, KEY_ID + " = ?",
                new String[] { String.valueOf(hero.getId()) });
        db.close();
    }
 
    // Getting heros Count
    public int getHerosCount() {
        String countQuery = "SELECT  * FROM " + TABLE_HEROS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}
