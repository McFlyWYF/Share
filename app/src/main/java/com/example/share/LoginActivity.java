package com.example.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;
import rx.Subscriber;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView register;
    private Button login;
    private EditText accountText;
    private EditText passwordText;

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "88cd8e0280c01d96a6bb4f89e92d0dee");//初始化Bmob
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        register = findViewById(R.id.tv_regiester);
        login = findViewById(R.id.btn_login);
        accountText = findViewById(R.id.et_account);
        passwordText = findViewById(R.id.et_password);

        register.setOnClickListener(this);
        login.setOnClickListener(this);
        accountText.setOnClickListener(this);
        passwordText.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_regiester:
                Intent intent1 = new Intent(getApplicationContext(), RegiesterActivity.class);
                startActivityForResult(intent1, REQUEST_SIGNUP);
                break;

            case R.id.btn_login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
//                login();
                break;
        }
    }

    private void login(){
        String account = accountText.getText().toString();
        String password = passwordText.getText().toString();
        BmobUser.loginByAccount(account,password , new LogInListener<BmobUser>() {
            @Override
            public void done(BmobUser user, BmobException e) {
                if(user != null){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }
}
