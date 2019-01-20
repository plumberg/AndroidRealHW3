package com.example.gryzhuk.realhw3;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private GridGameAdapter mObjGridGameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            setupBoard();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setupBoard() throws IllegalAccessException {
        int squares = 64;
        int rows =  (int)(squares/Math.sqrt(squares));

        RecyclerView objRecyclerView = (RecyclerView) findViewById (R.id.recycler_view);
        objRecyclerView.setHasFixedSize (true);

        RecyclerView.LayoutManager objLayoutManager = new GridLayoutManager(this, rows); // cols/rows
        objLayoutManager.setAutoMeasureEnabled(true);

        try {
            mObjGridGameAdapter = new GridGameAdapter (squares);
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Number of Squares must allow for a perfect square board");
        }
        // GridGameAdapter objGridGameAdapter = new GridGameAdapter ();
        // put all three objects together
        objRecyclerView.setLayoutManager (objLayoutManager);
        objRecyclerView.setAdapter(mObjGridGameAdapter);


    }

    public void buttonHandler (View view)
    {
        View sbContainer = findViewById (R.id.activity_main); // this is the CoordinatorLayout above
        Button currentButton = (Button) view;
        String msg = "You clicked on " + currentButton.getText ().toString ();
        Snackbar.make (sbContainer, msg, Snackbar.LENGTH_SHORT).show ();
    }

}
