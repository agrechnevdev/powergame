package com.pow3r.game;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.pow3r.managers.DataBase;

public class AndroidLauncher extends AndroidApplication {

    /*private AdView adView;
    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-8578300064930131/7609191408";
    private Integer version;*/
    SQLiteOpenHelper db_connection;
    SQLiteDatabase stmt;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databaseTest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        config.numSamples = 2;
        DataBase dataBase = new DatabaseAndroid(this.getBaseContext());
        //dataBase.closeDB();
        initialize(new StartGame(dataBase), config);
        //View gameView = initializeForView(new StartGame(dataBase), config);

      	/*setupAds();
		RelativeLayout layout = new RelativeLayout(this);
		layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		layout.addView(adView, params);
		setContentView(layout);*/
    }

    public long insertUnit(String name, Integer pow1, Integer pow2, Integer pow3, String descr){
        SQLiteStatement insertStmt = this.stmt.compileStatement("INSERT INTO unit (name, pow1, pow2, pow3, descr) VALUES (?,?,?,?,?)");
        insertStmt.bindString(1, name);
        insertStmt.bindLong(2, pow1);
        insertStmt.bindLong(3, pow2);
        insertStmt.bindLong(4, pow3);
        insertStmt.bindString(5, descr);
        return insertStmt.executeInsert();
    }

	/*public void setupAds() {
		adView = new AdView(this);
		adView.setAdUnitId(BANNER_AD_UNIT_ID);
		adView.setVisibility(View.INVISIBLE);
		adView.setAdSize(AdSize.SMART_BANNER); //������ �������
	}

	@Override
	public void showBannerAd() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adView.setVisibility(View.VISIBLE);
				AdRequest adRequest = new AdRequest.Builder().build();
				adView.loadAd(adRequest);
			}
		});

	}

	@Override
	public void hideBannerAd() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adView.setVisibility(View.INVISIBLE);
			}
		});

	}*/

}