package com.example.tutorial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int c = 5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.passwrd);
        Info = (TextView) findViewById(R.id.info);
        Login = (Button) findViewById(R.id.button);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String uname, String upassword)
    {
         if ((uname == "Admin") && (upassword == "1234")) {
           Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            c--;
            Info.setText("No of attempts remaining: " + String.valueOf(c));
            if (c == 0) {
                Login.setEnabled(false);
            }
        }
    }
}