package com.example.test2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;




public class  test2 extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test2);
		 TextView   a1=(TextView )findViewById(R.id.a1);
		Button  b1=(Button)findViewById(R.id.b1);
//		  File f = new File(this.getFilesDir().toString()+"/my.db");  
//		  f.delete();
//		this.deleteFile(this.getFilesDir().toString()+"/my.db3");
		 Log.d("my",this.getFilesDir().toString());
     	SQLiteDatabase db=SQLiteDatabase.openDatabase(this.getFilesDir().toString()+"/my.db7", null, SQLiteDatabase.OPEN_READWRITE);
//		String sql = "create table user(user_id integer primary key,"+"user_name varchar(255),"+"usre_pass varchar(255))";
//		db.execSQL(sql);
//	String sql1="insert into user(user_id,user_name,usre_pass)values(10,20,2222)";
//		db.execSQL(sql1);
	Cursor cursor=db.rawQuery("select *from user", null);
		int nameColumnIndex = cursor.getColumnIndex("user_name");  
		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
		{
			String sa=cursor.getString(nameColumnIndex);
			 Log.d("my",sa);} 
		
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
			//  在这里可以进行UI 操作
				 TextView   a1=(TextView )findViewById(R.id.a1);
			a1.setText(msg.getData().getString("name"));
			break;
			default:
        break;
        }
			}
			};
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				
				  Log.d("my","dfdsssssssssssssssssssssssss");
				try {
					new Thread(new Runnable() {
                    public void run() {
                        try {Socket socket;
                        	socket = new Socket("172.18.9.50", 9000); 
                        	 Log.d("my","dfdsssssssssssssssssssssssss1");
                        	

                        	 Log.d("my", "sdd");

                        	 ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
                        	 Log.d("my","d2");

                        InputStream aa=socket.getInputStream();
              
                     
                        int length = aa.available();
                 	 byte[] b1=new byte[length];
                 	 aa.read(b1);
                       
   
                        String s1=new String(b1);
                 	 Log.d("my",s1);
                 	 
                 	 
                 	 JSONObject j2;
					try {
						j2 = new JSONObject(s1);
						String s4=j2.getString("id");
                   	 Student p=(Student)in.readObject();
						Log.d("my","d4");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 	
                 	 
                             Message message = new Message();
                             message.what = 1;
                             Bundle b = new Bundle();
//                     		b.putString("name",p.name);
                             message.setData(b);
                             handler.sendMessage(message);
                            
                        } catch (IOException e) {
                        	e.printStackTrace();
                      } catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }

				
                    

					
                }).start();
				} catch (Exception e) {
					Log.v("my", "ddd");
				}
			
			}});
		}


	}
class Student implements Serializable {  
    int id;  
    String name;  
    int age;  
    String department;  
    private static final long serialVersionUID = 28724288838639126L;
    public Student(int id, String name, int age, String department) {  
        this.id = id;  
        this.name = name;  
        this.age = age;  
        this.department = department;  
    }  
      public int getid(){
    	  return id;
      }
      public String getname(){
    	  return name;
      }
    public String toString() {  
        return "name:" + name + ", id:" + id + ", age:" + age + ", department:" + department;  
    }  
}  
