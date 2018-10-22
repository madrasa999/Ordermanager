package com.example.sg772.ordermanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewFragment extends Fragment {

    List<Zakazi> orders;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);

        RecyclerView  mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
         orders =StartActivity.myAppDatabase.myDao().getZakazi();
        OrderAdapter oa=new OrderAdapter(orders);
        mRecyclerView.setAdapter(oa);
        //updateUI();

        return view;
    }
/*
public void updateUI(){
    orders = StartActivity.myAppDatabase.myDao().getZakazi();
     orderAdapter = new OrderAdapter(orders);
    mRecyclerView.setAdapter(orderAdapter);
}
*/

}
