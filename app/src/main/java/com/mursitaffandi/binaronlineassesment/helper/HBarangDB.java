package com.mursitaffandi.binaronlineassesment.helper;

import com.mursitaffandi.binaronlineassesment.model.MBarang;

import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by mursitaffandi on 2/11/18.
 */

public class HBarangDB {
    private Realm realm;

    public HBarangDB(){
        realm = Realm.getDefaultInstance();
    }

    public void insert(String nama,
                       int jumlah,
                       String pemasok,
                       Date tanggal,
                       long id){
        realm.beginTransaction();
        MBarang person = realm.createObject(MBarang.class);
        person.setId(id);
        person.setNama(nama);
        person.setPemasok(pemasok);
        person.setJumlah(jumlah);
        person.setTanggal(tanggal);
        realm.commitTransaction();
    }

    public ArrayList<MBarang> get(){
        RealmResults<MBarang> realmQuery = realm.where(MBarang.class).findAll();
        ArrayList<MBarang> list = null;
        if (realmQuery != null){
            if(realmQuery.size() > 0){
                list = new ArrayList<>();
                for (MBarang person : realmQuery){
                    list.add(person);
                }
            }
        }

        return list;
    }

}
