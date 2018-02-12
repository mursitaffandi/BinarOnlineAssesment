package com.mursitaffandi.binaronlineassesment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mursitaffandi.binaronlineassesment.R;
import com.mursitaffandi.binaronlineassesment.model.MBarang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mursitaffandi on 2/10/18.
 */

public class AdpBarang extends RecyclerView.Adapter<VHBarang> {
ArrayList<MBarang> mBarangs;



    public void swap(ArrayList<MBarang> mBarangs){
        this.mBarangs = mBarangs;
        notifyDataSetChanged();
    }

    @Override
    public VHBarang onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, null);
        return new VHBarang(view);
    }

    @Override
    public void onBindViewHolder(VHBarang holder, int position) {
        holder.nama_barang.setText(mBarangs.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        if (mBarangs==null)return 0;
        return mBarangs.size();
    }
}
