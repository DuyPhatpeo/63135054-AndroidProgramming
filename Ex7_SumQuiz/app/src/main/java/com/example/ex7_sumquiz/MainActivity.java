package com.example.ex7_sumquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    EditText edt_num1,edt_num2,edt_cau;
    TextView result;

    Button btn_a,btn_b,btn_c,btn_d,btn_rand;
    Integer num1_values,num2_values,kq;
    Random rand = new Random();
    List<Button> buttons = new ArrayList<>();

    int SLtao=0,SLdung=0;


    void findID(){
        edt_num1 = (EditText) findViewById(R.id.edt_num1);
        edt_num2 = (EditText) findViewById(R.id.edt_num2);
        result = (TextView) findViewById(R.id.tw_result);
        btn_a = (Button) findViewById(R.id.btn_a);
        btn_b = (Button) findViewById(R.id.btn_b);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_d = (Button) findViewById(R.id.btn_d);
        btn_rand = (Button) findViewById(R.id.btn_rand);
        edt_cau = (EditText) findViewById(R.id.edt_cau);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findID();
        random();
        clickCheck();

    }

    //Xử lý hàm
    public void random(){
        btn_rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SLtao++;
                num1_values = rand.nextInt(20);
                num2_values = rand.nextInt(20);
                kq = num1_values + num2_values;
                edt_num1.setText(String.valueOf(num1_values));
                edt_num2.setText(String.valueOf(num2_values));
                result.setText(SLdung + "/" + SLtao);
                edt_cau.setText(String.valueOf(SLtao));
                taoDA(kq);
            }
        });
    }

    public void taoDA(int kq) {
        List<String> answers = new ArrayList<>();
        int temp;
        Set<String> set = new HashSet<>(); // Dùng Set để kiểm tra giá trị trùng nhau
        int answersIndex = rand.nextInt(4); // Chọn ngẫu nhiên vị trí của đáp án đúng từ 0 đến 3
        for (int i = 0; i < 4; i++) {
            if (i == answersIndex) {
                answers.add(String.valueOf(kq)); // Thêm đáp án đúng vào danh sách
            } else {
                do {
                    temp = rand.nextInt(20) + rand.nextInt(20); // Tạo ngẫu nhiên một giá trị
                } while (temp == kq || set.contains(String.valueOf(temp))); // Kiểm tra nếu giá trị đã tồn tại, lặp lại cho đến khi không trùng lặp
                set.add(String.valueOf(temp)); // Thêm giá trị vào set để kiểm tra trùng lặp
                answers.add(String.valueOf(temp));
            }
        }
        // Thiết lập văn bản cho các nút
        btn_a.setText(answers.get(0));
        btn_b.setText(answers.get(1));
        btn_c.setText(answers.get(2));
        btn_d.setText(answers.get(3));
    }

    public void clickCheck(){
        buttons.add(btn_a);
        buttons.add(btn_b);
        buttons.add(btn_c);
        buttons.add(btn_d);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int values = Integer.parseInt(btn_a.getText().toString());
                if(check(values)){
                    btn_a.setBackgroundColor(Color.parseColor("#FF07980D"));
                    SLdung++;
                }else{
                    btn_a.setBackgroundColor(Color.parseColor("#FFFF0909"));

                }
                reset(buttons);
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int values = Integer.parseInt(btn_b.getText().toString());
                if(check(values)){
                    btn_b.setBackgroundColor(Color.parseColor("#FF07980D"));
                    SLdung++;
                }else{
                    btn_b.setBackgroundColor(Color.parseColor("#FFFF0909"));
                }
                reset(buttons);
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int values = Integer.parseInt(btn_c.getText().toString());
                if(check(values)){
                    btn_c.setBackgroundColor(Color.parseColor("#FF07980D"));
                    SLdung++;
                }else{
                    btn_c.setBackgroundColor(Color.parseColor("#FFFF0909"));

                }
                reset(buttons);
            }
        });
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int values = Integer.parseInt(btn_d.getText().toString());
                if(check(values)){
                    btn_d.setBackgroundColor(Color.parseColor("#FF07980D"));
                    SLdung++;
                }else{
                    btn_d.setBackgroundColor(Color.parseColor("#FFFF0909"));

                }
                reset(buttons);
            }
        });
    }
    public boolean check(int values){
        if(values == kq){
            return true;
        }else return false;
    }
    public void reset(List<Button> buttons) {
        // Xóa kết quả sau 1 giây và đặt lại màu sắc ban đầu
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Duyệt qua danh sách các nút
                for (Button button : buttons) {
                    // Đặt lại màu sắc ban đầu cho nút
                    button.setBackgroundColor(Color.parseColor("#8E24AA")); // Màu trắng hoặc màu khác nếu bạn muốn
                    // Xóa kết quả
                    button.setText("");
                }
                // Xóa nội dung của các EditText
                edt_num1.setText("");
                edt_num2.setText("");
                // Đặt lại kết quả về 0
                kq = 0;
            }
        }, 300); // Thời gian delay là 1 giây (1000 miliseconds)
    }
}