package com.example.mrnagar.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.Window;


public class MainActivity extends AppCompatActivity {
    CharSequence[] iteams = {"Yash", "Megha", "Kushan"};
    boolean[] ichecked = new boolean[iteams.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title of activity
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(0);//here zero is idendity of dialog if there more than one dialogs
            }
        });
    }
    protected Dialog onCreateDialog(int id) { //Itz called when we call showDialog() method
        if(id==0) {
                        return new AlertDialog.Builder(this)
                        .setTitle("Simple Choice")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), "Ok Clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("CANCLE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), "Cancle clicked", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setMultiChoiceItems(iteams, ichecked, new DialogInterface.OnMultiChoiceClickListener() { //this method uses 2 arrays 1 for choice 2 for the value
                            public void onClick(DialogInterface dialog, int pos, boolean ichecked) {
                                Toast.makeText(getBaseContext(), iteams[pos] + (ichecked ? " checked" : " unchecked"), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
        }
        return null;
    }

}

