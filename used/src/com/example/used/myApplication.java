package com.example.used;



import com.example.used.client.client;
import com.example.used.client.clientoutput;

import android.app.Application;

public class myApplication extends Application{
public client client;
public clientoutput clientoutput;
public static  boolean isClientStart;

public void onCreate(){
	client=new client();
	super.onCreate();
}
public client getClient(){
	return this.client;

	
}
public clientoutput getClientoutput(){
	return this.clientoutput;
}
public void setClientStart(boolean isClientStart){
	this.isClientStart=isClientStart;
}
public boolean isClientStart(){
return this.isClientStart;
}
}
