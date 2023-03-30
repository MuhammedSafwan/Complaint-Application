package com.example.complaintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private EditText edConfirmPassword;
    private Button btnCreateUser;

    private final String CREDENTIALS_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        edConfirmPassword = findViewById(R.id.ed_confirm_pwd);
        btnCreateUser = findViewById(R.id.btn_create_user);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
                String strPassword = edPassword.getText().toString();
                String strConfirmPassword = edConfirmPassword.getText().toString();
                String strUsername = edUsername.getText().toString();

                if (strPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)) {
                    SharedPreferences credentials = getSharedPreferences(CREDENTIALS_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("Username", strUsername);
                    editor.commit();

                    SignUpActivity.this.finish();
                }
            }

        });
    }
}