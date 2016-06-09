package com.github.baudm.textinputvalidator;

import android.util.Patterns;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class EmailRule extends Rule {

    public EmailRule(String error) {
        super(error);
    }

    @Override
    public boolean isValid(String inputText) {
        return Patterns.EMAIL_ADDRESS.matcher(inputText).matches();
    }
}
