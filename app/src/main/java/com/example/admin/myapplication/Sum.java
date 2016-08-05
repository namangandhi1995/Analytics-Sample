package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.admin.myapplication.R;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by admin on 6/15/2016.
 */
public class Sum extends Activity implements OnItemSelectedListener{
     ListView list;
    Ran ran;
String item;
    String txt;
    ListViewCustomAdapter adapter;
    EditText text;
    private ArrayList<Object> arrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText)findViewById(R.id.editText);
        list = (ListView) findViewById(R.id.listView);


        Intent intent=getIntent();

        String jsonArray=intent.getStringExtra("jsonArray");
            try{
            JSONArray array=new JSONArray(jsonArray);
            Log.v("Yo",array.toString());
            Spinner spinner=(Spinner)findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(this);
          //  List<String> categories = new ArrayList<String>();
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                for(int i=0;i<array.length();i++)
            // Spinner Drop down elements
{


  dataAdapter.add(array.getJSONObject(i).getString("name"));

}




            // Creating adapter for spinner

            // Drop down layout style - list view with radio button
           ;

                       // attaching data adapter to spinner
            spinner.setAdapter(dataAdapter);



        }catch (JSONException e){
            e.printStackTrace();
        }

        arrayList = new ArrayList<Object>();

        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
       // adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        adapter = new ListViewCustomAdapter(this, arrayList);
                // Here, you set the data in your ListView
        list.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
      item = parent.getItemAtPosition(position).toString();
        txt=text.getText().toString();
        Log.v("hehe",txt);
        // next thing you have to do is check if your adapter has changed
        adapter.notifyDataSetChanged();


        ran = new Ran();
        ran.setTxt(txt);
        ran.setItem(item);
        arrayList.add(ran);// Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
