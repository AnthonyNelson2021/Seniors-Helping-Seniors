package com.example.seniorshelpingseniors;

import static android.content.ContentValues.TAG;
import static com.example.seniorshelpingseniors.R.layout.abs_layout;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Console;
import java.io.File;
import java.io.Writer;

public class SettingsScreen extends AppCompatActivity {
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

    }
    public void onClickNotifications(View v) {
        switch (v.getId()) {
            // ...
            case R.id.enable_tots_button:
                enableNotifications();
                break;
            // ...
        }
    }

    public void onClickSupport(View v) {
        switch (v.getId()) {
            // ...
            case R.id.support_button:
                showSupport();
                break;
            // ...
        }
    }

    private void showSupport()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("US: 192-467-9090\nUK: 290-098-0022\nIN: 900-324-6789\nMX: 555-234-9124");
        dialog.setTitle("Support Contacts");
        dialog.setPositiveButton("Finished",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    public void enableNotifications()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Notifications Enabled!");
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();

    }

    public void onClickDisableNotifications(View v) {
        switch (v.getId()) {
            // ...
            case R.id.disable_tots_button2:
                disableNotifications();
                break;
            // ...
        }
    }

    private void disableNotifications()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Notifications Disabled!");
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    public void onClickLogout(View v) {
        switch (v.getId()) {
            // ...
            case R.id.logout_button:
                signOut();
                break;
            // ...
        }
    }
    // [START signOut]
    public void signOut() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        mGoogleSignInClient.signOut();
    }
    // [END signOut]

    public void onClickResetApp(View v) {
        switch (v.getId()) {
            // ...
            case R.id.reset_button:
                resetApplication();
                break;
            // ...
        }
    }

    private void resetApplication()
    {
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(SettingsScreen.this);

        // Set the message show for the Alert time
        builder.setMessage("Are you sure you want to continue?\nYOU WILL BE SIGNED OUT\nAPP DATA WILL BE CLEARED");

        // Set Alert Title
        builder.setTitle("Alert!");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                signOut(); // Signing user out
                                getCacheDir().delete(); // Clear cache
                                finish(); // Close app
                                startActivity(getIntent()); // Restart app

                                // this basically provides animation
                                overridePendingTransition(0, 0);
                                String time = System.currentTimeMillis() + "";
                                //finish();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }
}