package com.example.tabs;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);

//FIRSTTAB
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Tester");
        firstTab.setIcon(R.drawable.baseline_monitor_heart_24);
        tabLayout.addTab(firstTab);
        //SECONDTAB
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Devloper");
        secondTab.setIcon(R.drawable.baseline_girl_24);
        tabLayout.addTab(secondTab);
//THIRDTAB
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Tester+Devloper");
        thirdTab.setIcon(R.drawable.baseline_people_outline_24);
        tabLayout.addTab(thirdTab);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FirstFragment();
                        break;

                    case 1:
                        fragment=new SecondFragment();
                        break;

                    case 2:
                        fragment=new ThirdFragment();
                        break;
                }
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.framelayout,fragment);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}