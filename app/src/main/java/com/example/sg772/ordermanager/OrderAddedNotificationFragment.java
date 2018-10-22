package com.example.sg772.ordermanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OrderAddedNotificationFragment extends Fragment {
    private Button mainMenu;
private TextView clName;
    private TextView order;
    private TextView price;
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.order_added_notification_layout,parent,false);
clName=(TextView)v.findViewById(R.id.clients_name_);
order=(TextView)v.findViewById(R.id.order_);
price=(TextView)v.findViewById(R.id.price_);
Bundle bundle=getArguments();
String c_name=bundle.getString("Name");
        String ord=bundle.getString("Order").toString();
        int pr=bundle.getInt("Price");
        clName.setText(c_name);
        order.setText(ord);
        price.setText(String.valueOf(pr));





        mainMenu=(Button)v.findViewById(R.id.main_menu_return__button);


mainMenu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OrdeMenurFragment omf=new OrdeMenurFragment();
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, omf);
        ft.addToBackStack(null);
        ft.commit();
    }
});
        return v;

    }
}
