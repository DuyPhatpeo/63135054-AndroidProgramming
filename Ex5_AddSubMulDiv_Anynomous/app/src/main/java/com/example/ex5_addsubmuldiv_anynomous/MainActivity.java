package com.example.ex5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo biến tại đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    public void TimDieuKhien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKQ);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru= (Button)findViewById(R.id.btnTru);
        nutNhan = (Button)findViewById(R.id.btnNhan);
        nutChia = (Button)findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        // Anynomous
        // Gắn bộ lắng nghe sự kiện cho từng nút
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyCong();
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyTru();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyNhan();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyChia();
            }
        });
    }
    void XuLyCong() {

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tong = soA + soB;

        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }

    void XuLyTru() {

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tru = soA - soB;


        String chuoiKQ = String.valueOf(tru);
        editTextKQ.setText(chuoiKQ);
    }

    void XuLyNhan() {

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float nhan = soA * soB;

        String chuoiKQ = String.valueOf(nhan);
        editTextKQ.setText(chuoiKQ);
    }

    void XuLyChia() {

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float chia = soA / soB;

        String chuoiKQ = String.valueOf(chia);
        editTextKQ.setText(chuoiKQ);
    }

}