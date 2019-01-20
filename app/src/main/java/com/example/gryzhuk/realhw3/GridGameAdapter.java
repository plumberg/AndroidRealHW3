package com.example.gryzhuk.realhw3;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GridGameAdapter  extends RecyclerView.Adapter<GridGameAdapter.ViewHolder>{
    private boolean [] mSquares;
    private static int DEFAULT_ELEMENTS = 16;


    public GridGameAdapter() throws IllegalAccessException {
       // mSquares = new boolean[16];
        this(DEFAULT_ELEMENTS);

    }
    public GridGameAdapter(int elements) throws IllegalAccessException {
        if(elements % Math.sqrt(elements)==0){
            mSquares=new boolean[elements];
        }
        else{
            throw new IllegalAccessException("Number of Squares must allow for a perfect square board");
        }

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
