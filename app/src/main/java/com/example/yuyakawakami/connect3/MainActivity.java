package com.example.yuyakawakami.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Board board;
    int round = 0;

    public class Board{

        Boolean [][] red;
        Boolean [][] yellow;
        Pair solved;

        private class Pair {
            int player;
            Boolean solved;

            private Pair(Boolean solved){
                this.player = 0;
                this.solved = solved;
            }

            private void set(int player, Boolean solved){
                this.player = player;
                this.solved = solved;
            }


        }


        private Board(){
            this.red = new Boolean [3][3];
            this.yellow = new Boolean [3][3];
            this.solved = new Pair(false);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    red[i][j] = false;
                    yellow[i][j] = false;
                }
            }
        }

        private Boolean isSolved(){
            return this.solved.solved;
        }

        private void check(){
            checkVerticals();
            checkHorizontals();
            checkDiagonals();
        }

        private void checkVerticals(){
            for (int i = 0; i < 3; i++){
                if (red[0][i] && red[1][i] && red[2][i]){
                    solved.set(1, true);
                    break;
                }
                if (yellow[0][i] && yellow[1][i] && yellow[2][i]){
                    solved.set(2, true);
                    break;
                }
            }
        }

        private void checkHorizontals(){
            for (int i = 0; i < 3; i++){
                if (red[i][0] && red[i][1] && red[i][1]){
                    solved.set(1, true);
                    break;
                }
                if (yellow[i][0] && yellow[i][1] && yellow[i][2]){
                    solved.set(2, true);
                    break;
                }
            }
        }

        private void checkDiagonals(){
            if ((red[0][0] && red[1][1] && red[2][2]) || (red[2][0] && red[1][1] && red[0][2])){
                solved.set(1, true);
            }
            if ((yellow[0][0] && yellow[1][1] && yellow[2][2]) || (yellow[2][0] && yellow[1][1] && yellow[0][2])){
                solved.set(2, true);
            }

        }

    }

    public void click1(View view){
        if (this.round % 2 == 0){
            ImageView R1 = findViewById(R.id.R1);
            R1.animate().alpha(1f).setDuration(100);
            board.red[0][0] = true;
        }
        else {
            ImageView Y1 = findViewById(R.id.Y1);
            Y1.animate().alpha(1f).setDuration(100);
            board.yellow[0][0] = true;
        }
        round++;
    }
    public void click2(View view){
        if (this.round % 2 == 0){
            ImageView R2 = findViewById(R.id.R2);
            R2.animate().alpha(1f).setDuration(100);
            board.red[0][1] = true;
        }
        else {
            ImageView Y2 = findViewById(R.id.Y2);
            Y2.animate().alpha(1f).setDuration(100);
            board.yellow[0][1] = true;
        }
        round++;
    }
    public void click3(View view){
        if (this.round % 2 == 0){
            ImageView R3 = findViewById(R.id.R3);
            R3.animate().alpha(1f).setDuration(100);
            board.red[0][2] = true;
        }
        else {
            ImageView Y3 = findViewById(R.id.Y3);
            Y3.animate().alpha(1f).setDuration(100);
            board.yellow[0][2] = true;
        }
        round++;
    }
    public void click4(View view){
        if (this.round % 2 == 0){
            ImageView R4 = findViewById(R.id.R4);
            R4.animate().alpha(1f).setDuration(100);
            board.red[1][0] = true;
        }
        else {
            ImageView Y4 = findViewById(R.id.Y4);
            Y4.animate().alpha(1f).setDuration(100);
            board.yellow[1][0] = true;
        }
        round++;
    }
    public void click5(View view){
        if (this.round % 2 == 0){
            ImageView R5 = findViewById(R.id.R5);
            R5.animate().alpha(1f).setDuration(100);
            board.red[1][1] = true;
        }
        else {
            ImageView Y5 = findViewById(R.id.Y5);
            Y5.animate().alpha(1f).setDuration(100);
            board.yellow[1][1] = true;
        }
        round++;
    }
    public void click6(View view){
        if (this.round % 2 == 0){
            ImageView R6 = findViewById(R.id.R6);
            R6.animate().alpha(1f).setDuration(100);
            board.red[1][2] = true;
        }
        else {
            ImageView Y6 = findViewById(R.id.Y6);
            Y6.animate().alpha(1f).setDuration(100);
            board.yellow[1][2] = true;
        }
        round++;
    }
    public void click7(View view){
        if (this.round % 2 == 0){
            ImageView R7 = findViewById(R.id.R7);
            R7.animate().alpha(1f).setDuration(100);
            board.red[2][0] = true;
        }
        else {
            ImageView Y7 = findViewById(R.id.Y7);
            Y7.animate().alpha(1f).setDuration(100);
            board.yellow[2][0] = true;
        }
        round++;
    }
    public void click8(View view){
        if (this.round % 2 == 0){
            ImageView R8 = findViewById(R.id.R8);
            R8.animate().alpha(1f).setDuration(100);
            board.red[2][1] = true;
        }
        else {
            ImageView Y8 = findViewById(R.id.Y8);
            Y8.animate().alpha(1f).setDuration(100);
            board.yellow[2][1] = true;
        }
        round++;
    }
    public void click9(View view){
        if (this.round % 2 == 0){
            ImageView R9 = findViewById(R.id.R9);
            R9.animate().alpha(1f).setDuration(100);
            board.red[2][2] = true;
        }
        else {
            ImageView Y9 = findViewById(R.id.Y9);
            Y9.animate().alpha(1f).setDuration(100);
            board.yellow[2][2] = true;
        }
        round++;
    }

    public void start(View view){
        this.board = new Board();
        while (round < 9 || !board.isSolved()){
            Log.i("Current round: ", Integer.toString(round));
            board.check();
        }
        if (board.solved.player == 0){
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
        }
        else if (board.solved.player == 1){
            Toast.makeText(this, "Red Wins!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Yellow Wins!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
