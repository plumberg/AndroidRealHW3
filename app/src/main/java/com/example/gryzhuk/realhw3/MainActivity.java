package com.example.gryzhuk.realhw3;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private GridGameAdapter mObjGridGameAdapter;
   private int mTurnsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTurnsClicked=0;
            setupBoard();


    }

    public void setupBoard()  {
        int squares = 4;
        int rows =  (int)(squares/Math.sqrt(squares));

        RecyclerView objRecyclerView = (RecyclerView) findViewById (R.id.recycler_view);
        objRecyclerView.setHasFixedSize (true);

        RecyclerView.LayoutManager objLayoutManager = new GridLayoutManager(this, rows); // cols/rows
       // objLayoutManager.setAutoMeasureEnabled(true);

            mObjGridGameAdapter = new GridGameAdapter (squares);

        // GridGameAdapter objGridGameAdapter = new GridGameAdapter ();
        // put all three objects together
        objRecyclerView.setLayoutManager (objLayoutManager);
        objRecyclerView.setAdapter(mObjGridGameAdapter);


    }

    public void buttonHandler (View view) {
        showGuessResults((Button) view);
        incrementGuessesCounterAndUpdateStatusBar();
    }

    private void showGuessResults(Button view) {
        View sbContainer = findViewById(R.id.activity_main);

        String currentText =view.getText().toString();
        int currentElement = Integer.parseInt(currentText);

        mTurnsClicked+=1;
        String msg = "You clicked on " + currentText + ".\n";
        msg+= mObjGridGameAdapter.isWinner(currentElement) ?
                "This is the winning number!" : "Please try a different number.";
        Snackbar.make (sbContainer, msg, Snackbar.LENGTH_SHORT).show ();
    }

    private void incrementGuessesCounterAndUpdateStatusBar() {
        TextView tvStatusBar = findViewById(R.id.status_bar);
        tvStatusBar.setText(getString(R.string.guesses_taken)+ mTurnsClicked);
    }

    public void newGame(MenuItem item) {
        mObjGridGameAdapter.startNewGame();

        mTurnsClicked =0;
        incrementGuessesCounterAndUpdateStatusBar();

        View sbContainer = findViewById(R.id.activity_main);
        Snackbar.make(sbContainer,"Welcome to a New Game!",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public void overwriteWinningNumber(int newWinningNumber){

    }
}
