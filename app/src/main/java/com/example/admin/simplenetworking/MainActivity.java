package com.example.admin.simplenetworking;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void doMagic(View view) {
        String urlStr = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";
        HttpURLConnection connection = null;

        try {
            URL urlFormatted = new URL(urlStr);

            connection = (HttpURLConnection) urlFormatted.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());

            Scanner scan = new Scanner(in);
            StringBuilder stringBuilder = new StringBuilder();

            while (scan.hasNext()){
                stringBuilder.append(scan.next());
            }

            Log.d(TAG, "doMagic: " + stringBuilder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                connection.disconnect();
            }
        }
    }
}
