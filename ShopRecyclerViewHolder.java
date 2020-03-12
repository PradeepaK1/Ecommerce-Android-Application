package com.example.ptljdf.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ptljdf.R;
public class ShopRecyclerViewHolder extends RecyclerView.ViewHolder {
    public ImageView produceImage;
    public TextView productName;
    public ShopRecyclerViewHolder(View itemView) {
        super(itemView);
        produceImage =(ImageView)itemView.findViewById(R.id.product_image);
        productName = (TextView)itemView.findViewById(R.id.product_name);
    }
}