package com.example.ex6_listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenTinhThanhVn; // Khai báo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Hiện thị dữ liệu của list view
        // B1: cần có dữ liệu
        dsTenTinhThanhVn = new ArrayList<>(); // tạo thể hiện cụ thể, xin mời
        // thêm dự liệu ở đây
        dsTenTinhThanhVn.add("Hà Nội");
        dsTenTinhThanhVn.add("Cam Ranh");
        dsTenTinhThanhVn.add("Đồng Nai");
        dsTenTinhThanhVn.add("Ninh Thuận");
        dsTenTinhThanhVn.add("Bình Thuận");
        dsTenTinhThanhVn.add("Nha Trang");
        dsTenTinhThanhVn.add("Tp. Hồ Chí Minh");

        // B2: Tạo adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsTenTinhThanhVn);

        // B3: Gắn vào điều khiển hiện thị ListView
        // 3.1: tìm
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhTT);
        // 3.2: Gắn
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        // 3.3: Lắng nghe và xử lý sự kiện user tương tác
        // gắn bộ lắng nghe vào
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXl);

    }
    // Tạo bộ lắng nghe và xử lý cho sự kiện OnItemClick, đặt vào một biến
    AdapterView.OnItemClickListener BoLangNghevaXl = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
            // Code xử lý ở đây
            // i là vị trí phần tử vừa click
            // ví dụ xử lý ở đây, là hiển thị lên màn hình một thông báo nhanh

            // về vị trí của phần tử vừa chọn
            //Toast.makeText(MainActivity.this,"Bạn vừa chọn: " + String.valueOf(i),Toast.LENGTH_LONG).show();

            // về giá trị của phần tử thứ i
            String strTenTinhChon = dsTenTinhThanhVn .get(i);
            Toast.makeText(MainActivity.this,"Bạn vùa chọn: " + strTenTinhChon,Toast.LENGTH_LONG).show();
        }
    };
}