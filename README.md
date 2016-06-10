# TextInputValidator
## Usage
### Add Gradle dependency
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.baudm:TextInputValidator:v0.1.0'
}
```

### In Activity/Fragment

```java
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirm_password);
        
        // Instantiate rules
        final Rule requiredField = new TextNotEmptyRule("This field is required.");
        final Rule validEmail = new EmailRule("Invalid email address.");
        final Rule passwordsMatch = new TextEqualsRule(password, "Passwords do not match.");

        // Create and configure TextInputValidator, adding rules per field as desired.
        // Note that the order of rules per field matters.
        // The error message of first rule to fail will be the one shown on the TextInputLayout.
        inputValidator = new TextInputValidator.Builder()
                .addRule(firstName, requiredField)
                .addRule(lastName, requiredField)
                .addRule(email, requiredField)
                .addRule(email, validEmail)
                .addRule(password, requiredField)
                .addRule(confirmPassword, passwordsMatch)
                .build();
    }
    
    public void onClickSendForm(View view) {
        if (inputValidator.validate()) {
            // All inputs are valid. Proceed.
        } else {
            // One or more inputs are invalid.
        }
    }
    
    public void onClickClearForm(View view) {
        // Clear fields
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        password.setText("");
        confirmPassword.setText("");
        // Clear errors
        inputValidator.clearErrors();
    }
```
