package com.example.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    // Bộ lắng nghe và xử lý sự kiện click lên nút tính tổng
    public void XuLyCong(View view){
        // Tìm, Tham chiếu đến điều khiển trên file xml
        EditText editTextSoA = findViewById(R.id.txta);
        EditText editTextSoB = findViewById(R.id.txtb);
        EditText editTextKetQua = findViewById(R.id.txtkq);

        // Lấy dữ liệu về
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();

        // chuyển dữ liệu về dạng số
        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        // Tình tổng 2 số
        int tong = soA + soB;
        String strTong = String.valueOf(tong); // chuyển sang dạng chuỗi
        // Hiện ra màn hình
        editTextKetQua.setText(strTong);
    }
}