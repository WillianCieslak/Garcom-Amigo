package com.cliente.view;

import com.view.garcom.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends Activity implements Runnable {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		final ImageView splashImage = (ImageView) findViewById(R.id.imageView1);
		splashImage.setBackgroundResource(R.drawable.carregar);
		final AnimationDrawable frameAnimation = (AnimationDrawable) splashImage
				.getBackground();

		splashImage.post(new Runnable() {
			@Override
			public void run() {
				frameAnimation.start();
			}
		});

		Handler handler = new Handler();
		handler.postDelayed(this, 3000);

	}

	@Override
	public void run() {
		startActivity(new Intent(this, MainActivity.class));
		finish();

	}

}
