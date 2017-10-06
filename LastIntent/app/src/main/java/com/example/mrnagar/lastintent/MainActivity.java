package com.example.mrnagar.lastintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = (TextView) findViewById(R.id.t1);
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity.class);
                startActivityForResult(i, 2);
            }
        });
    }
    public void onActivityResult(int reqCode,int resCode,Intent j){
        super.onActivityResult(reqCode,resCode,j);
        if(reqCode==2 ) {
                String msg = j.getStringExtra("MSG");
                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
                //t1.setText(msg);
            }
        }
}

