package com.github.baudm.textinputvalidator;

import android.widget.EditText;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class TextEqualsRule extends Rule {

    private final EditText reference;

    public TextEqualsRule(EditText reference, String error) {
        super(error);
        this.reference = reference;
    }

    @Override
    public boolean isValid(EditText field) {
        return field.getText().toString().equals(reference.getText().toString());
    }
}
