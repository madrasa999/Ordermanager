package com.example.sg772.ordermanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddOrderRoomFragment extends Fragment {
private Button saveB;
private EditText Cname;
private EditText price;
private EditText order;
private Button date;
    private Date d;
    private static final String DIALOG_DATE="date";
    private static final int REQUEST_DATE=0;
    private Zakazi zakazi;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_order_room_layout, parent, false);

        saveB=(Button)v.findViewById(R.id.saveB);
        Cname=(EditText)v.findViewById(R.id.clients_name_edit_r);
        order=(EditText)v.findViewById(R.id.order_edit_r);
        price=(EditText)v.findViewById(R.id.price_edit_r);
        date=(Button)v.findViewById(R.id.date_room_button);
       d=new Date();
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(d);
        int year =calendar.get(Calendar.YEAR);
        int month =calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        String datefin=String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year);

        updateDate(datefin);
        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dat=date.getText().toString();
                String cName=Cname.getText().toString();
                String ord=order.getText().toString();
                String prc=price.getText().toString();
                int pr=Integer.parseInt(prc);
                Zakazi zakazi=new Zakazi();
                zakazi.setClName(cName);
                zakazi.setOrder(ord);
                zakazi.setPricec(pr);
                zakazi.setDate(dat);



StartActivity.myAppDatabase.myDao().addZakazi(zakazi);

                Toast.makeText(getContext(),"added",Toast.LENGTH_SHORT).show();
                Cname.setText("");
                order.setText("");
                price.setText("");
                OrderListViewFragment olvf=new OrderListViewFragment();
              //  RecyclerViewFragment rvf=new RecyclerViewFragment();
      FragmentTransaction ft=getFragmentManager().beginTransaction();
      ft.replace(R.id.fragmentContainer,olvf).addToBackStack(null).commit();

            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getActivity().getSupportFragmentManager();
                datePickerFragment dialog=datePickerFragment.newInstance(d);
                dialog.setTargetFragment(AddOrderRoomFragment.this, REQUEST_DATE);
                dialog.show(fm,DIALOG_DATE);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
            return;
        if (requestCode==REQUEST_DATE){
            Date da=(Date)data.getSerializableExtra(datePickerFragment.EXTRA_DATE);
            Calendar calendar =new GregorianCalendar();
            calendar.setTime(da);
            int year =calendar.get(Calendar.YEAR);
            int month =calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            String datefin=String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year);

            updateDate(datefin);
        }
    }
private void updateDate(String c){
        date.setText(c);
}



}
