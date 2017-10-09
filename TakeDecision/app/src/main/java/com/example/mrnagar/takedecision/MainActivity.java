package com.example.mrnagar.takedecision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),DisplaY.class);
                i.putExtra("options",ed2.getText().toString());
                i.putExtra("question",ed1.getText().toString());
                startActivity(i);
            }
        });
    }
   /* int putnumber(){
        int i;
        i=Integer.parseInt(String.valueOf(ed2.getText()));
        return i;
    }
    String putQuestion(){
        String que;
        que= String.valueOf(ed1.getText());
        return que;
    }*/
}
