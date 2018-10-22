package com.example.sg772.ordermanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OrdeMenurFragment extends Fragment {
    private Button button;
    private Button list_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.order_menu_layout, parent, false);


        button = (Button) v.findViewById(R.id.order_menu_add_button);
        list_button = (Button) v.findViewById(R.id.order_list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOrderRoomFragment addOrderRoomFragment = new AddOrderRoomFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainer, addOrderRoomFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderListViewFragment olvf = new OrderListViewFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainer, olvf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_layout, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
