package com.example.testdialogflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainResult9 extends AppCompatActivity {

    int result;
    TextView TextAnalyze9;
    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result9);


        Bundle bundle = getIntent().getExtras();
        result = bundle.getInt("result");

        buttonRestart = (Button)findViewById(R.id.buttonRestart);
        TextAnalyze9 = (TextView)findViewById(R.id.TextAnalyze9);
        TextView result9 = (TextView)findViewById(R.id.Textresult9);
        result9.setText("คะแนนรวม "+Integer.valueOf(result));
        analyze();

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainResult9.this,MainQuiz9.class);
                startActivity(i);
            }
        });

    }


    private void analyze(){
        AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(MainResult9.this);
        alertdialogBuilder
                .setMessage("แนะนำให้ทำแบบประเมินฆ่าตัวตาย")
                .setCancelable(false)
                .setPositiveButton("ตกลง", null);

        if(result < 7){
            TextAnalyze9.setText("ไม่มีอาการของโรคซึมเศร้าหรือมีอาการของโรคซึมเศร้าระดับน้อยมาก");
        }else if(result >= 7 && result <= 12){
            TextAnalyze9.setText("มีอาการของโรคซึมเศร้า ระดับน้อย");
            AlertDialog alertDialog = alertdialogBuilder.create();
            alertDialog.show();
        }else if(result >= 13 && result <= 18){
            TextAnalyze9.setText("มีอาการของโรคซึมเศร้า ระดับปานกลาง");
            AlertDialog alertDialog = alertdialogBuilder.create();
            alertDialog.show();
        }else{
            TextAnalyze9.setText("มีอาการของโรคซึมเศร้า ระดับรุนแรง");
            AlertDialog alertDialog = alertdialogBuilder.create();
            alertDialog.show();

        }
    }


}
