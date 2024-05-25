package ntu.tranduyphat.ex_baithithamkhao;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        FrameLayout layout = findViewById(R.id.fragmentSpace);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if(itemID == R.id.home){
                    loadFragment(new HomeFragment(),false);
                }else if(itemID == R.id.cau1) {
                    loadFragment(new Cau1Fragment(), false);
                }else if(itemID == R.id.cau2) {
                    loadFragment(new Cau2Fragment(), false);
                }else if(itemID == R.id.cau3) {
                    loadFragment(new Cau3Fragment(), false);
                }else if(itemID == R.id.cau4) {
                    loadFragment(new Cau4Fragment(), false);
                }
                return true;
            }
        });
        loadFragment(new HomeFragment(),true);// hien ra fragment dau tien

    }

    public void loadFragment(Fragment fragment, boolean boolen){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (boolen){
            fragmentTransaction.add(R.id.fragmentSpace, fragment);
        }else{
            fragmentTransaction.replace(R.id.fragmentSpace, fragment);
        }
        fragmentTransaction.replace(R.id.fragmentSpace, fragment);
        fragmentTransaction.commit();
    }
}