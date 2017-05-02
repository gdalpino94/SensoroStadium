package com.example.giuseppedalpino.sensorostadium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView img;
    private ImageView img2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        img = (ImageView)findViewById(R.id.imageView1);
        img.setImageResource(R.drawable.formazione);

        img2 = (ImageView)findViewById(R.id.imageView2);
        img2.setImageResource(R.drawable.sconto);

        text = (TextView) findViewById(R.id.incontro);
        text.setText("Lazio - Sampdoria");
    }
}
