package com.github.baudm.textinputvalidator;

/**
 * Created by dbautista on 08/06/2016.
 */
public abstract class Rule {

    final String error;

    public Rule(String error) {
        this.error = error;
    }

    public abstract boolean isValid(String inputText);
}
