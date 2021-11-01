package com.example.seniorshelpingseniors;

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
import android.view.View;
import android.widget.Toast;

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


}