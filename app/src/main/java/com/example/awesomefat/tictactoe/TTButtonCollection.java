package com.example.awesomefat.tictactoe;

import android.widget.Button;

public class TTButtonCollection
{
    private Button b1,b2,b3;
    private int[] vals;
    public TTButtonCollection(Button b1, Button b2, Button b3)
    {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        vals = new int[3];
        if(this.b1.getText().toString().equals("X"))
        {
            vals[0] = 1;
        }
        else if(this.b1.getText().toString().equals("O"))
        {
            vals[0] = -1;
        }
    }

    public boolean isWinner()
    {
        return (this.b1.getText().toString().equals("X") && this.b2.getText().toString().equals("X") &&
                this.b3.getText().toString().equals("X")) ||
                (this.b1.getText().toString().equals("O") && this.b2.getText().toString().equals("O") &&
                        this.b3.getText().toString().equals("O"));
    }
}
