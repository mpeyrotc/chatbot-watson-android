package com.example.vmac.WatBot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mpeyrotc on 9/26/17.
 * <p>
 * The Credits activity {@see Android Activity} holds three pieces of data (all in text format).
 * <p>
 * <p><ol>
 * <li>Developer Credits: this section holds the names and university ids of the developers
 * of the <i>Primeros Auxilios</i> app.</li>
 * <li>Additional Credits: since the skeleton of the app was not developed by us, the
 * appropriate credits to the initial creator are expressed.</li>
 * <li>Warning: this app was made for a class project and not commercial use. As such, we
 * take no responsibility on any mishap that could happen with its usage.</li>
 * </ol></p>
 *
 * @author mpeyrotc
 * @version 1.0
 */
public class CreditsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.credits);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
