package com.example.ptljdf;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main13Activity extends AppCompatActivity {

    Button SubmitButton ;

    EditText NameEditText, PhoneNumberEditText, mailIdEditText, addressEditText, Tomato_local_500g_35rsEditText,
            Onion_1kg_32rsEditText, Watermelon_1pc_59rsEditText, Amla_1kg_150rsEditText, Carrot_500g_53rsEditText,
            Potato_1kg_42rsEditText, Chilli_100g_18rsEditText, Ginger_250g_64rsEditText, Cucumber_500g_30rsEditText,
            Garlic_250g_42rsEditText, Tomato_hybrid_1kg_50rsEditText, Beetroot_500g_41rsEditText, Coconut_1pc_32rsEditText,
            Coccinia_250g_17rsEditText, Beans_500g_88rsEditText, Muskmelon_1pc_59rsEditText, Pomegranate_500g_77rsEditText,
            BottleGourd_1pc_35rsEditText, Turmeric_250g_15rsEditText, Pumpkin_1pc_56rsEditText, AloeVera_1pc_48rsEditText,
            BeansBroad_500g_58rsEditText, Bananaraw_250g_20rsEditText, BeansFrenchring_250g_39rsEditText,
            CapsicumGreen250g_28rsEditText, Cauliflower_1pc_66rsEditText, Babypotato_500g_41rsEditText, Pineapple_1pc_89rsEditText,
            BeansCluster_250g_19rsEditText, CucumberMalabar_1kg_34rsEditText, CapsicumYellow_1pc_75rsEditText, CapsicumRed_1pc_77rsEditText,
            Colocasia_250g_36rsEditText, NeemGiloy_100g_22rsEditText, LadiesFinger_500g_34rsEditText, Cabbage_1pc_27rsEditText, Lemon_4pc_48rsEditText,
            SweetLime_500g_68rsEditText, SambarOnion_250g_25rsEditText, BananaFlower_1pc_16rsEditText, MangoAlphonso_6pc_552rsEditText,
            BitterGourd_250g_35rsEditText, CorianderLeaves_250g_88rsEditText, CurryLeaves_100g_8rsEditText, Celery_250g_18rsEditText,
            PeaEggplantSundaikai_100g_15rsEditText, RawMango_1kg_39rsEditText, Broccoli_500g_95rsEditText, SweetCorn_1pc_14rsEditText;

    public static final String Firebase_Server_URL = "https://ptljdf.firebaseio.com/";

    String NameHolder, NumberHolder,mailIdHolder, addressHolder, Tomato_local_500g_35rsHolder,
            Onion_1kg_32rsHolder, Watermelon_1pc_59rsHolder, Amla_1kg_150rsHolder, Carrot_500g_53rsHolder,
            Potato_1kg_42rsHolder, Chilli_100g_18rsHolder, Ginger_250g_64rsHolder, Cucumber_500g_30rsHolder,
            Garlic_250g_42rsHolder, Tomato_hybrid_1kg_50rsHolder, Beetroot_500g_41rsHolder, Coconut_1pc_32rsHolder,
            Coccinia_250g_17rsHolder, Beans_500g_88rsHolder, Muskmelon_1pc_59rsHolder, Pomegranate_500g_77rsHolder,
            BottleGourd_1pc_35rsHolder, Turmeric_250g_15rsHolder, Pumpkin_1pc_56rsHolder, AloeVera_1pc_48rsHolder,
            BeansBroad_500g_58rsHolder, Bananaraw_250g_20rsHolder, BeansFrenchring_250g_39rsHolder,
            CapsicumGreen250g_28rsHolder, Cauliflower_1pc_66rsHolder, Babypotato_500g_41rsHolder, Pineapple_1pc_89rsHolder,
            BeansCluster_250g_19rsHolder, CucumberMalabar_1kg_34rsHolder, CapsicumYellow_1pc_75rsHolder, CapsicumRed_1pc_77rsHolder,
            Colocasia_250g_36rsHolder, NeemGiloy_100g_22rsHolder, LadiesFinger_500g_34rsHolder, Cabbage_1pc_27rsHolder, Lemon_4pc_48rsHolder,
            SweetLime_500g_68rsHolder, SambarOnion_250g_25rsHolder, BananaFlower_1pc_16rsHolder, MangoAlphonso_6pc_552rsHolder,
            BitterGourd_250g_35rsHolder, CorianderLeaves_250g_88rsHolder, CurryLeaves_100g_8rsHolder, Celery_250g_18rsHolder,
            PeaEggplantSundaikai_100g_15rsHolder, RawMango_1kg_39rsHolder, Broccoli_500g_95rsHolder, SweetCorn_1pc_14rsHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

    public static final String Database_Path = "Order_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        Firebase.setAndroidContext(Main13Activity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);
        NameEditText = (EditText)findViewById(R.id.name);
        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);
        mailIdEditText = (EditText)findViewById(R.id.mailId);
        addressEditText = (EditText)findViewById(R.id.address);
        Tomato_local_500g_35rsEditText = (EditText)findViewById(R.id.Tomato_local_500g_35rs);
        Onion_1kg_32rsEditText = (EditText)findViewById(R.id.Onion_1kg_32rs);
        Watermelon_1pc_59rsEditText = (EditText)findViewById(R.id.Watermelon_1pc_59rs);
        Amla_1kg_150rsEditText = (EditText)findViewById(R.id.Amla_1kg_150rs);
        Carrot_500g_53rsEditText = (EditText)findViewById(R.id.Carrot_500g_53rs);
        Potato_1kg_42rsEditText = (EditText)findViewById(R.id.Potato_1kg_42rs);
        Chilli_100g_18rsEditText = (EditText)findViewById(R.id.Chilli_100g_18rs);
        Ginger_250g_64rsEditText = (EditText)findViewById(R.id.Ginger_250g_64rs);
        Cucumber_500g_30rsEditText = (EditText)findViewById(R.id.Cucumber_500g_30rs);
        Garlic_250g_42rsEditText = (EditText)findViewById(R.id.Garlic_250g_42rs);
        Tomato_hybrid_1kg_50rsEditText = (EditText)findViewById(R.id.Tomato_hybrid_1kg_50rs);
        Beetroot_500g_41rsEditText = (EditText)findViewById(R.id.Beetroot_500g_41rs);
        Coconut_1pc_32rsEditText = (EditText)findViewById(R.id.Coconut_1pc_32rs);
        Coccinia_250g_17rsEditText = (EditText)findViewById(R.id.Coccinia_250g_17rs);
        Beans_500g_88rsEditText = (EditText)findViewById(R.id.Beans_500g_88rs);
        Muskmelon_1pc_59rsEditText = (EditText)findViewById(R.id.Muskmelon_1pc_59rs);
        Pomegranate_500g_77rsEditText = (EditText)findViewById(R.id.Pomegranate_500g_77rs);
        BottleGourd_1pc_35rsEditText = (EditText)findViewById(R.id.BottleGourd_1pc_35rs);
        Turmeric_250g_15rsEditText = (EditText)findViewById(R.id.Turmeric_250g_15rs);
        Pumpkin_1pc_56rsEditText = (EditText)findViewById(R.id.Pumpkin_1pc_56rs);
        AloeVera_1pc_48rsEditText = (EditText)findViewById(R.id.AloeVera_1pc_48rs);
        BeansBroad_500g_58rsEditText = (EditText)findViewById(R.id.BeansBroad_500g_58rs);
        Bananaraw_250g_20rsEditText = (EditText)findViewById(R.id.Bananaraw_250g_20rs);
        BeansFrenchring_250g_39rsEditText = (EditText)findViewById(R.id.BeansFrenchring_250g_39rs);
        CapsicumGreen250g_28rsEditText = (EditText)findViewById(R.id.CapsicumGreen250g_28rs);
        Cauliflower_1pc_66rsEditText = (EditText)findViewById(R.id.Cauliflower_1pc_66rs);
        Babypotato_500g_41rsEditText = (EditText)findViewById(R.id.Babypotato_500g_41rs);
        Pineapple_1pc_89rsEditText = (EditText)findViewById(R.id.Pineapple_1pc_89rs);
        BeansCluster_250g_19rsEditText = (EditText)findViewById(R.id.BeansCluster_250g_19rs);
        CucumberMalabar_1kg_34rsEditText = (EditText)findViewById(R.id.CucumberMalabar_1kg_34rs);
        CapsicumYellow_1pc_75rsEditText = (EditText)findViewById(R.id.CapsicumYellow_1pc_75rs);
        CapsicumRed_1pc_77rsEditText = (EditText)findViewById(R.id.CapsicumRed_1pc_77rs);
        Colocasia_250g_36rsEditText = (EditText)findViewById(R.id.Colocasia_250g_36rs);
        NeemGiloy_100g_22rsEditText = (EditText)findViewById(R.id.NeemGiloy_100g_22rs);
        LadiesFinger_500g_34rsEditText = (EditText)findViewById(R.id.LadiesFinger_500g_34rs);
        Cabbage_1pc_27rsEditText = (EditText)findViewById(R.id.Cabbage_1pc_27rs);
        Lemon_4pc_48rsEditText = (EditText)findViewById(R.id.Lemon_4pc_48rs);
        SweetLime_500g_68rsEditText = (EditText)findViewById(R.id.SweetLime_500g_68rs);
        SambarOnion_250g_25rsEditText = (EditText)findViewById(R.id.SambarOnion_250g_25rs);
        BananaFlower_1pc_16rsEditText = (EditText)findViewById(R.id.BananaFlower_1pc_16rs);
        MangoAlphonso_6pc_552rsEditText = (EditText)findViewById(R.id.MangoAlphonso_6pc_552rs);
        BitterGourd_250g_35rsEditText = (EditText)findViewById(R.id.BitterGourd_250g_35rs);
        CorianderLeaves_250g_88rsEditText = (EditText)findViewById(R.id.CorianderLeaves_250g_88rs);
        CurryLeaves_100g_8rsEditText = (EditText)findViewById(R.id.CurryLeaves_100g_8rs);
        Celery_250g_18rsEditText = (EditText)findViewById(R.id.Celery_250g_18rs);
        PeaEggplantSundaikai_100g_15rsEditText = (EditText)findViewById(R.id.PeaEggplantSundaikai_100g_15rs);
        RawMango_1kg_39rsEditText = (EditText)findViewById(R.id.RawMango_1kg_39rs);
        Broccoli_500g_95rsEditText = (EditText)findViewById(R.id.Broccoli_500g_95rs);
        SweetCorn_1pc_14rsEditText = (EditText)findViewById(R.id.SweetCorn_1pc_14rs);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDetails userDetails = new UserDetails();

                GetDataFromEditText();

                userDetails.setUserName(NameHolder);

                userDetails.setUserPhoneNumber(NumberHolder);
                userDetails.setUsermailId(mailIdHolder);
                userDetails.setUseraddress(addressHolder);
                userDetails.setTomato_local_500g_35rs(Tomato_local_500g_35rsHolder);
                userDetails.setOnion_1kg_32rs(Onion_1kg_32rsHolder);
                userDetails.setWatermelon_1pc_59rs(Watermelon_1pc_59rsHolder);
                userDetails.setAmla_1kg_150rs(Amla_1kg_150rsHolder);
                userDetails.setCarrot_500g_53rs(Carrot_500g_53rsHolder);
                userDetails.setPotato_1kg_42rs(Potato_1kg_42rsHolder);
                userDetails.setChilli_100g_18rs(Chilli_100g_18rsHolder);
                userDetails.setGinger_250g_64rs(Ginger_250g_64rsHolder);
                userDetails.setCucumber_500g_30rs(Cucumber_500g_30rsHolder);
                userDetails.setGarlic_250g_42rs(Garlic_250g_42rsHolder);
                userDetails.setTomato_hybrid_1kg_50rs(Tomato_hybrid_1kg_50rsHolder);
                userDetails.setBeetroot_500g_41rs(Beetroot_500g_41rsHolder);
                userDetails.setCoconut_1pc_32rs(Coconut_1pc_32rsHolder);
                userDetails.setCoccinia_250g_17rs(Coccinia_250g_17rsHolder);
                userDetails.setBeans_500g_88rs(Beans_500g_88rsHolder);
                userDetails.setMuskmelon_1pc_59rs(Muskmelon_1pc_59rsHolder);
                userDetails.setPomegranate_500g_77rs(Pomegranate_500g_77rsHolder);
                userDetails.setBottleGourd_1pc_35rs(BottleGourd_1pc_35rsHolder);
                userDetails.setTurmeric_250g_15rs(Turmeric_250g_15rsHolder);
                userDetails.setPumpkin_1pc_56rs(Pumpkin_1pc_56rsHolder);
                userDetails.setAloeVera_1pc_48rs(AloeVera_1pc_48rsHolder);
                userDetails.setBeansBroad_500g_58rs(BeansBroad_500g_58rsHolder);
                userDetails.setBananaraw_250g_20rs(Bananaraw_250g_20rsHolder);
                userDetails.setBeansFrenchring_250g_39rs(BeansFrenchring_250g_39rsHolder);
                userDetails.setCapsicumGreen250g_28rs(CapsicumGreen250g_28rsHolder);
                userDetails.setCauliflower_1pc_66rs(Cauliflower_1pc_66rsHolder);
                userDetails.setBabypotato_500g_41rs(Babypotato_500g_41rsHolder);
                userDetails.setPineapple_1pc_89rs(Pineapple_1pc_89rsHolder);
                userDetails.setBeansCluster_250g_19rs(BeansCluster_250g_19rsHolder);
                userDetails.setCucumberMalabar_1kg_34rs(CucumberMalabar_1kg_34rsHolder);
                userDetails.setCapsicumYellow_1pc_75rs(CapsicumYellow_1pc_75rsHolder);
                userDetails.setCapsicumRed_1pc_77rs(CapsicumRed_1pc_77rsHolder);
                userDetails.setColocasia_250g_36rs(Colocasia_250g_36rsHolder);
                userDetails.setNeemGiloy_100g_22rs(NeemGiloy_100g_22rsHolder);
                userDetails.setLadiesFinger_500g_34rs(LadiesFinger_500g_34rsHolder);
                userDetails.setCabbage_1pc_27rs(Cabbage_1pc_27rsHolder);
                userDetails.setLemon_4pc_48rs(Lemon_4pc_48rsHolder);
                userDetails.setSweetLime_500g_68rs(SweetLime_500g_68rsHolder);
                userDetails.setSambarOnion_250g_25rs(SambarOnion_250g_25rsHolder);
                userDetails.setBananaFlower_1pc_16rs(BananaFlower_1pc_16rsHolder);
                userDetails.setMangoAlphonso_6pc_552rs(MangoAlphonso_6pc_552rsHolder);
                userDetails.setBitterGourd_250g_35rs(BitterGourd_250g_35rsHolder);
                userDetails.setCorianderLeaves_250g_88rs(CorianderLeaves_250g_88rsHolder);
                userDetails.setCurryLeaves_100g_8rs(CurryLeaves_100g_8rsHolder);
                userDetails.setCelery_250g_18rs(Celery_250g_18rsHolder);
                userDetails.setPeaEggplantSundaikai_100g_15rs(PeaEggplantSundaikai_100g_15rsHolder);
                userDetails.setRawMango_1kg_39rs(RawMango_1kg_39rsHolder);
                userDetails.setBroccoli_500g_95rs(Broccoli_500g_95rsHolder);
                userDetails.setSweetCorn_1pc_14rs(SweetCorn_1pc_14rsHolder);


                String UserRecordIDFromServer = databaseReference.push().getKey();

                databaseReference.child(UserRecordIDFromServer).setValue(userDetails);

                Toast.makeText(Main13Activity.this,"Order placed", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void GetDataFromEditText(){

        NameHolder = NameEditText.getText().toString().trim();
        NumberHolder = PhoneNumberEditText.getText().toString().trim();
        mailIdHolder = mailIdEditText.getText().toString().trim();
        addressHolder = addressEditText.getText().toString().trim();
        Tomato_local_500g_35rsHolder = Tomato_local_500g_35rsEditText.getText().toString().trim();
        Onion_1kg_32rsHolder = Onion_1kg_32rsEditText.getText().toString().trim();
        Watermelon_1pc_59rsHolder = Watermelon_1pc_59rsEditText.getText().toString().trim();
        Amla_1kg_150rsHolder = Amla_1kg_150rsEditText.getText().toString().trim();
        Carrot_500g_53rsHolder = Carrot_500g_53rsEditText.getText().toString().trim();
        Potato_1kg_42rsHolder = Potato_1kg_42rsEditText.getText().toString().trim();
        Chilli_100g_18rsHolder = Chilli_100g_18rsEditText.getText().toString().trim();
        Ginger_250g_64rsHolder = Ginger_250g_64rsEditText.getText().toString().trim();
        Cucumber_500g_30rsHolder = Cucumber_500g_30rsEditText.getText().toString().trim();
        Garlic_250g_42rsHolder = Garlic_250g_42rsEditText.getText().toString().trim();
        Tomato_hybrid_1kg_50rsHolder = Tomato_hybrid_1kg_50rsEditText.getText().toString().trim();
        Beetroot_500g_41rsHolder = Beetroot_500g_41rsEditText.getText().toString().trim();
        Coconut_1pc_32rsHolder = Coconut_1pc_32rsEditText.getText().toString().trim();
        Coccinia_250g_17rsHolder = Coccinia_250g_17rsEditText.getText().toString().trim();
        Beans_500g_88rsHolder = Beans_500g_88rsEditText.getText().toString().trim();
        Muskmelon_1pc_59rsHolder = Muskmelon_1pc_59rsEditText.getText().toString().trim();
        Pomegranate_500g_77rsHolder = Pomegranate_500g_77rsEditText.getText().toString().trim();
        BottleGourd_1pc_35rsHolder = BottleGourd_1pc_35rsEditText.getText().toString().trim();
        Turmeric_250g_15rsHolder = Turmeric_250g_15rsEditText.getText().toString().trim();
        Pumpkin_1pc_56rsHolder = Pumpkin_1pc_56rsEditText.getText().toString().trim();
        AloeVera_1pc_48rsHolder = AloeVera_1pc_48rsEditText.getText().toString().trim();
        BeansBroad_500g_58rsHolder = BeansBroad_500g_58rsEditText.getText().toString().trim();
        Bananaraw_250g_20rsHolder = Bananaraw_250g_20rsEditText.getText().toString().trim();
        BeansFrenchring_250g_39rsHolder = BeansFrenchring_250g_39rsEditText.getText().toString().trim();
        CapsicumGreen250g_28rsHolder = CapsicumGreen250g_28rsEditText.getText().toString().trim();
        Cauliflower_1pc_66rsHolder = Cauliflower_1pc_66rsEditText.getText().toString().trim();
        Babypotato_500g_41rsHolder = Babypotato_500g_41rsEditText.getText().toString().trim();
        Pineapple_1pc_89rsHolder = Pineapple_1pc_89rsEditText.getText().toString().trim();
        BeansCluster_250g_19rsHolder = BeansCluster_250g_19rsEditText.getText().toString().trim();
        CucumberMalabar_1kg_34rsHolder = CucumberMalabar_1kg_34rsEditText.getText().toString().trim();
        CapsicumYellow_1pc_75rsHolder = CapsicumYellow_1pc_75rsEditText.getText().toString().trim();
        CapsicumRed_1pc_77rsHolder = CapsicumRed_1pc_77rsEditText.getText().toString().trim();
        Colocasia_250g_36rsHolder = Colocasia_250g_36rsEditText.getText().toString().trim();
        NeemGiloy_100g_22rsHolder = NeemGiloy_100g_22rsEditText.getText().toString().trim();
        LadiesFinger_500g_34rsHolder = LadiesFinger_500g_34rsEditText.getText().toString().trim();
        Cabbage_1pc_27rsHolder = Cabbage_1pc_27rsEditText.getText().toString().trim();
        Lemon_4pc_48rsHolder = Lemon_4pc_48rsEditText.getText().toString().trim();
        SweetLime_500g_68rsHolder = SweetLime_500g_68rsEditText.getText().toString().trim();
        SambarOnion_250g_25rsHolder = SambarOnion_250g_25rsEditText.getText().toString().trim();
        BananaFlower_1pc_16rsHolder = BananaFlower_1pc_16rsEditText.getText().toString().trim();
        MangoAlphonso_6pc_552rsHolder = MangoAlphonso_6pc_552rsEditText.getText().toString().trim();
        BitterGourd_250g_35rsHolder = BitterGourd_250g_35rsEditText.getText().toString().trim();
        CorianderLeaves_250g_88rsHolder = CorianderLeaves_250g_88rsEditText.getText().toString().trim();
        CurryLeaves_100g_8rsHolder = CurryLeaves_100g_8rsEditText.getText().toString().trim();
        Celery_250g_18rsHolder = Celery_250g_18rsEditText.getText().toString().trim();
        PeaEggplantSundaikai_100g_15rsHolder = PeaEggplantSundaikai_100g_15rsEditText.getText().toString().trim();
        RawMango_1kg_39rsHolder = RawMango_1kg_39rsEditText.getText().toString().trim();
        Broccoli_500g_95rsHolder = Broccoli_500g_95rsEditText.getText().toString().trim();
        SweetCorn_1pc_14rsHolder = SweetCorn_1pc_14rsEditText.getText().toString().trim();

    }
    public void nxt (View view){
        Intent intent = new Intent (this, CheckoutActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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