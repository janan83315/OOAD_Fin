package com.example.janan83315.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class loggin  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggin);
    }

    public void goRegister(View view){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }

    public void enter(View view){
        Intent intent = new Intent(this,register.class);
        TextView ac = (TextView) findViewById(R.id.account);
        TextView pw = (TextView) findViewById(R.id.password);
        //ac.getText()
        //pw.getText()
        startActivity(intent);
    }
}
