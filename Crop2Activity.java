package com.example.ptljdf;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class Crop2Activity extends AppCompatActivity {

    private TextView nameGuide;
    private TextToSpeech convertToSpeech;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop2);
        ListView itemList = (ListView)findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int crop2Id = bundle.getInt("CROP2_ID");
        int id = crop2Id + 1;

        TextView name = (TextView)findViewById(R.id.name);
        nameGuide = (TextView)findViewById(R.id.crop2);
        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);

        itemList.setAdapter(listAdapter);
        Button textToSpeech = (Button)findViewById(R.id.button);

        DbBackend dbBackend = new DbBackend(Crop2Activity.this);
        Crop1Object allCrop1Questions = dbBackend.getCrop1ById(id);

        name.setText(allCrop1Questions.getName());
        nameGuide.setText(allCrop1Questions.getDefinition());

        textToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String convertTextToSpeech = nameGuide.getText().toString();
                convertToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            convertToSpeech.setLanguage(Locale.US);
                            convertToSpeech.speak(convertTextToSpeech, TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }
                });
            }
        });
    }
    @Override
    protected void onPause() {
        if(convertToSpeech != null){
            convertToSpeech.stop();
            convertToSpeech.shutdown();
        }
        super.onPause();
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
