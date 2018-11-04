package com.example.awesomefat.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TowersOfHanoi extends AppCompatActivity
{
    private TextView disc0, disc1, disc2;
    private ViewGroup holdingZone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towers_of_hanoi);

        this.disc0 = (TextView)this.findViewById(R.id.disk0);
        this.disc1 = (TextView)this.findViewById(R.id.disc1);
        this.disc2 = (TextView)this.findViewById(R.id.disc2);


    }
}
