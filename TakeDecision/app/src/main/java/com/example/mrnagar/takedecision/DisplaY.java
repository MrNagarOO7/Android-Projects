package com.example.mrnagar.takedecision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DisplaY extends AppCompatActivity {

    TextView tv5,tv3;
    EditText ed3;
    Button btn2,btn3;
    int max,index=0,min,vindex;
    String que,givenq,str="";
    Random random=new Random();
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displa_y);
        ed3=(EditText)findViewById(R.id.ed3);
        extras=getIntent().getExtras();
        if(extras!=null){
            max=Integer.parseInt(extras.getString("options"));
            givenq=extras.getString("question");
        }
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        tv5=(TextView)findViewById(R.id.tv5);
        tv3=(TextView)findViewById(R.id.tv3);
        final String[] options=new String[max];
        que="Question  :"+givenq;
        tv3.setText(que);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<max) {
                    options[index] = String.valueOf(ed3.getText());
                    str += options[index] + "\n";
                    index++;
                    tv5.setText(str);
                    ed3.setText("Option " + (index + 1) + ":  ");
                }
                else{
                    Toast.makeText(getApplicationContext(),"No More Options",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vindex= random.nextInt(max-min)+min;
                Toast.makeText(getApplicationContext(),options[vindex],Toast.LENGTH_LONG).show();
            }
        });
    }
}
