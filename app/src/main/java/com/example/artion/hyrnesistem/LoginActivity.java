package com.example.artion.hyrnesistem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** A local form demonstration; this activity does not authenticate users. */
public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.hyr);
        Button register = (Button) findViewById(R.id.regjistrohu);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void checkLogin() {
        email.setError(null);
        password.setError(null);
        String enteredEmail = email.getText().toString();
        FormValidator.Error error = FormValidator.validateLogin(
                enteredEmail, password.getText().toString());
        if (error == FormValidator.Error.EMAIL_REQUIRED) {
            email.setError(getString(R.string.error_email_required));
            email.requestFocus();
            return;
        }
        if (error == FormValidator.Error.EMAIL_INVALID) {
            email.setError(getString(R.string.error_email_invalid));
            email.requestFocus();
            return;
        }
        if (error == FormValidator.Error.PASSWORD_REQUIRED) {
            password.setError(getString(R.string.error_password_required));
            password.requestFocus();
            return;
        }

        // Never display the password or include it in an Intent or saved state.
        password.setText("");
        Toast.makeText(this, R.string.login_demo_notice, Toast.LENGTH_LONG).show();
        Intent preview = new Intent(this, ProfileActivity.class);
        preview.putExtra(ProfileActivity.EXTRA_EMAIL, enteredEmail.trim());
        startActivity(preview);
    }
}
