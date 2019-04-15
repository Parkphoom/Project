package com.example.testdialogflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainMaplist extends AppCompatActivity {



    String [] ListviewName = new String[]{
            "คณะแพทยศาสตร์ มหาวิทยาลัยธรรมศาสตร์","โรงพยาบาลกลาง","คณะแพทยศาสตร์ วชิรพยาบาล"
    };
    String[] ListviewTell = new String[]{
            "โทร. (02) 926-9899","โทร. 0-2220-8000","โทร. (02)244-3900"
    };
    String[] ListviewDetail = new String[]{
            "เวลา07.00–11.30 น. บริการทดสอบทางจิตวิทยา และกิจกรรมบำบัดต่างๆ ทางด้านสุขภาพจิตและจิตเวช"
            ,"เวลา 10.00–12.00 น.","เวลา 16.30-20.00 น."
    };
    Double[] LatHospital = new Double[]{
            14.072724,13.780861,13.746499
    } ;

    Double[] LngHospital = new Double[]{
            100.613789, 100.509232 ,100.508699
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maplist);

        ListView listView = findViewById(R.id.maplistview);

        HashMap<String,String> Namehospital = new HashMap<>();
        Namehospital.put("คณะแพทยศาสตร์ มหาวิทยาลัยธรรมศาสตร์","โทร. (02) 926-9899");
        Namehospital.put("โรงพยาบาลกลาง","โทร. 0-2220-8000");
        Namehospital.put("คณะแพทยศาสตร์ วชิรพยาบาล","โทร. (02)244-3900");


        HashMap<Double,Double> LatLngHospital = new HashMap<>();
        LatLngHospital.put(14.072724,100.613789);
        LatLngHospital.put(13.746499,100.509232);
        LatLngHospital.put(13.780861,100.508699);

        List<HashMap<String,String>> listItem = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this,listItem,R.layout.list_map,
                new String[]{"First Line","Second Line"},
                new int[]{R.id.text1,R.id.text2});

       Iterator iterator = Namehospital.entrySet().iterator();
       while(iterator.hasNext())
       {
           HashMap<String, String> resultsMap = new HashMap<>();
           Map.Entry pair = (Map.Entry)iterator.next();
           resultsMap.put("First Line",pair.getKey().toString());
           resultsMap.put("Second Line",pair.getValue().toString());
           listItem.add(resultsMap);
       }
   listView.setAdapter(adapter);


//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,android.R.id.text1, ListviewName);
////        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,android.R.id.text2, ListviewTell);
//        listView.setAdapter(adapter);
//        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Templistview = ListviewName[position].toString();
                String Telllistview = ListviewTell[position].toString();
                Double Lathospital = LatHospital[position];
                Double Lnghospital = LngHospital[position];

                Intent intent = new Intent(MainMaplist.this, MainMaps.class);
                intent.putExtra("Listviewclickvalue",Templistview);
                intent.putExtra("HospitalLatclickvalue",Lathospital);
                intent.putExtra("HospitalLngclickvalue",Lnghospital);
                startActivity(intent);
            }
        });
    }
}
