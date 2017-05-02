package com.example.giuseppedalpino.sensorostadium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmptyActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        text = (TextView) findViewById(R.id.text);
        text.setText("No beacons nearby!");
    }
}
