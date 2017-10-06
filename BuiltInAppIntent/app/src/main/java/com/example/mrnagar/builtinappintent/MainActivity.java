

package com.example.mrnagar.builtinappintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    ImageView i1;
    int cam=2,contact=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Yash");
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+919537677080"));
                startActivity(j);
            }
        });
        b3=(Button)findViewById(R.id.b3);	
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(k,cam);
            }
        });
        b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(Intent.ACTION_PICK);
                l.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(l,contact);
            }
        });
    }
    public void onActivityResult(int reqC,int resC,Intent i){
        if(reqC==contact){
            Toast.makeText(getBaseContext(),i.getData().toString(),Toast.LENGTH_SHORT).show();
            Intent j=new Intent(Intent.ACTION_VIEW,Uri.parse(i.getData().toString()));
            startActivity(j);
        }
        if(reqC==cam){
            Bitmap pic=(Bitmap) i.getExtras().get("data");
            i1=(ImageView)findViewById(R.id.i1);
            i1.setImageBitmap(pic);
        }
    }
}
