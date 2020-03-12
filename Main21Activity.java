package com.example.ptljdf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main21Activity extends AppCompatActivity {
    Button SubmitButton ;

    EditText NameEditText, PhoneNumberEditText, mailIdEditText, addressEditText;
    public static final String Firebase_Server_URL = "https://ptljdf.firebaseio.com/";

    String NameHolder, NumberHolder,mailIdHolder, addressHolder;
    Firebase firebase;

    DatabaseReference databaseReference;

    public static final String Database_Path = "Farm_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        Firebase.setAndroidContext(Main21Activity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);
        NameEditText = (EditText)findViewById(R.id.name);
        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);
        mailIdEditText = (EditText)findViewById(R.id.mailId);
        addressEditText = (EditText)findViewById(R.id.address);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDetails userDetails = new UserDetails();

                GetDataFromEditText();

                userDetails.setUserName(NameHolder);

                userDetails.setUserPhoneNumber(NumberHolder);
                userDetails.setUsermailId(mailIdHolder);
                userDetails.setUseraddress(addressHolder);

                String UserRecordIDFromServer = databaseReference.push().getKey();

                databaseReference.child(UserRecordIDFromServer).setValue(userDetails);

                Toast.makeText(Main21Activity.this,"Order placed", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void GetDataFromEditText() {

        NameHolder = NameEditText.getText().toString().trim();
        NumberHolder = PhoneNumberEditText.getText().toString().trim();
        mailIdHolder = mailIdEditText.getText().toString().trim();
        addressHolder = addressEditText.getText().toString().trim();
    }
    }
