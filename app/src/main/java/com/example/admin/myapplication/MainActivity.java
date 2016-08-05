package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


   public EditText name;
   public EditText add;
    public Button button;
    int a;
   private JSONArray jsonArray;
    boolean d;
private  JSONObject obj;
private     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fields);
         name=(EditText)findViewById(R.id.name);
         add=(EditText)findViewById(R.id.add);
         button=(Button)findViewById(R.id.button);
        listView=(ListView)findViewById(R.id.list);
        Field[] fields = MainActivity.class.getFields();
        Field[] tempFields = new Field[fields.length];
        obj=null;



        jsonArray=new JSONArray();
        for(Field f :fields){
            //  Log.i("FieldName",f.toString());
            //   Log.i("FieldClass",f.getDeclaringClass().toString());
            if( f.getDeclaringClass().toString().equals("class com.example.admin.myapplication.MainActivity")&&(!f.getName().toString().contains("$"))){
                Log.i("Class variable", f.getName());
                obj=new JSONObject();
                try{
                    obj.put("name",f.getName().toString());
                    jsonArray.put(obj);

                }
                catch (JSONException e){
                    e.printStackTrace();
                }

                // tempFields=fields;
//                System.out.println(f.toString());
            }
        }


        final String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, values);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp = values[position];
              Toast.makeText(getApplicationContext(),temp+" selected",Toast.LENGTH_LONG).show();
                Log.i("Inside on item click", temp);
                try {

                    obj=new JSONObject();
                   // jsonArray=new JSONArray();
                    obj.put("name", temp);
                    jsonArray.put(obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        //listView.getOnItemClickListener();
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {



       //System.out.println(Arrays.toString(fields));


        Log.v("yo",jsonArray.toString());
        Intent intent=new Intent(MainActivity.this,Sum.class);
        intent.putExtra("jsonArray",jsonArray.toString());
        startActivity(intent);

    }
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        // TODO Auto-generated method stub
//        super.onListItemClick(l, v, position, id);
//        String bean = listView.getItemAtPosition(position).toString();
//        try {
//            obj.put("name", bean);
//            jsonArray.put(obj);
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//
//        // txt.setText(items[position]);
//
//    }

    }






