package com.example.testdialogflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdialogflow.Data.Question9;

import java.util.Random;

public class MainQuiz9 extends AppCompatActivity {

    Button Button9Answer1,Button9Answer2,Button9Answer3,Button9Answer4;
    TextView TextScore9,TextQuestion9,TextCount9;

    private Question9 question9 = new Question9();

    private int score = 0;
    private int count = 0;
    private int questionlenght9 = question9.Questions9.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz9);

        r = new Random();

        TextScore9 =(TextView)findViewById(R.id.TextScore9);
        TextCount9 =(TextView)findViewById(R.id.TextCount9);
        TextQuestion9 =(TextView)findViewById(R.id.TextQuestion9);

        Button9Answer1 = (Button)findViewById(R.id.button9Answer1);
        Button9Answer2 = (Button)findViewById(R.id.button9Answer2);
        Button9Answer3 = (Button)findViewById(R.id.button9Answer3);
        Button9Answer4 = (Button)findViewById(R.id.button9Answer4);


        TextScore9.setText("Score: "+score);
        TextCount9.setText("ข้อที่ "+(count+1));
        updateQuestion(count);

        Button9Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button9Answer1.getText() == "ไม่มีเลย"){

                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer1.getText() == "เป็นบางวัน 1-7 วัน"){
                    score++;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer1.getText() == "เป็นบ่อย > 7วัน"){
                    score+=2;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer1.getText() == "เป็นทุกวัน"){
                    score+=3;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }


            }
        });
        Button9Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button9Answer2.getText() == "ไม่มีเลย"){

                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer2.getText() == "เป็นบางวัน 1-7 วัน"){
                    score++;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer2.getText() == "เป็นบ่อย > 7วัน"){
                    score+=2;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer2.getText() == "เป็นทุกวัน"){
                    score+=3;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }
            }
        });
        Button9Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button9Answer3.getText() == "ไม่มีเลย"){

                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer3.getText() == "เป็นบางวัน 1-7 วัน"){
                    score++;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer3.getText() == "เป็นบ่อย > 7วัน"){
                    score+=2;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer3.getText() == "เป็นทุกวัน"){
                    score+=3;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                        success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }


            }
        });
        Button9Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button9Answer4.getText() == "ไม่มีเลย"){

                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                       success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer4.getText() == "เป็นบางวัน 1-7 วัน"){
                    score++;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                       success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer4.getText() == "เป็นบ่อย > 7วัน"){
                    score+=2;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                       success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }else if(Button9Answer4.getText() == "เป็นทุกวัน"){
                    score+=3;
                    TextScore9.setText("Score: "+score);
                    count++;

                    if (count == questionlenght9 ){
                       success();
                    }
                    else {
                        TextCount9.setText("ข้อที่ " + (count + 1));
                        updateQuestion(count);
                    }
                }


            }
        });


    }
    private void updateQuestion(int num){
        TextQuestion9.setText(question9.getQuestion(num));
        Button9Answer1.setText(question9.getChoice1(num));
        Button9Answer2.setText(question9.getChoice2(num));
        Button9Answer3.setText(question9.getChoice3(num));
        Button9Answer4.setText(question9.getChoice4(num));
    }



    private void success(){
        Intent i = new Intent(MainQuiz9.this,MainResult9.class);
        i.putExtra("result",score);
        startActivity(i);

    }

}
