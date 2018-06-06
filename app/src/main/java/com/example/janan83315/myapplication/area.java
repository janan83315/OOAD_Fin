package com.example.janan83315.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class area extends AppCompatActivity {
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);

        printTheater();
    }

    public void printTheater(){
        int number_theater = 2;
        ll = (LinearLayout)findViewById(R.id.theaterList);

        String[] theater_name = {"華納威秀", "百老匯"};
        String[] theater_address = {"我懶得打地址", "公館那個啦自己查"};

        for(int i=0; i<number_theater; i++)
        {
            LinearLayout theater = new LinearLayout(getApplicationContext());
            theater.setOrientation(LinearLayout.VERTICAL);
            if(i%2==0)
                theater.setBackgroundColor(Color.parseColor("#FFFFFF"));//white
            else
                theater.setBackgroundColor(Color.parseColor("#EEEEEE"));//gray

            TextView th_name = new TextView(getApplicationContext());
            th_name.setText(theater_name[i]);
            theater.addView(th_name);
            TextView th_address = new TextView(getApplicationContext());
            th_address.setText(theater_address[i]);
            theater.addView(th_address);

            theater.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    goTheaterPage();
                }
            });
            ll.addView(theater);
        }
    }
    public void goTheaterPage(){
        Intent intent = new Intent(this,theater.class);
        startActivity(intent);
    }
}