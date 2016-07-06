package com.example.test;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class listsimpleadapter  extends  ArrayAdapter<listcontent> {
	private int resourceId;
	public listsimpleadapter(Context context , int  Id,List<listcontent>object)
	{ super(context,Id,object);
	resourceId=Id;
	}
	 @Override
	 
public View getView(int position, View convertView , ViewGroup parent)
{   listcontent  listcontent=getItem(position);
    View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
   TextView listcontentname=(TextView)view.findViewById(R.id.listtext);
   listcontentname.setText(listcontent.getName());
   return view;
}
}
