package ntu_63135054.cau3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

        // Ánh xạ các phần tử giao diện từ layout XML
        ImageView imageViewProfile = findViewById(R.id.imageViewProfile);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewMSSV = findViewById(R.id.textViewMSSV);
        TextView textViewClass = findViewById(R.id.textViewClass);

        // Thiết lập thông tin cá nhân
        String name = "Trần Duy Phát";
        String mssv = "MSSV: 6313054";
        String lop = "Lớp: 63.CNTT-3";

        // Hiển thị thông tin cá nhân trên giao diện
        textViewName.setText(name);
        textViewMSSV.setText(mssv);
        textViewClass.setText(lop);
    }
}