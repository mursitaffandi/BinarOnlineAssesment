package com.mursitaffandi.binaronlineassesment.presenter;

import com.mursitaffandi.binaronlineassesment.helper.HBarangDB;
import com.mursitaffandi.binaronlineassesment.model.MBarang;

import java.util.Date;

/**
 * Created by mursitaffandi on 2/10/18.
 */

public class InsertBarang {
    public interface OnResult{
        void ResultInsert(String status);
    }

    OnResult onResult;
    String nama;
    int jumlah;
    String pemasok;
    Date tanggal;
    HBarangDB personHelper;

    public InsertBarang(OnResult onResult, String nama, int jumlah, String pemasok, Date tanggal) {
        this.onResult = onResult;
        this.nama = nama;
        this.jumlah = jumlah;
        this.pemasok = pemasok;
        this.tanggal = tanggal;
        this.personHelper =  new HBarangDB();
        insertBarang();
    }

    public void insertBarang(){
        String status = "Satu item berhasil ditambahkan";
        this.personHelper.insert(this.nama,
        this.jumlah ,
        this.pemasok ,
        this.tanggal ,System.currentTimeMillis());
        onResult.ResultInsert(status);
    }
}
