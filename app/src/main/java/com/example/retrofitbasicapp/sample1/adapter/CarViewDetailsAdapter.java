package com.example.retrofitbasicapp.sample1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitbasicapp.R;
import com.example.retrofitbasicapp.sample1.model1.ScheduleDatesResp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarViewDetailsAdapter extends RecyclerView.Adapter
{
    Context context;
    List<ScheduleDatesResp> scheduleDatesRespList;


    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;


    public CarViewDetailsAdapter(Context context, List<ScheduleDatesResp> scheduleDatesRespList, RecyclerView rvProducts) {
        this.context = context;
        this.scheduleDatesRespList = scheduleDatesRespList;

    }

    @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
                return new LayoutOneViewHolder(view);

    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

            ((LayoutOneViewHolder) holder).bindItemView(scheduleDatesRespList.get(position));


    }
    public  class LayoutOneViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.linear_layout)
        LinearLayout linear_layout;
        @BindView(R.id.ll_headlayout)
        LinearLayout ll_headlayout;



        public LayoutOneViewHolder(@NonNull View itemView)
        {    super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindItemView(ScheduleDatesResp item) {
           if( item.getViewType()==0){
               ll_headlayout.setVisibility(View.VISIBLE);
               linear_layout.setVisibility(View.VISIBLE);
           }else{
               ll_headlayout.setVisibility(View.GONE);
               linear_layout.setVisibility(View.VISIBLE);
           }
     
        }
    }

    @Override
    public int getItemCount() {
        return  scheduleDatesRespList.size();
    }
}
