package com.example.sg772.ordermanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class updateFragment extends Fragment {
    private Button updateB;
    private EditText Cname;
    private EditText price;
    private EditText order;
    private Button date;
    private List<Zakazi> orders;
    private Zakazi zakazi;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup parent,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.update_order_layout,parent,false);
        Cname=(EditText)view.findViewById(R.id.clients_name_up);
        price=(EditText)view.findViewById(R.id.price_edit_up);
        order=(EditText)view.findViewById(R.id.order_edit_up);
        updateB=(Button)view.findViewById(R.id.updateB);
        date=(Button)view.findViewById(R.id.update_button);
Bundle bundle=getArguments();
int orderId=bundle.getInt("orderId");
zakazi=getOrderById(orderId);
Cname.setText(zakazi.getClName());
price.setText(String.valueOf(zakazi.getPricec()));
order.setText(zakazi.getOrder());

updateB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String cn=Cname.getText().toString();
       String orderr=order.getText().toString();
       int p=Integer.parseInt(price.getText().toString());

       zakazi.setClName(cn);
       zakazi.setPricec(p);
       zakazi.setOrder(orderr);
        StartActivity.myAppDatabase.myDao().updateZakazi(zakazi);

    }
});
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
