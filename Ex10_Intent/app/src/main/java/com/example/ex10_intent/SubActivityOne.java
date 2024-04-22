package com.example.ex10_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub_one);
    }
    // Hàm đáp ứng sự kiện nhấn lên nút "Sang màn hình khác"
    // Xử lý chuyển màn hình
    public void QuayVe (View v){
        // Tạo một đối tượng Intent
        // Tham số thứ 2 của hàm tạo này, là tên Activity (màn hình) ta mún chuyển sang
        Intent iManHinhChinh = new Intent(this,MainActivity.class);
        // Thực hiện chuyển
        startActivity(iManHinhChinh);
    }
}