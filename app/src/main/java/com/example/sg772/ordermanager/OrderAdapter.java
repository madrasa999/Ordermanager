package com.example.sg772.ordermanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public  class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
private List<Zakazi> zakazi;
public OrderAdapter(List<Zakazi> orders){zakazi=orders;}
    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_view_layout,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder orderViewHolder, int pos) {
    zakazi=StartActivity.myAppDatabase.myDao().getZakazi();
Zakazi z=zakazi.get(pos);
orderViewHolder.cName.setText(z.getClName());
        orderViewHolder.cOrder.setText(z.getOrder());
        orderViewHolder.cId.setText(String.valueOf(z.getId()));
        orderViewHolder.cPrice.setText(String.valueOf(z.getPricec()));
    }


    @Override
    public int getItemCount() {
        return zakazi.size();
    }

     class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView cId, cName, cOrder, cPrice;


        public OrderViewHolder(View itemView) {
            super(itemView);
            cId = (TextView) itemView.findViewById(R.id.id_list);
            cName = (TextView) itemView.findViewById(R.id.clName_list);
            cOrder = (TextView) itemView.findViewById(R.id.order_list);
            cPrice = (TextView) itemView.findViewById(R.id.price_list);

        }



        @Override
        public void onClick(View v) {

        }
    }
}


