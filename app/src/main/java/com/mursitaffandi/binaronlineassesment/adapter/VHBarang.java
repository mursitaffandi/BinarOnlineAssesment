package com.mursitaffandi.binaronlineassesment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mursitaffandi.binaronlineassesment.R;

/**
 * Created by mursitaffandi on 2/10/18.
 */

public class VHBarang extends RecyclerView.ViewHolder {
    TextView nama_barang;
    public VHBarang(View itemView) {
        super(itemView);
        nama_barang = itemView.findViewById(R.id.item_nama);
    }
}
