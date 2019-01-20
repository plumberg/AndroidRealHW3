package com.example.gryzhuk.realhw3;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private GridGameAdapter objGridGameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBoard();
    }

    public void setupBoard(){
        RecyclerView objRecyclerView = (RecyclerView) findViewById (R.id.recycler_view);
        objRecyclerView.setHasFixedSize (true);
        RecyclerView.LayoutManager objLayoutManager = new GridLayoutManager(this, 4); // cols/rows
        GridGameAdapter objGridGameAdapter = new GridGameAdapter ();
        // put all three objects together
        objRecyclerView.setLayoutManager (objLayoutManager);
        objRecyclerView.setAdapter(objGridGameAdapter);

        objGridGameAdapter = new GridGameAdapter ();
    }

    public void buttonHandler (View view)
    {
        View sbContainer = findViewById (R.id.activity_main); // this is the CoordinatorLayout above
        Button currentButton = (Button) view;
        String msg = "You clicked on " + currentButton.getText ().toString ();
        Snackbar.make (sbContainer, msg, Snackbar.LENGTH_SHORT).show ();
    }

}
