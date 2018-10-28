package com.example.awesomefat.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private String currentMove = "X";
    private TextView isWinnerTV;
    private Button r0c0,r0c1,r0c2,r1c0,r1c1,r1c2,r2c0,r2c1,r2c2;
    private TTButtonCollection row0, row1, row2, col0, col1, col2, dia0, dia1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.isWinnerTV = (TextView)this.findViewById(R.id.isWinnerTV);
        this.isWinnerTV.setText("");

        this.r0c0 = this.findViewById(R.id.r0c0);
        this.r0c1 = this.findViewById(R.id.r0c1);
        this.r0c2 = this.findViewById(R.id.r0c2);
        this.r1c0 = this.findViewById(R.id.r1c0);
        this.r1c1 = this.findViewById(R.id.r1c1);
        this.r1c2 = this.findViewById(R.id.r1c2);
        this.r2c0 = this.findViewById(R.id.r2c0);
        this.r2c1 = this.findViewById(R.id.r2c1);
        this.r2c2 = this.findViewById(R.id.r2c2);

        this.row0 = new TTButtonCollection(this.r0c0, this.r0c1, this.r0c2);
        this.row1 = new TTButtonCollection(this.r1c0, this.r1c1, this.r1c2);
        this.row2 = new TTButtonCollection(this.r2c0, this.r2c1, this.r2c2);
        this.col0 = new TTButtonCollection(this.r0c0, this.r1c0, this.r2c0);
        this.col1 = new TTButtonCollection(this.r0c1, this.r1c1, this.r2c1);
        this.col2 = new TTButtonCollection(this.r0c2, this.r1c2, this.r2c2);
        this.dia0 = new TTButtonCollection(this.r0c0, this.r1c1, this.r2c2);
        this.dia1 = new TTButtonCollection(this.r0c2, this.r1c1, this.r2c0);
    }

    private boolean isWinner()
    {
        return row0.isWinner() || row1.isWinner() || row2.isWinner() || col0.isWinner() || col1.isWinner() ||
                col2.isWinner() || dia0.isWinner() || dia1.isWinner();
    }

    public void onButtonClicked(View v)
    {
        Button b = (Button)v;
        if(b.getText().toString().equals("___"))
        {
            b.setText(currentMove);
            if(this.isWinner())
            {
                this.isWinnerTV.setText(this.currentMove + " is the Winner!");
            }

            if(currentMove.equals("X"))
            {
                currentMove = "O";
            }
            else
            {
                currentMove = "X";
            }
        }

    }

    public void onScrollViewExampleButtonClicked(View v)
    {
        Intent i = new Intent(this, ScrollViewExample.class);
        this.startActivity(i);
    }
}
