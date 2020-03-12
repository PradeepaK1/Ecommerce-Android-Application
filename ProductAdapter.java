package com.example.ptljdf;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;



    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


        private Context mCtx;

        private List<Product> productList;

        public ProductAdapter(Context mCtx, List<Product> productList) {
            this.mCtx = mCtx;
            this.productList = productList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.layout_products, null);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            Product product = productList.get(position);

            holder.textViewName.setText(product.getName());
            holder.textViewTemperatureDay.setText(product.getTemperatureDay());
            holder.textViewTemperatureNight.setText(String.valueOf(product.getTemperatureNight()));
            holder.textViewHumidity.setText(product.getHumidity());
            holder.textViewpH.setText(String.valueOf(product.getpH()));
            holder.textViewEc.setText(product.getEc());

            holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        }


        @Override
        public int getItemCount() {
            return productList.size();
        }


        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView textViewName, textViewTemperatureDay, textViewTemperatureNight, textViewpH, textViewHumidity, textViewEc;
            ImageView imageView;

            public ProductViewHolder(View itemView) {
                super(itemView);

                textViewName = itemView.findViewById(R.id.textViewName);
                textViewTemperatureDay = itemView.findViewById(R.id.textViewTemperatureDay);
                textViewTemperatureNight = itemView.findViewById(R.id.textViewTemperatureNight);
                textViewpH = itemView.findViewById(R.id.textViewpH);
                textViewHumidity = itemView.findViewById(R.id.textViewHumidity);
                textViewEc = itemView.findViewById(R.id.textViewEc);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
