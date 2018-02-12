package com.mursitaffandi.binaronlineassesment.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mursitaffandi.binaronlineassesment.BaseApp;
import com.mursitaffandi.binaronlineassesment.R;
import com.mursitaffandi.binaronlineassesment.adapter.AdpBarang;
import com.mursitaffandi.binaronlineassesment.model.MBarang;
import com.mursitaffandi.binaronlineassesment.presenter.LoadBarang;

import java.util.ArrayList;

public class UtamaActivity extends AppCompatActivity implements LoadBarang.OnResult {
    RecyclerView rv_barang;
    LoadBarang loadBarang;
    private AdpBarang adpBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getEmail();
            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
            Log.d("auth", name);
        } else {
BaseApp.bringToLogin(this);
            finish();
        }
        rv_barang = (RecyclerView) findViewById(R.id.rv_inputed);

        adpBarang = new AdpBarang();

        rv_barang.setHasFixedSize(true);
        rv_barang.setAdapter(adpBarang);
        rv_barang.setLayoutManager(new LinearLayoutManager(this));

        loadBarang = new LoadBarang(this);
        loadBarang.getAllBarang();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UtamaActivity.this, InputDataActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_logout) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBarang.getAllBarang();
    }

    @Override
    public void OnFinishGet(ArrayList<MBarang> mBarangList) {
        adpBarang.swap(mBarangList);
    }
}
