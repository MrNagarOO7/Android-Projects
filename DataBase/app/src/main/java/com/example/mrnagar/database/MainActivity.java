package com.example.mrnagar.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    EditText ed1,ed2;
    Button btn1,btn2,btn3,btn4;
    Cursor res;
    String string;
    Mydatabase mydb=new Mydatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        tv1=(TextView) findViewById(R.id.tv1);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mydb.updateData(Integer.parseInt(ed1.getText().toString()),ed2.getText().toString());
                }catch (Exception e){}
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mydb.deleteData(Integer.parseInt(ed1.getText().toString()));
                }catch (Exception e){}
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mydb.inserData(Integer.parseInt(ed1.getText().toString()), ed2.getText().toString());
                } catch (Exception e) {
                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                   res= mydb.getData();
                    string=" ";
                    while (res.moveToNext()){
                        string=string+"no:"+res.getString(0)+" name:"+res.getString(1)+"\n";
                    }
                    tv1.setText(string);
                }catch (Exception e){}
            }
        });
    }
}
