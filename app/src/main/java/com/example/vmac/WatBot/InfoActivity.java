package com.example.vmac.WatBot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mpeyrotc on 9/26/17.
 * <p>
 * The information activity {@see Android Activity} just contains contact
 * information for the interested party.
 *
 * @author mpeyrotc
 * @version 1.0
 */
public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.info);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
