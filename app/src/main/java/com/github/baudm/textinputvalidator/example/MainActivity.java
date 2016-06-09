package com.github.baudm.textinputvalidator.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.baudm.textinputvalidator.EmailRule;
import com.github.baudm.textinputvalidator.Rule;
import com.github.baudm.textinputvalidator.TextEqualsRule;
import com.github.baudm.textinputvalidator.TextInputValidator;
import com.github.baudm.textinputvalidator.TextNotEmptyRule;

public class MainActivity extends AppCompatActivity {

    private TextInputValidator inputValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstName = (EditText) findViewById(R.id.first_name);
        final EditText lastName = (EditText) findViewById(R.id.last_name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText confirmPassword = (EditText) findViewById(R.id.confirm_password);

        final Rule requiredField = new TextNotEmptyRule("This field is required.");
        final Rule validEmail = new EmailRule("Invalid email address.");
        final Rule passwordsMatch = new TextEqualsRule(password, "Passwords do not match.");

        inputValidator = new TextInputValidator.Builder()
                .addRule(firstName, requiredField)
                .addRule(lastName, requiredField)
                .addRule(email, requiredField)
                .addRule(email, validEmail)
                .addRule(password, requiredField)
                .addRule(confirmPassword, passwordsMatch)
                .build();
    }

    public void onClickSend(View view) {
        if (inputValidator.validate()) {
            Toast.makeText(this, "Sending account details...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "One or more inputs invalid.", Toast.LENGTH_SHORT).show();
        }
    }
}
