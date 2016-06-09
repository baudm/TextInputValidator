package com.github.baudm.textinputvalidator;

import android.widget.EditText;

/**
 * Created by dbautista on 08/06/2016.
 */
public abstract class Rule {

    final String error;

    public Rule(String error) {
        this.error = error;
    }

    public abstract boolean isValid(EditText field);
}
