package com.example.awesomefat.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ScrollViewExample extends AppCompatActivity
{
    private ViewGroup svContainer;
    private int count = 0;
    private EditText numRowsET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_example);

        this.svContainer = (ViewGroup)this.findViewById(R.id.svContainer);
        this.numRowsET = (EditText)this.findViewById(R.id.numRowsET);
    }

    public void onAddButtonClicked(View v)
    {
        int numRows = Integer.parseInt(this.numRowsET.getText().toString());

        for(int i = 0; i < numRows; i++)
        {
            TextView tv = new TextView(this);
            tv.setText("TextView " + this.count);
            if(this.count % 2 == 0)
            {
                this.svContainer.addView(tv, 0);
            }
            else
            {
                this.svContainer.addView(tv);
            }
            this.count++;
        }
    }
}
