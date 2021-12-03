package com.example.retrofitbasicapp.sample1.adapter;

import android.content.Context;
import android.util.Log;
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

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarDetailsAdapter extends RecyclerView.Adapter
{
    Context context;
    List<ScheduleDatesResp> scheduleDatesRespList;


    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;


    public CarDetailsAdapter(Context context, List<ScheduleDatesResp> scheduleDatesRespList, RecyclerView rvProducts) {
        this.context = context;
        this.scheduleDatesRespList = scheduleDatesRespList;
        if (rvProducts.getLayoutManager() instanceof GridLayoutWrapper) {
            ((GridLayoutWrapper) rvProducts.getLayoutManager()).setSpanSizeLookup(new GridLayoutWrapper.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return isHeaderType(position) == TYPE_HEADER ? (isHeaderType(position) == TYPE_FOOTER ? 0 : 1) : 1;
                }
            });
        }
    }

    private int isHeaderType(int position) {
        try {
            if (isFooter(position)) {
                return TYPE_FOOTER;
            } else {
                boolean isHeader =false;
                if(scheduleDatesRespList.get(position).getViewType()==0){
                    isHeader=true;
                }
                return isHeader ? TYPE_HEADER : TYPE_FOOTER;
            }
        } catch (Exception e) {
            return TYPE_FOOTER;
        }
    }
    private boolean isFooter(int position) {
        return scheduleDatesRespList.get(position) == null;
    }

    @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType)
        {
            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_type_row, parent, false);
                return new LayoutOneViewHolder(view);
            case TYPE_FOOTER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_details_row, parent, false);
                return new LayoutTwoViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (scheduleDatesRespList.get(position).getViewType()) {
            case 0:
                return TYPE_HEADER;
            case 1:
                return TYPE_FOOTER;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            ((LayoutOneViewHolder) holder).bindItemView(scheduleDatesRespList.get(position));
        }else if (getItemViewType(position) == TYPE_FOOTER) {
            ((LayoutTwoViewHolder) holder).bindItemView(scheduleDatesRespList.get(position));

        }

    }
    public  class LayoutOneViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txtCarType)
        TextView txtCarType;
        @BindView(R.id.txtStartPriceValue)
        TextView txtStartPriceValue;
        @BindView(R.id.txtAgeValue)
        TextView txtAgeValue;
        @BindView(R.id.txtCapacityValue)
        TextView txtCapacityValue;
        @BindView(R.id.txtAvailableValue)
        TextView txtAvailableValue;
        @BindView(R.id.txtDesc)
        TextView txtDesc;
        @BindView(R.id.imgCarImage)
        ImageView imgCarImage;


        public LayoutOneViewHolder(@NonNull View itemView)
        {    super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindItemView(ScheduleDatesResp item) {
            txtCarType.setText(item.getVehicle().getBrand());
            txtCapacityValue.setText(String.valueOf(item.getVehicle().getCapacity()));
        }
    }
    public  class LayoutTwoViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txtBrandName)
        TextView txtBrandName;
        @BindView(R.id.txtAvailable)
        TextView txtAvailableLbl;
        @BindView(R.id.txtActualPrice)
        TextView txtActualPrice;
        @BindView(R.id.txtCarTime)
        TextView txtCarTime;
        @BindView(R.id.txtToFrom)
        TextView txtToFrom;
        @BindView(R.id.txtDiscountedPrice)
        TextView txtDiscountedPrice;
        @BindView(R.id.txtRatingValue)
        TextView txtRatingValue;
        @BindView(R.id.txtCouponCode)
        TextView txtCouponCode;
        @BindView(R.id.imgBrandImg)
        ImageView imgBrandImg;
        @BindView(R.id.linear_layout)
        LinearLayout linear_layout;
        public LayoutTwoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindItemView(ScheduleDatesResp item) {
            txtAvailableLbl.setText(item.getStatus());
            txtActualPrice.setText(String.valueOf(item.getPrice()));
             txtBrandName.setText(item.getVehicle().getBrand());
            txtDiscountedPrice.setText(String.valueOf(item.getPrice()));
        }
    }
    @Override
    public int getItemCount() {
        return  scheduleDatesRespList.size();
    }
}
