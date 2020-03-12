package com.example.ptljdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main9Activity extends AppCompatActivity {

    List<Product> productList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();




        productList.add(
                new Product(
                        "Name: Basil",
                        "Temperature(day): 20-35",
                        "Temperaturenight(night):20-30",
                        "pH:5.8-6.2              Humidity: 50-60",
                        "EC = ~ ppm*2 uS/cm: 1.0-1.5",
                        R.drawable.ba1));

        productList.add(
                new Product(
                        "Name: Lavender",
                        "Temperature(day): 20-25",
                        "Temperaturenight(night): 18-23",
                        "pH: 6.4-7.0              Humidity:40-60",
                        "EC = ~ ppm*2 uS/cm: 1.1-1.4",
                        R.drawable.la1));

        productList.add(
                new Product(
                        "Name: Mint",
                        "Temperature(day): 18-21",
                        "Temperaturenight(night): 15-20",
                        "pH: 5.5-6.0              Humidity: 70-75",
                        "EC = ~ ppm*2 uS/cm: 2.2-2.6",
                        R.drawable.mi1));

        ProductAdapter adapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_bar_title) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}