package com.netcompss.test16;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Video;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShareExampleActivity extends Activity  {
	final String TAG = "Share Example";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.main);
	      
	      Button share = (Button)findViewById(R.id.shareButton);
	      share.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		Log.d("Share Example", "Share button is clicked");
	        		String outputFile = "/sdcard/v.mp4";
	        		Log.d("Share Example", "outputFileURL: " + outputFile);
	        		
	        		ContentValues content = new ContentValues(4);
	        	    content.put(Video.VideoColumns.TITLE, "My Test");
	        	    content.put(Video.VideoColumns.DATE_ADDED,
	        	    System.currentTimeMillis() / 1000);
	        	    content.put(Video.Media.MIME_TYPE, "video/mp4");
	        	    content.put(MediaStore.Video.Media.DATA, outputFile);
	        	    ContentResolver resolver = getContentResolver();
	        	    Uri uri = resolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
	        	    content);
	        	    
	        	    Intent intent = new Intent(Intent.ACTION_SEND);
	        	    intent.setType("video/*");
	        		intent.putExtra(Intent.EXTRA_STREAM, uri);
	        		startActivity(Intent.createChooser(intent, "Share using"));
	        	}
	        });
	      
				
	}

	



}
