package com.mursitaffandi.binaronlineassesment.model;


import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by mursitaffandi on 2/10/18.
 */

public class MBarang extends RealmObject{
    String nama;
    int jumlah;
    String pemasok;
    Date tanggal;

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getPemasok() {
        return pemasok;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public long getId() {
        return id;
    }

    long id;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setPemasok(String pemasok) {
        this.pemasok = pemasok;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setId(long id) {
        this.id = id;
    }
}
