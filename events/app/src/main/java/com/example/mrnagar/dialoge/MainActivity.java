package com.example.mrnagar.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String tag="Events";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"In the onCreate");
        Toast.makeText(getBaseContext(),"In the onCreate",Toast.LENGTH_SHORT).show();
    }
    protected void onStart(){
        super.onStart();
        Log.d(tag,"In the onStart");
        Toast.makeText(getBaseContext(),"In the onStart",Toast.LENGTH_SHORT).show();
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(tag,"In the onRestart");
        Toast.makeText(getBaseContext(),"In the onRestart",Toast.LENGTH_SHORT).show();
    }
    protected void onResume(){
        super.onResume();
        Log.d(tag,"In the onResume");
        Toast.makeText(getBaseContext(),"In the onResume",Toast.LENGTH_SHORT).show();
    }
    protected void onPause(){
        super.onPause();
        Log.d(tag,"In the onPause");
        Toast.makeText(getBaseContext(),"In the onPause",Toast.LENGTH_SHORT).show();
    }
    protected void onStop(){
        super.onStop();
        Log.d(tag,"In the onStop");
        Toast.makeText(getBaseContext(),"In the onStop",Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(tag,"In the onDestroy");
        Toast.makeText(getBaseContext(),"In the onDestroy",Toast.LENGTH_SHORT).show();
    }
}
