package com.example.sg772.ordermanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

public class OrderPagerActivity extends AppCompatActivity {
private ViewPager viewPager;
private List<Zakazi> orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        viewPager=new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        setContentView(viewPager);
        orders=StartActivity.myAppDatabase.myDao().getZakazi();
        FragmentManager fm=getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                Zakazi z=orders.get(i);
                Bundle bundle=new Bundle();
                bundle.putInt("pos",z.getId());
                ListViewItemFragment listViewItemFragment=new ListViewItemFragment();
                listViewItemFragment.setArguments(bundle);
                return listViewItemFragment;
            }

            @Override
            public int getCount() {
                return orders.size();
            }
        });
        int id=(int)getIntent().getSerializableExtra(ListViewItemFragment.EXTRA_ORDER_);
        for (int i=0;i <orders.size();i++){
            if (orders.get(i).getId()==id){
                viewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
