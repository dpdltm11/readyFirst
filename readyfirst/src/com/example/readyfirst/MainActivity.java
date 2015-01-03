package com.example.readyfirst;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private FragmentTabHost mTabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("주행모드").setIndicator("주행모드", null),
                driveMode.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("분석모드").setIndicator("분석모드", null),
                analysisMode.class, null);
        
        //ActionBar 배경색 설정
        //this.getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00B6E2")));
        ActionBar bar = getSupportActionBar();
        //for color
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00B6E2")));
        //for image
        //bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.settings_icon));
        
        //tabview의 Text 크기 및 색깔 설정
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {

        	mTabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 200;
        	
	        final TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i)
	                .findViewById(android.R.id.title);

	            // Look for the title view to ensure this is an indicator and not a divider.(I didn't know, it would return divider too, so I was getting an NPE)
	        if (tv == null)
	            continue;
	        else
	        {
	        	tv.setTextSize(15);
	            tv.setTextColor(Color.WHITE);
	        }
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
