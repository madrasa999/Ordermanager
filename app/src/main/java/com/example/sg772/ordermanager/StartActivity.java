package com.example.sg772.ordermanager;

import android.arch.persistence.room.Room;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class StartActivity extends AppCompatActivity {
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        myAppDatabase=Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"orders").allowMainThreadQueries().build();
    //   OrderListViewFragment olvf=new OrderListViewFragment();
      RecyclerViewFragment rvf=new RecyclerViewFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragmentContainer,/*olvf*/ rvf );
        ft.commit();
        /*
myAppDatabase=Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"orders").allowMainThreadQueries().build();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new OrderListViewFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.create_order:
                AddOrderRoomFragment aorf = new AddOrderRoomFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, aorf).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
