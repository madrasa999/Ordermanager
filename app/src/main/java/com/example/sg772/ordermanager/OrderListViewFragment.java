package com.example.sg772.ordermanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.List;

public class OrderListViewFragment extends ListFragment {
    private List <Zakazi>orders;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        orders = StartActivity.myAppDatabase.myDao().getZakazi();
        OrderAdapter oa = new OrderAdapter(orders);
        setListAdapter(oa);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Zakazi z=((OrderAdapter)getListAdapter()).getItem(position);
        Bundle bundle=new Bundle();
        bundle.putInt("id",z.getId());
       /* ListViewItemFragment listViewItemFragment =new ListViewItemFragment();
        listViewItemFragment.setArguments(bundle);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, listViewItemFragment);
        ft.addToBackStack(null);
        ft.commit(); */
       Intent i=new Intent(getContext(),OrderPagerActivity.class);
       i.putExtra(ListViewItemFragment.EXTRA_ORDER_,z.getId());
       startActivity(i);
    }

    private class OrderAdapter extends ArrayAdapter<Zakazi>{
        public OrderAdapter(List<Zakazi> z){
            super(getActivity(),0,z);
        }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
convertView=getActivity().getLayoutInflater().inflate(R.layout.orders_list_view_layout,null);
        }

        Zakazi z=getItem(position);
        TextView cNametextv=(TextView)convertView.findViewById(R.id.clName_list);
        cNametextv.setText(z.getClName());
        TextView idtextv=(TextView)convertView.findViewById(R.id.id_list);
        idtextv.setText(String.valueOf(z.getId()));
        TextView ortextv=(TextView)convertView.findViewById(R.id.order_list);
        ortextv.setText(z.getOrder());
        TextView prtextv=(TextView)convertView.findViewById(R.id.price_list);
        prtextv.setText(String.valueOf(z.getPricec()));
        Button deleteB=(Button)convertView.findViewById(R.id.delete);
        Button update=(Button)convertView.findViewById(R.id.update);
        deleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zakazi ord=getItem(position);
               StartActivity.myAppDatabase.myDao().deleteZakazi(ord);
               Toast.makeText(getContext(),"deleted",Toast.LENGTH_SHORT).show();
                


            }
        });
        update.setFocusable(false);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Zakazi zakaz=getItem(position);
                String cNam=zakaz.getClName();
                String o=zakaz.getOrder();
                int pric=zakaz.getPricec();
                Bundle bundle=new Bundle();
bundle.putInt("orderId",zakaz.getId());
               updateFragment uf =new updateFragment();
               uf.setArguments(bundle);
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainer, uf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return convertView;
    }
}



}
