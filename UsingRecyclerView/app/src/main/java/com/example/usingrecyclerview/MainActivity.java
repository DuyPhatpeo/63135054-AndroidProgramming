package com.example.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3.Chuẩn bị dữ liệu cho landScapeList
        recyclerViewDatas = getDataForRecyclerView();
        //4. Tìm điều khiển Recycler
        recyclerView = findViewById(R.id.recyclerLand);
        //5. Tạo layout manager để đặt bố cục cho Recycler
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutLinear);
//        RecyclerView.LayoutManager layoutLinearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutLinearHorizontal);
//        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(layoutGrid);
        //6. Tạo adapter gắn với nguồn dữ liệu
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        //7. Gắn adapter với Recycler
        recyclerView.setAdapter(landScapeAdapter);

    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsData = new ArrayList<>();
        LandScape landScape = new LandScape("anh1","Ảnh đẹp 4k - ảnh nên máy tính");
        dsData.add(landScape);
        dsData.add(new LandScape("anh2","Ảnh đẹp 4k - ảnh nên máy tính"));
        dsData.add(new LandScape("anh3","Ảnh đẹp 4k - ảnh nên máy tính"));
        dsData.add(new LandScape("anh4","Ảnh đẹp 4k - ảnh nên máy tính"));
        return dsData;
    }
}