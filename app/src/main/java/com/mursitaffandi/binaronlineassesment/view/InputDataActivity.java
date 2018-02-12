package com.mursitaffandi.binaronlineassesment.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mursitaffandi.binaronlineassesment.BaseApp;
import com.mursitaffandi.binaronlineassesment.R;
import com.mursitaffandi.binaronlineassesment.presenter.InsertBarang;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputDataActivity extends AppCompatActivity implements InsertBarang.OnResult, View.OnClickListener {
    @BindView(R.id.tv_date)
    TextView input_date;
    @BindView(R.id.edt_jumlah)
    EditText input_jumlah;
    @BindView(R.id.edt_nama)
    EditText input_nama;
    @BindView(R.id.edt_pemasok)
    EditText input_pemasok;
    @BindView(R.id.btn_add)
    Button act_add;
    InsertBarang insertBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpot_data);
        ButterKnife.bind(this);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            BaseApp.bringToLogin(this);
        }
        input_nama=(EditText) findViewById(R.id.edt_nama);
        input_jumlah=(EditText) findViewById(R.id.edt_jumlah);
        input_pemasok=(EditText) findViewById(R.id.edt_pemasok);

        act_add=(Button)findViewById(R.id.btn_add);
        act_add.setOnClickListener(this);
    }

    @Override
    public void ResultInsert(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View view) {
        String name = input_nama.getText().toString().trim();
        String pemasok = input_pemasok.getText().toString().trim();
        String jumlah = input_jumlah.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pemasok) && !TextUtils.isEmpty(jumlah)){
            insertBarang = new InsertBarang(this,name,Integer.parseInt(jumlah),pemasok,new Date());
        } else {
            Toast.makeText(this, "masukan data yg benar!", Toast.LENGTH_SHORT).show();
        }
    }
}
