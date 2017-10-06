package com.example.mrnagar.lastintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity extends AppCompatActivity {

    EditText e1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        b2=(Button)findViewById(R.id.btn);
        e1=(EditText)findViewById(R.id.ed);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),e1.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent q=new Intent();
               // q.setData(Uri.parse(e1.getText().toString()));
                q.putExtra("MSG",e1.getText().toString());
                setResult(RESULT_OK,q);
                finish();
            }
        });
    }
}

