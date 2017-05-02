package com.example.giuseppedalpino.sensorostadium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {


    private ImageView img;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        img = (ImageView)findViewById(R.id.stadium);
        img.setImageResource(R.drawable.mappa);

        text = (TextView) findViewById(R.id.map);
        text.setText("Stadium Map");
    }
}
