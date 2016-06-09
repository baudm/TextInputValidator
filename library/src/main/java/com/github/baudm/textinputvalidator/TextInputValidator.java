package com.github.baudm.textinputvalidator;

import java.util.ArrayList;
import java.util.List;

import android.support.design.widget.TextInputLayout;
import android.support.v4.util.SimpleArrayMap;
import android.widget.EditText;

/**
 * Created by dbautista on 08/06/2016.
 */
public final class TextInputValidator {

    private final SimpleArrayMap<EditText, List<Rule>> rules;

    private TextInputValidator(Builder builder) {
        rules = builder.rules;
    }

    private static void clearError(TextInputLayout layout) {
        layout.setError(null);
        layout.setErrorEnabled(false);
    }

    private static boolean validateField(EditText field, TextInputLayout layout, Rule rule) {
        final boolean valid = rule.isValid(field);
        if (valid) {
            clearError(layout);
        } else {
            layout.setError(rule.error);
        }
        return valid;
    }

    public void clearErrors() {
        final int size = rules.size();
        for (int i = 0; i < size; i++) {
            clearError((TextInputLayout) rules.keyAt(i).getParent());
        }
    }

    public boolean validate() {
        boolean valid = true;
        final int size = rules.size();
        for (int i = 0; i < size; i++) {
            final EditText field = rules.keyAt(i);
            final TextInputLayout layout = (TextInputLayout) field.getParent();
            final List<Rule> fieldRules = rules.valueAt(i);

            for (final Rule rule : fieldRules) {
                if (!validateField(field, layout, rule)) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }


    public static final class Builder {

        SimpleArrayMap<EditText, List<Rule>> rules;

        public Builder() {
            rules = new SimpleArrayMap<>();
        }

        public Builder addRule(EditText field, Rule rule) {
            List<Rule> fieldRules = rules.get(field);
            if (fieldRules == null) {
                fieldRules = new ArrayList<>();
                rules.put(field, fieldRules);
            }
            fieldRules.add(rule);
            return this;
        }

        public TextInputValidator build() {
            return new TextInputValidator(this);
        }
    }
}
