package com.example.sg772.ordermanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListViewItemFragment extends Fragment {
    public static final String EXTRA_ORDER_ ="com.example.sg7720.ordermanager.order_id" ;
    private TextView Id;
    private TextView clName;
  private TextView order;
  private TextView price;
  private TextView date;
  private List<Zakazi> orders;
  private Zakazi zakazi;


    public View onCreateView( LayoutInflater inflater,  ViewGroup parent,  Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.listview_item_layout,parent,false);
       Id=(TextView)view.findViewById(R.id.id_it);
        order=(TextView)view.findViewById(R.id.order_edit_it);
        clName=(TextView)view.findViewById(R.id.clients_name_edit_it);
        price=(TextView)view.findViewById(R.id.price_edit_it);
date=(TextView)view.findViewById(R.id.date_it);
      Bundle bundle=getArguments();
      int id=bundle.getInt("pos");
zakazi=getOrderById(id);
order.setText(zakazi.getOrder());
clName.setText(zakazi.getClName());
Id.setText(String.valueOf(zakazi.getId()));
price.setText(String.valueOf(zakazi.getPricec()));
date.setText(zakazi.getDate());

       return view;
    }

    public Zakazi getOrderById(int id){

        orders=StartActivity.myAppDatabase.myDao().getZakazi();
        for (Zakazi z:orders){
            if (z.getId()==id){
                zakazi=z;
            }

        }
        return zakazi;
    }
}
