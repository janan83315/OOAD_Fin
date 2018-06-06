package com.example.janan83315.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class theater extends AppCompatActivity {
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater);

        printTheaterMovies();

    }

    public void printTheaterMovies(){
        for(int i=0;i<15;i++){
            ll = (LinearLayout)findViewById(R.id.theaterMovies);
            LinearLayout movie = new LinearLayout(getApplicationContext());
            if(i%2==0)
                movie.setBackgroundColor(Color.parseColor("#FFFFFF"));//white
            else
                movie.setBackgroundColor(Color.parseColor("#EEEEEE"));//gray

            ImageView poster = new ImageView(getApplicationContext());
            poster.setImageResource(R.drawable.poster);
            poster.setLayoutParams(new LinearLayout.LayoutParams(500, 250));

            LinearLayout info = new LinearLayout(getApplicationContext());
            info.setOrientation(LinearLayout.VERTICAL);
            TextView movieName = new TextView(getApplicationContext());
            movieName.setText("movie name");
            info.addView(movieName);

            for(int j=0;j<5;j++){
                TextView time = new TextView(getApplicationContext());
                time.setText("10:00");
                info.addView(time);
            }
            movie.addView(poster);
            movie.addView(info);

            movie.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    goMoviePage();
                }
            });
            ll.addView(movie);
        }
    }

    public void goMoviePage(){
        Intent intent = new Intent(this,moviePage.class);
        startActivity(intent);
    }
}
