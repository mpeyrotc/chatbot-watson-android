package com.example.vmac.WatBot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by mpeyrotc on 9/26/17.
 */

public class ServicesActivity extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

//        mToolBar = (Toolbar) findViewById(R.id.nav_action);
//        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.services);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
