package com.example.giuseppedalpino.sensorostadium;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sensoro.beacon.kit.Beacon;
import com.sensoro.beacon.kit.BeaconManagerListener;
import com.sensoro.cloud.SensoroManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        SensoroManager sensoroManager = SensoroManager.getInstance(getApplicationContext());
/**
 * Check whether the Bluetooth is on
 **/
        if (sensoroManager.isBluetoothEnabled()) {
            /**
             * Enable cloud service (upload sensor data, including battery status, UMM, etc.)。Without setup, it keeps in closed status as default.
             **/
            //sensoroManager.setCloudServiceEnable(true);
            /**
             * Enable SDK service
             **/
            try {
                sensoroManager.startService();
            } catch (Exception e) {
                e.printStackTrace(); // Fetch abnormal info
            }
        }
        else{
            Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(bluetoothIntent, RESULT_OK);//REQUEST_ENABLE_BT
        }

        BeaconManagerListener beaconManagerListener = new BeaconManagerListener() {

            @Override
            public void onUpdateBeacon(ArrayList<Beacon> beacons) {
                // Refresh sensor info
            }

            @Override
            public void onNewBeacon(Beacon beacon) {
                if (beacon.getSerialNumber().equals("0117C5578442")){
                    // Yunzi with SN "0117C5578442" enters the range

                    Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                    startActivity(intent);

                }

                if (beacon.getSerialNumber().equals("0117C59B4EC7")){
                    // Yunzi with SN "0117C59B4EC7" enters the range

                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onGoneBeacon(Beacon beacon) {
                if (beacon.getSerialNumber().equals("0117C5578442")){
                    // Yunzi with SN "0117C5578442" leaves the range
                    Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);
                    startActivity(intent);
                }

                if (beacon.getSerialNumber().equals("0117C59B4EC7")){
                    // Yunzi with SN "0117C59B4EC7" leaves the range
                    Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);
                    startActivity(intent);
                }

            }
        };

        sensoroManager.setBeaconManagerListener(beaconManagerListener);

    }
}
