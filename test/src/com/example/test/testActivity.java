package com.example.test;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class  testActivity extends Activity{
		private List<listcontent> contentlist=new ArrayList<listcontent>();
		private EditText editText;
		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.list);
			intlistcontent();
			listsimpleadapter adapter=new  listsimpleadapter(testActivity.this , R.layout.list2,contentlist);
			
			ListView listView=(ListView)findViewById(R.id.list);
			  
		       
			listView.setAdapter(adapter);
			 editText = (EditText) findViewById(R.id.edit_text);
			Button restoreData = (Button) findViewById(R.id.aa);
			Button saveData = (Button) findViewById(R.id.bb);
			Button change = (Button) findViewById(R.id.cc);
			change.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				    Intent intent =  new Intent();
					
					intent.setClass(testActivity. this, send. class);
					
					startActivity(intent);
					
					testActivity. this.finish();
				}
				});
			 
			saveData.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				SharedPreferences.Editor editor = getSharedPreferences("data",
				MODE_PRIVATE).edit();
				editor.putString("name", "Tom");
				editor.putInt("age", 28);
				editor.putBoolean("married", false);
				editor.commit();
				}
				});

			restoreData.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			SharedPreferences pref = getSharedPreferences("data",
			MODE_PRIVATE);
			String name = pref.getString("name", "");
			int age = pref.getInt("age", 0);
			boolean married = pref.getBoolean("married", false);
			Log.d("MainActivity", "name is " + name);
			Log.d("MainActivity", "age is " + age);
			Log.d("MainActivity", "married is " + married);
			}
			});

			 
	}
		
		private void intlistcontent(){
			listcontent a=new listcontent(R.string.a);
			contentlist.add(a);
			listcontent b=new listcontent(R.string.b);
			contentlist.add(b);
			listcontent c=new listcontent(R.string.c);
			contentlist.add(c);
		}
		
		}



