package com.imgview.fit;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {

	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.img);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
		fitWidth(bitmap, imageView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void fitWidth(Bitmap bitmap, ImageView imageView) {
		int orgWid = bitmap.getWidth();
		int orgHeight = bitmap.getHeight();
		
		int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // ÆÁÄ»¿í£¨ÏñËØ£¬Èç£º480px£©  
//		int screenHeight = getWindowManager().getDefaultDisplay().getHeight(); 		// ÆÁÄ»¸ß£¨ÏñËØ£¬Èç£º800p£© 
		
		int newWid = screenWidth;
		int newHeight = (int) ((double)newWid / (double)orgWid * (double) orgHeight + 0.5f);
		
		LayoutParams params = new LayoutParams(newWid, newHeight);
		imageView.setLayoutParams(params);
	}
}
