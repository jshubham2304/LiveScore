package com.example.lenovo.live_score;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import cricbuzz.Cricbuzz;


public class MainActivity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
       t1= (TextView)findViewById( R.id.textview );
        Cricbuzz c = new Cricbuzz();
        Vector<HashMap<String,String>> matches = new Vector<HashMap<String,String>>();
        try {
            matches = c.matches();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
   String json = gson.toJson(matches);
// next line problem a rhi h     ............................................   dekh
        String id = matches.get( 0 ).get( "id" );
       Map<String,Map> score = null;
        try {
            score = c.livescore( id );
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText( this, "1v : -"+json, Toast.LENGTH_SHORT ).show();
    json = gson.toJson(score);
        Toast.makeText( this, "2"+json, Toast.LENGTH_SHORT ).show();
        t1.setText(json  );
        }
}
