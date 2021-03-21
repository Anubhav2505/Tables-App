package com.example.tablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tablesListView;
    public void generateTimesTable(int timesTable){
        ArrayList<String> timestablecontent = new ArrayList<String>();
        for(int i=1; i<=10 ; i++)
        {
            timestablecontent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timestablecontent);
        tablesListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar tablesSeekBar = (SeekBar) findViewById(R.id.tablesSeekBar);
        tablesListView = (ListView) findViewById(R.id.tablesListView);
        tablesSeekBar.setMax(20);
        tablesSeekBar.setProgress(10);
        tablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =1;
                int timestable;
                if (progress < min){
                    timestable = min;
                }
                else
                {
                    timestable = progress;
                }
                generateTimesTable(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);
    }
}