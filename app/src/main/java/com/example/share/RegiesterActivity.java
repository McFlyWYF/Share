package com.example.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegiesterActivity extends AppCompatActivity {


    private EditText account_et;
    private EditText password_one_et;
    private EditText password_two_et;
    private TextView return_login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiester);
    }
}
