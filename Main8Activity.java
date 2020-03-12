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

public class Main8Activity extends AppCompatActivity {

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
                        "Name: Strawberry",
                        "Temperature(day): 16-27",
                        "Temperaturenight(night): 10-12",
                        "pH:5.8-6.2               Humidity:65-75",
                        "EC = ~ ppm*2 uS/cm: 1.8-2.2",

                        R.drawable.st1));

        productList.add(
                new Product(
                        "Name: Lettuce",
                        "Temperature(day): 20-23",
                        "Temperaturenight(night):12-15",
                        "pH:5.5-6.5              Humidity: 50-80",
                        "EC = ~ ppm*2 uS/cm: 1.8-2.2",
                        R.drawable.le1));

        productList.add(
                new Product(
                        "Name: Spinach",
                        "Temperature(day): 22-24",
                        "Temperaturenight(night): 18-20",
                        "pH: 5.8-6.5              Humidity:50-80",
                        "EC = ~ ppm*2 uS/cm: 1.2-1.5",
                        R.drawable.sp1));

        productList.add(
                new Product(
                        "Name: Tomato",
                        "Temperature(day): 18-30",
                        "Temperaturenight(night): 13-24",
                        "pH: 6.0-6.5             Humidity: 70-80",
                        "EC = ~ ppm*2 uS/cm: 2.2-2.4",
                        R.drawable.to1));

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