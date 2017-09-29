package com.example.vmac.WatBot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by VMac on 06/01/17.
 * <p>
 * The SplashActivity is a loading screen shown to the
 * user when he starts the app. Its purpose is to show
 * the user that the app is working and to show him
 * the logo.
 *
 * @author VMac
 * @version 1.0
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
