package com.example.ex12_bottomnavigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView;
        FrameLayout frameLayout;
        bottomNavigationView =(BottomNavigationView) findViewById(R.id.bottomNavigation);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if(itemID == R.id.add){
                    loadFragment(new AddFragment(),false);
                }else if(itemID == R.id.bag){
                    loadFragment(new BagFragment(),false);
                }else if(itemID == R.id.lib){
                    loadFragment(new VideoFragment(),false);
                }else{
                    loadFragment(new ShoppingFragment(),false);
                }
                return true;
            }
        });
        loadFragment(new BagFragment(),true);

    }

    public void loadFragment(Fragment fragment, boolean boolen){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (boolen){
            fragmentTransaction.add(R.id.frame_layout, fragment);
        }else{
            fragmentTransaction.replace(R.id.frame_layout, fragment);
        }
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}