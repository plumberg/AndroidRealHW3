package com.example.gryzhuk.realhw3;


import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class GridGameAdapter  extends RecyclerView.Adapter<GridGameAdapter.ViewHolder>{
    private boolean [] mSquares;
    private static int DEFAULT_ELEMENTS = 16;
    private int mElements, mWinningNumber;
    private Random mGenerator;


    public GridGameAdapter()  {
       // mSquares = new boolean[16];
        this(DEFAULT_ELEMENTS);

    }
    public GridGameAdapter(int elements)  {
        mElements = elements;
        mGenerator = new Random();


        //if(elements % Math.sqrt(elements)==0){
            mSquares=new boolean[elements];
      //  }
       // else{
        //    Toast.makeText(,"Number of Squares must allow for a perfect square board",Toast.LENGTH_SHORT);
       // }
        startGame();
    }

    public int getWinningNumber ()
    {
        return mWinningNumber;
    }

    public boolean isWinner (int elementNumber)
    {
        return mSquares[elementNumber];
    }

    public void startGame() {
        mWinningNumber = mGenerator.nextInt (mElements);
        mSquares[mWinningNumber] = true;
    }

    public void startNewGame(){
        mSquares[mWinningNumber] = false;
        startGame ();
    }

    @NonNull
    @Override
    public GridGameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from (parent.getContext ()).inflate (
                R.layout.rv_item, parent, false);
        return new ViewHolder (itemLayoutView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mButton.setText (Integer.toString (position));
    }

    @Override
    public int getItemCount() {
        return  mSquares.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Button mButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById (R.id.button);
        }
    }
}
