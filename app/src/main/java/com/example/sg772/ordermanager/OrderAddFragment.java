package com.example.sg772.ordermanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class OrderAddFragment extends Fragment {
    DbConnection dbConnection;
    private Button addButton;
    private EditText clName;
    private EditText whatorder;

    private EditText price;


    public View onCreateView(LayoutInflater inflater, final ViewGroup parent, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.order_add_fragment_layout,parent,false);
        clName=(EditText)v.findViewById(R.id.clients_name_edit);
        whatorder=(EditText) v.findViewById(R.id.order_edit);
        price=(EditText)v.findViewById(R.id.price_edit);

addButton=(Button)v.findViewById(R.id.order_add_button);
addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String ord= String.valueOf(whatorder.getText());
dbConnection=new DbConnection(getContext());
SQLiteDatabase sqld=dbConnection.getWritableDatabase();
ContentValues cv= new ContentValues();
cv.put(DbConnection.NAME,clName.getText().toString());
cv.put(DbConnection.ORDER,ord);
cv.put(DbConnection.PRICE,price.getText().toString());
sqld.insert(DbConnection.TABLE_N,null,cv);
Bundle bundle=new Bundle();
bundle.putString("Name",clName.getText().toString());
bundle.putString("Order", ord);
bundle.putInt("Price",Integer.parseInt(price.getText().toString()));
        OrderAddedNotificationFragment oanf=new OrderAddedNotificationFragment();
        oanf.setArguments(bundle);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, oanf);
        ft.addToBackStack(null);
        ft.commit();


    }
});
        return v;

    }
}
