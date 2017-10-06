package com.example.mrnagar.progressdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog pdialog;
    private int progress=0;
    private Handler phandler;
    CharSequence[] apps={"Google","Whatsapp","Yahoo","Hike"};
    boolean[] achked=new boolean[apps.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(0);
                    progress=0;
                    pdialog.setProgress(0);
                    phandler.sendEmptyMessage(0);
                }
            });
        }
        phandler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(progress>100){
                pdialog.dismiss();
            }
            else{
                progress++; //here we use progress variable to check condition >100
                pdialog.incrementProgressBy(1);
                phandler.sendEmptyMessageDelayed(0,100);
            }
        }
        };
    }
        protected Dialog onCreateDialog(int id){
            switch (id){

                case 0:
                    return new AlertDialog.Builder(this)
                        .setTitle("Simple Text")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"Ok clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"Cancle clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMultiChoiceItems(apps,achked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(getBaseContext(),apps[which]+(isChecked ? " Checked" : " unchecked"),Toast.LENGTH_SHORT).show();;
                            }
                        })
                        .create();
                case 1:
                    pdialog= new ProgressDialog(this);
                    pdialog.setTitle("Downloadinf File..");
                    pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    pdialog.setButton(DialogInterface.BUTTON_POSITIVE,"hide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"Hide & seek",Toast.LENGTH_SHORT).show();
                    }

                });
                return pdialog;

            }
            return null;
        }
}
