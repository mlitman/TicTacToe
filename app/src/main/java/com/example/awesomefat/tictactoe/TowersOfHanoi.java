package com.example.awesomefat.tictactoe;

import android.icu.lang.UCharacter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class TowersOfHanoi extends AppCompatActivity
{
    private TextView disc0, disc1, disc2;
    private ViewGroup holdingZone, tower0, tower1, tower2;
    private Button tower0Button, tower1Button, tower2Button;
    private boolean selectSource = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towers_of_hanoi);

        this.disc0 = (TextView)this.findViewById(R.id.disk0);
        this.disc1 = (TextView)this.findViewById(R.id.disc1);
        this.disc2 = (TextView)this.findViewById(R.id.disc2);

        this.holdingZone = (ViewGroup)this.findViewById(R.id.holdingZone);
        this.tower0 = (ViewGroup)this.findViewById(R.id.tower0);
        this.tower1 = (ViewGroup)this.findViewById(R.id.tower1);
        this.tower2 = (ViewGroup)this.findViewById(R.id.tower2);

        this.tower0Button = (Button)this.findViewById(R.id.tower0Button);
        this.tower1Button = (Button)this.findViewById(R.id.tower1Button);
        this.tower2Button = (Button)this.findViewById(R.id.tower2Button);
    }

    private void setTowerButtonText(String s)
    {
        this.tower0Button.setText(s);
        this.tower1Button.setText(s);
        this.tower2Button.setText(s);
    }

    private int indexOf(Object[] ar, Object o)
    {
        for(int i = 0; i < ar.length; i++)
        {
            if(ar[i] == o)
            {
                return i;
            }
        }
        return -1;
    }

    private ViewGroup findTowerGivenButton(Button b)
    {
        //search the buttons and return the tower associated with that button
        Button[] towerButtons = {this.tower0Button, this.tower1Button, this.tower2Button};
        ViewGroup[] towers = {this.tower0, this.tower1, this.tower2};
        int pos = this.indexOf(towerButtons, b);
        return towers[pos];
    }

    public void onTowerButtonPressed(View v)
    {
        Button b = (Button)v;
        ViewGroup tower = this.findTowerGivenButton(b);
        if(this.selectSource)
        {
            View diskToRemove = tower.getChildAt(0);
            if(diskToRemove != null)
            {
                tower.removeViewAt(0);
                this.holdingZone.addView(diskToRemove);
                this.setTowerButtonText("DEST");
                this.selectSource = !this.selectSource;
            }

        }
        else
        {
            View diskToPlace = this.holdingZone.getChildAt(0);
            View currentTop = tower.getChildAt(0);
            if(currentTop == null || diskToPlace.getWidth() < currentTop.getWidth())
            {
                this.holdingZone.removeViewAt(0);
                tower.addView(diskToPlace,0);
                this.setTowerButtonText("SOURCE");
                this.selectSource = !this.selectSource;

                if(this.tower2.getChildCount() == 3)
                {
                    Toast t= Toast.makeText(this, "WINNER!!!!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.TOP, 0, 0);
                    t.show();
                }
            }
        }

        //this.selectSource = this.selectSource?false:true;


    }
}
