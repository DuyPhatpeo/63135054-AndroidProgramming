package com.example.recyclerviewpaper;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ExamAdapter examAdapter;
    ArrayList<ExamData> lstData;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //chuan bi du lieu
        lstData = getData();
        //tim dieu khien recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutLinear =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutLinear);
        examAdapter = new ExamAdapter(this, lstData);
        recyclerView.setAdapter(examAdapter);
    }

    ArrayList<ExamData>getData(){
        ArrayList<ExamData> list = new ArrayList<>();
        list.add(new ExamData("First Exam",
                "29 - 5 - 2024",
                "Best Of Luck"));
        list.add(new ExamData("Second Exam",
                "15 - 09 - 2024",
                "b of l"));
        list.add(new ExamData("My Test Exam",
                "7 - 12 - 2024",
                "This is testing exam .."));

        return list;
    }
}