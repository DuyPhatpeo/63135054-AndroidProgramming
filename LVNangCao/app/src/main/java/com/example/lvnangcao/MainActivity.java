package com.example.lvnangcao;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.lvnangcao.adapters.CountryAdapter;
import com.example.lvnangcao.models.Country;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dsQG= new ArrayList<Country>();
        dsQG.add(new Country("Vietnam",90,"vn"));
        dsQG.add(new Country("Russia",110,"ru"));
        dsQG.add(new Country("United State",80,"us"));

        ListView listView = findViewById(R.id.lvQG);

        CountryAdapter adapter = new CountryAdapter(this, dsQG);
        listView.setAdapter(adapter);
    }
}