package com.mursitaffandi.binaronlineassesment.presenter;

import com.mursitaffandi.binaronlineassesment.helper.HBarangDB;
import com.mursitaffandi.binaronlineassesment.model.MBarang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mursitaffandi on 2/10/18.
 */

public class LoadBarang {
    public interface OnResult{
        void OnFinishGet(ArrayList<MBarang> mBarangList);
    }

    OnResult onResult;

    public LoadBarang(OnResult onResult) {
        this.onResult = onResult;
    }

    public void getAllBarang(){
        HBarangDB hBarangDB = new HBarangDB();
        onResult.OnFinishGet(hBarangDB.get());
    }
}
