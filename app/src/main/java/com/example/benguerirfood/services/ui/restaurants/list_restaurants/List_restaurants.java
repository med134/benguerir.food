package com.example.benguerirfood.services.ui.restaurants.list_restaurants;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.benguerirfood.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class List_restaurants extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager nestedScrollView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.list_restaurants_activity);
        tabLayout=findViewById(R.id.mytab);
        nestedScrollView=findViewById(R.id.myscrolingView);
        imageView=findViewById(R.id.pic_med);

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new Food(),"Food");
        adapter.addFragment(new Drinks(),"drinks");
        nestedScrollView.setAdapter(adapter);
        tabLayout.setupWithViewPager(nestedScrollView);

        // reception info
       Bundle bundle = getIntent().getExtras();
       if (bundle != null){
           int image=bundle.getInt("med");
           imageView.setImageResource(image);
       }
       // intent to list menu

    }
    private class MainAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        public void addFragment(Fragment fragment ,String s){
            fragments.add(fragment);
            stringList.add(s);
        }
        public MainAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }
}
