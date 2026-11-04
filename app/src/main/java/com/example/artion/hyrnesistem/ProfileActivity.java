package com.example.artion.hyrnesistem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/** Shows the demo email only. No password is received or displayed. */
public class ProfileActivity extends AppCompatActivity {
    public static final String EXTRA_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        String email = intent == null ? null : intent.getStringExtra(EXTRA_EMAIL);
        TextView emailView = (TextView) findViewById(R.id.profileEmail);
        emailView.setText(email == null ? getString(R.string.profileEmailValue) : email);
    }
}
