package com.example.calculator;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        nutCong.setOnClickListener(boLangNghe_XuLyCong);
        nutTru.setOnClickListener(boLangNghe_XuLyTru);
        nutNhan.setOnClickListener(boLangNghe_XuLyNhan);

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so1 = editTextSo1.getText().toString();
                String so2 = editTextSo2.getText().toString();

                float soA = Float.parseFloat(so1);
                float soB = Float.parseFloat(so2);

                float chia = soA / soB;

                String chuoiKQ = String.valueOf(chia);
                editTextKQ.setText(chuoiKQ);
            }
        });

    }

    View.OnClickListener boLangNghe_XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String so1 = editTextSo1.getText().toString();
            String so2 = editTextSo2.getText().toString();

            float soA = Float.parseFloat(so1);
            float soB = Float.parseFloat(so2);

            float tong = soA + soB;

            String chuoiKQ = String.valueOf(tong);
            editTextKQ.setText(chuoiKQ);
        }
    };
    View.OnClickListener boLangNghe_XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String so1 = editTextSo1.getText().toString();
            String so2 = editTextSo2.getText().toString();

            float soA = Float.parseFloat(so1);
            float soB = Float.parseFloat(so2);

            float tru = soA - soB;

            String chuoiKQ = String.valueOf(tru);
            editTextKQ.setText(chuoiKQ);
        }
    };
    View.OnClickListener boLangNghe_XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String so1 = editTextSo1.getText().toString();
            String so2 = editTextSo2.getText().toString();

            float soA = Float.parseFloat(so1);
            float soB = Float.parseFloat(so2);

            float nhan = soA * soB;

            String chuoiKQ = String.valueOf(nhan);
            editTextKQ.setText(chuoiKQ);
        }
    };

}