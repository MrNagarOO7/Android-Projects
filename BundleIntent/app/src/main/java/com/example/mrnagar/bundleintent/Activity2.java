package com.example.mrnagar.bundleintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        String u_name="";
        Bundle data=getIntent().getExtras();
        if(data!=null){
            u_name=data.getString("Name");
        }
        TextView t1=(TextView)findViewById(R.id.t1);
        t1.setText(u_name);
    }
}
