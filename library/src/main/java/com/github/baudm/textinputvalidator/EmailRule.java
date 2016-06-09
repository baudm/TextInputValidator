package com.github.baudm.textinputvalidator;

import android.util.Patterns;
import android.widget.EditText;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class EmailRule extends Rule {

    public EmailRule(String error) {
        super(error);
    }

    @Override
    public boolean isValid(EditText field) {
        return Patterns.EMAIL_ADDRESS.matcher(field.getText()).matches();
    }
}
