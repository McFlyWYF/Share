package com.example.share;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegiesterActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText account_et;
    private EditText password_one_et;
    private EditText password_two_et;
    private TextView return_to_login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiester);
        init();
    }

    public void init() {
        account_et = (EditText) findViewById(R.id.register_account);
        password_one_et = (EditText) findViewById(R.id.regiester_password_one);
        password_two_et = (EditText) findViewById(R.id.regiester_password_two);
        return_to_login = findViewById(R.id.return_login);
        register = findViewById(R.id.btn_register);

        account_et.setOnClickListener(this);
        password_one_et.setOnClickListener(this);
        password_two_et.setOnClickListener(this);
        return_to_login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_login:
                Intent intent1 = new Intent(RegiesterActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.btn_register:
                final String account = account_et.getText().toString();
                final String password_one = password_one_et.getText().toString();
                final String password_two = password_two_et.getText().toString();

                if (account.isEmpty() || password_one.isEmpty()){
                    Toast.makeText(RegiesterActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    if (account.length() < 6 || password_one.length() < 6){
                        Toast.makeText(RegiesterActivity.this,"用户名或密码长度要超过6位",Toast.LENGTH_SHORT).show();
                    }else {
                        if (!password_one.equals(password_two)){
                            Toast.makeText(RegiesterActivity.this,"两次密码不一样",Toast.LENGTH_SHORT).show();
                        }else {

                            User p = new User();
                            p.setAccount(account);
                            p.setPassword(password_one);
                            p.save(new SaveListener<String>() {
                                @Override
                                public void done(String s, BmobException e) {
                                    if (e == null) {
                                        Toast.makeText(RegiesterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent intent2 = new Intent(RegiesterActivity.this, LoginActivity.class);
                                        startActivity(intent2);
                                        finish();
                                    } else {
                                        Toast.makeText(RegiesterActivity.this, "注册失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                            editor.putString("name", account);
                            editor.putString("password", password_one);
                            editor.apply();

                        }
                    }
                }

                break;
        }
    }
}
