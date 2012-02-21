package com.aniXification.android.lovemeter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

	// mediaplayer variable
	MediaPlayer mysong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// FULLSCREEN!!!!
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// set the splash content
		setContentView(R.layout.splash);

		// Add some sound
		mysong = MediaPlayer.create(SplashActivity.this, R.raw.splash_sound);

		// Preferences come here!
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if (music == true)
			mysong.start();

		// thread
		Thread timer = new Thread() {
			public void run() {
				try {
					// application sleep for 1.5 seconds
					sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent menuSelectionWindow = new Intent(
							"com.aniXification.android.lovemeter.MenuSelectionActivity");
					startActivity(menuSelectionWindow);
				}
			}
		};
		timer.start();
	}

	// to kill the SplashActivity when other Activity is shown
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		// release the music
		mysong.release();

		// kill the Activity
		finish();
	}
}
