package com.example.ptljdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ConfirmActivity extends AppCompatActivity {
    private EditText nameEditText, phoneEditText, AddressEditText, cityEditText;
    private Button confirm_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        confirm_order=(Button)findViewById(R.id.confirm_order_button);
        nameEditText=(EditText) findViewById(R.id.shipment_name);
        nameEditText=(EditText) findViewById(R.id.shipment_phone);
        nameEditText=(EditText) findViewById(R.id.shipment_address);
        nameEditText=(EditText) findViewById(R.id.shipment_city);


    }
}
