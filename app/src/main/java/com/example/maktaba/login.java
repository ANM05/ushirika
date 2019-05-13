package com.example.maktaba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class login extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btn_login)
    Button mLogin;
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.password) EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mLogin){
            String userName = mUsername.getText().toString();
            String password = mPassword.getText().toString();
            Intent intent = new Intent(login.this, MainActivity.class);
            intent.putExtra("username", userName);
            intent.putExtra("password", password);
            startActivity(intent);
        }
    }
}
