package com.example.testdialogflow.Data;

public class Question2 {

    public String  NQuestions[] = {
            "ใน 2 สัปดาห์ที่ผ่านมา รวมวันนี้ ท่านรู้สึก หดหู่ เศร้า หรือท้อแท้สิ้นหวัง หรือไม่",
            "ใน 2 สัปดาห์ที่ผ่านมา รวมวันนี้ท่านรู้สึก เบื่อ ทาอะไรก็ไม่เพลิดเพลิน หรือไม่"
    };

    public  String Nchoices[][] ={
            {"มี","ไม่มี"},
            {"มี","ไม่มี"}
    };

    private String NcorrectAnswer[] = {"มี","มี"};

    public String getQuestion(int a){
        String Question = NQuestions[a];
        return Question;
    }


    public String getChoice1(int a){
        String choice = Nchoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = Nchoices[a][1];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = NcorrectAnswer[a];
        return answer;
    }

}
