package com.example.yuyakawakami.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public class Board{

        bool [][] red;
        bool [][] yellow;

        public Board(){
            this.red = new bool[3][3];
            this.yellow = new bool[3][3];
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
