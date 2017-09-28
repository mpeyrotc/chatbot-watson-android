package com.example.vmac.WatBot;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by mpeyrotc on 9/26/17.
 */

public class ServicesActivity extends AppCompatActivity {
    private Toolbar mToolBar;

    private View.OnClickListener setNumber(final String number) {
        return new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(number));
                    if (ActivityCompat.checkSelfPermission(ServicesActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        //request permission from user if the app hasn't got the required permission
                        ActivityCompat.requestPermissions(ServicesActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                                10);
                        return;
                    }else {     //have got permission
                        try{
                            startActivity(callIntent);  //call activity and make phone call
                        }
                        catch (android.content.ActivityNotFoundException ex){
                            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
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

        ImageView callButton = (ImageView) findViewById(R.id.call_first);
        callButton.setOnClickListener(setNumber("tel:911"));

        callButton = (ImageView) findViewById(R.id.call_second);
        callButton.setOnClickListener(setNumber("tel:060"));

        callButton = (ImageView) findViewById(R.id.call_third);
        callButton.setOnClickListener(setNumber("tel:068"));

        callButton = (ImageView) findViewById(R.id.call_fourth);
        callButton.setOnClickListener(setNumber("tel:065"));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
