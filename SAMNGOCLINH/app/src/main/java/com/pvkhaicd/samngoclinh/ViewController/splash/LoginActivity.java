package com.pvkhaicd.samngoclinh.ViewController.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mInputLayoutPhone;
    private TextInputLayout mInputLayoutName;
    private Button mButtonLogin;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mInputLayoutName = findViewById(R.id.text_input_name);
        mInputLayoutPhone = findViewById(R.id.text_input_phone);
        mButtonLogin = findViewById(R.id.button_login);
        mSessionManager = new SessionManager(this);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkForm()) {
                    String name = mInputLayoutName.getEditText().getText().toString();
                    String phone = mInputLayoutPhone.getEditText().getText().toString();
                    mSessionManager.createLoginSession(phone, name);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean checkForm() {
        if (mInputLayoutPhone.getEditText().getText() == null || mInputLayoutPhone.getEditText().getText().toString().length() < 9) {
            mInputLayoutPhone.setError("Your phone number is invalid form");
            return false;
        }
        if (mInputLayoutName.getEditText().getText() == null || mInputLayoutName.getEditText().getText().toString().length() == 0) {
            mInputLayoutName.setError("Your phone number is invalid form");
            return false;
        }
        return true;
    }
}
