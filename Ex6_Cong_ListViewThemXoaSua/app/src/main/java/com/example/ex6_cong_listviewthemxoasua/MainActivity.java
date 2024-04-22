package com.example.ex6_cong_listviewthemxoasua;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    Button btnThem, btnCapNhat, btnXoa;
    EditText edtTinhThanh;
    ListView lvTinhThanh;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvTinhThanh = (ListView)findViewById(R.id.lvDanhTT);
        btnThem = (Button)findViewById(R.id.btnThem);
        btnCapNhat = (Button)findViewById(R.id.btnCapNhat);
        btnXoa = (Button)findViewById(R.id.btnXoa);
        edtTinhThanh = (EditText)findViewById(R.id.edtTinhThanh);

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
        lvTinhThanh.setAdapter(adapterTinhThanh);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinhThanh = edtTinhThanh.getText().toString();
                dsTenTinhThanhVn.add(tinhThanh);
                adapterTinhThanh.notifyDataSetChanged();
            }
        });

        // Xử lý btn cập nhật
        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                edtTinhThanh.setText(dsTenTinhThanhVn.get(i));
                vitri = i;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsTenTinhThanhVn.set(vitri,edtTinhThanh.getText().toString());
                adapterTinhThanh.notifyDataSetChanged();
            }
        });

        // Xử lý btn xoá
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsTenTinhThanhVn.remove(vitri);
                adapterTinhThanh.notifyDataSetChanged();
            }
        });

    }
}