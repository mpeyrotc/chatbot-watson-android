package com.example.vmac.WatBot;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by mpeyrotc on 9/26/17.
 * <p>
 * The Services Activity {@see Android Activity} shows a list of
 * emergency numbers you should call in case of an emergency. Each
 * one of these numbers has the option of instant call from within the app.
 */
public class ServicesActivity extends AppCompatActivity {
    /**
     * Returns a new callback function that will be linked to the specified number.
     * When the callback is called, it will send that number to the device's dial system
     * and make the call.
     *
     * @param number the number to be called when pressing a specific button, image or view.
     *               The {@code String} should follow the following format: "tel:XXX...".
     * @return the {@code Listener} for the click.
     */
    private View.OnClickListener setNumber(final String number) {
        return new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(number));
                    if (ActivityCompat.checkSelfPermission(ServicesActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        //request permission from user if the app hasn't got the required permission
                        ActivityCompat.requestPermissions(ServicesActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                                10);
                        return;
                    } else {     //have got permission
                        try {
                            startActivity(callIntent);  //call activity and make phone call
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getApplicationContext(), "yourActivity is not founded",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.services);

        ImageView callButton = findViewById(R.id.call_first);
        callButton.setOnClickListener(setNumber("tel:911"));

        callButton = findViewById(R.id.call_second);
        callButton.setOnClickListener(setNumber("tel:060"));

        callButton = findViewById(R.id.call_third);
        callButton.setOnClickListener(setNumber("tel:068"));

        callButton = findViewById(R.id.call_fourth);
        callButton.setOnClickListener(setNumber("tel:065"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
