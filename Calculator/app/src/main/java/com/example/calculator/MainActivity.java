package com.example.calculator;

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
        setContentView(R.layout.activity_main);
    }

    public void XuLyCong(View view) {
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tong = soA + soB;

        EditText editTextKQ = (EditText)findViewById(R.id.edtKQ);

        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }

    public void XuLyTru(View view) {
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tong = soA - soB;

        EditText editTextKQ = (EditText)findViewById(R.id.edtKQ);

        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }

    public void XuLyNhan(View view) {
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tong = soA * soB;

        EditText editTextKQ = (EditText)findViewById(R.id.edtKQ);

        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }

    public void XuLyChia(View view) {
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);

        float tong = soA / soB;

        EditText editTextKQ = (EditText)findViewById(R.id.edtKQ);

        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }
}