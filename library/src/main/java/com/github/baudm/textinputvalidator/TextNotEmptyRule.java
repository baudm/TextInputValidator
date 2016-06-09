package com.github.baudm.textinputvalidator;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class TextNotEmptyRule extends Rule {

    public TextNotEmptyRule(String error) {
        super(error);
    }

    @Override
    public boolean isValid(String inputText) {
        return inputText.length() != 0;
    }
}
