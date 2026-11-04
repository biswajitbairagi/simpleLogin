package com.example.artion.hyrnesistem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** Checks demo form input without creating an account or storing credentials. */
public class RegisterActivity extends AppCompatActivity {
    private EditText fullName;
    private EditText email;
    private EditText password;
    private EditText retype;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName = (EditText) findViewById(R.id.rFullName);
        email = (EditText) findViewById(R.id.rEmail);
        password = (EditText) findViewById(R.id.rPassword);
        retype = (EditText) findViewById(R.id.rRetypePassword);
        phone = (EditText) findViewById(R.id.rMobile);
        Button register = (Button) findViewById(R.id.rRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegister();
            }
        });
    }

    private void checkRegister() {
        fullName.setError(null);
        email.setError(null);
        password.setError(null);
        retype.setError(null);
        phone.setError(null);

        FormValidator.Error error = FormValidator.validateRegistration(
                fullName.getText().toString(), email.getText().toString(),
                password.getText().toString(), retype.getText().toString(),
                phone.getText().toString());
        switch (error) {
            case NAME_REQUIRED:
                showError(fullName, R.string.error_name_required);
                return;
            case EMAIL_REQUIRED:
                showError(email, R.string.error_email_required);
                return;
            case EMAIL_INVALID:
                showError(email, R.string.error_email_invalid);
                return;
            case PASSWORD_REQUIRED:
                showError(password, R.string.error_password_required);
                return;
            case CONFIRMATION_REQUIRED:
                showError(retype, R.string.error_confirmation_required);
                return;
            case PASSWORD_MISMATCH:
                showError(retype, R.string.error_password_mismatch);
                return;
            case PHONE_REQUIRED:
                showError(phone, R.string.error_phone_required);
                return;
            case NONE:
                password.setText("");
                retype.setText("");
                Toast.makeText(this, R.string.registration_demo_notice,
                        Toast.LENGTH_LONG).show();
                return;
            default:
                throw new IllegalStateException("Unhandled validation result");
        }
    }

    private void showError(EditText field, int message) {
        field.setError(getString(message));
        field.requestFocus();
    }
}
