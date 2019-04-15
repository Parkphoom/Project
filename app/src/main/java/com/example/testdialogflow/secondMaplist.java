package com.example.testdialogflow;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class secondMaplist extends AppCompatActivity {

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_maplist);

        textView1 = (TextView)findViewById(R.id.textitem);
        textView2 = (TextView)findViewById(R.id.Tell);
        String Tempholder = getIntent().getStringExtra("Listviewclickvalue");
        String Tellholder = getIntent().getStringExtra("TellListviewclickvalue");
        textView1.setText(Tempholder);
        textView2.setText(Tellholder);

    }
}
