package com.example.admin.simplenetworking;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by admin on 8/4/2016.
 */
public class namesTask extends AsyncTask <String, Void, String> {

    private static final String TAG = namesTask.class.getSimpleName() + "TAG_";
    private TextView mTextView;
    private MainActivity mMainActivity;

    public namesTask(TextView myTextview) {
        mTextView = myTextview;
    }

    public namesTask(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... params) {
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

            return stringBuilder.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                connection.disconnect();
            }
        }

        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: " + s);
//        mTextView.setText(s);
        mMainActivity.loadData(s);
        super.onPostExecute(s);
    }
}
