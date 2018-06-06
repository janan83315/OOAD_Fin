package com.example.janan83315.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class myFavorite extends AppCompatActivity {
    LinearLayout mfl;//my favorite list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_favorite);

        mfl = (LinearLayout)findViewById(R.id.myFavoriteList);
        for(int i=0;i<5;i++){
            LinearLayout movie = new LinearLayout(getApplicationContext());
            ImageView poster = new ImageView(getApplicationContext());
            movie.addView(poster);

            //LinearLayout layout = /* ... */;
            //layout.setOrientation(LinearLayout.VERTICAL);

            movie.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    goBack();
                }
            });
            mfl.addView(movie);
        }
    }

    public void goBack(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
