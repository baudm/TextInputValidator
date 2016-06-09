package com.github.baudm.textinputvalidator;

import android.widget.EditText;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class TextNotEmptyRule extends Rule {

    public TextNotEmptyRule(String error) {
        super(error);
    }

    @Override
    public boolean isValid(EditText field) {
        return field.length() != 0;
    }
}
