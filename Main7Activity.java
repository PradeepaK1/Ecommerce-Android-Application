package com.example.ptljdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }
    public void vegetable_crop (View view){
        Intent intent = new Intent (this, Main8Activity.class);
        startActivity(intent);
    }
    public void herbs (View view){
        Intent intent = new Intent (this, Main9Activity.class);
        startActivity(intent);

    }
    public void spices (View view){
        Intent intent = new Intent (this, Main10Activity.class);
        startActivity(intent);
    }
    public void guide (View view){
        Intent intent = new Intent (this,Main11Activity.class);
        startActivity(intent);
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

