package com.example.admin.simplenetworking;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = (TextView) findViewById(R.id.a_main_textview);
    }

    public void doMagic(View view) {
//        new namesTask(mTextview).execute();
        new namesTask(this).execute();
    }

    public void loadData(String s) {
        mTextview.setText(s);
    }
}
