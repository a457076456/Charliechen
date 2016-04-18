package com.example.used;


import com.example.used.client.client;
import com.example.used.client.clientoutput;
import com.example.used.unity.contentClass;
import com.example.used.unity.tranObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class searchActivity extends myActivity{
	private clientoutput clientoutput;
	private myApplication myApplication;
	EditText out_content;
	public void  onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		myApplication=(myApplication)this.getApplicationContext();
		setContentView(R.layout.search_layout);
		Intent service = new Intent(this, service.class);
		startService(service);
		Button return_search=(Button)findViewById(R.id.return_search);
		Button comfirn=(Button)findViewById(R.id.search);
		TextView cient_check=(TextView)findViewById(R.id.client_check);
		 out_content=(EditText)findViewById(R.id.search_edit);
		comfirn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(myApplication.isClientStart()){
					client client=myApplication.getClient();
					contentClass msgout=new contentClass();
			        msgout.toUser=out_content.getText().toString();
			       clientoutput=client.clientoutput;
			       clientoutput.contentoutput=msgout;
				}
				
			}
		});
		return_search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(searchActivity.this,mainActivity.class);
				startActivity(intent);
			}
		});
	}



	@Override
	public void getMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

}
