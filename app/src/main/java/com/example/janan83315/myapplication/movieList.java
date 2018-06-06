package com.example.janan83315.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public  class movieList extends AppCompatActivity {
    LinearLayout ll, mt;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        loadMovieType();
        printMovieList();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 儲存目前執行環境
        context = this;

        // (1)宣告一個處理資料取回後, 處理回傳JSON格式資料的物件.
        MyAsyncTask myAsyncTask = new MyAsyncTask(context, new MyAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try{
                    if (result == null) {
                        Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //這裡是各自要寫的資料處理
                    JSONArray jsonArray = new JSONArray(result);
                    JSONObject jsonObject;
                    for(int i=0;i<jsonArray.length();i++){
                        /*
                        System.out.println(i);
                        System.out.println(jsonArray.getJSONObject(0));
                        String mid = jsonArray.getJSONObject(0).getString("mid");
                        System.out.println(mid);*/

                        jsonObject = jsonArray.getJSONObject(i) ;
                        String title=jsonObject.getString("movietitle");
                        System.out.println(title);
                        System.out.println("***************************");
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "連線失敗!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // (2)向主機網址發出取回資料請求
        myAsyncTask.execute("http://gigayaya.no-ip.org/api/movie_get_all.php");
    }

    public void loadMovieType() {
        mt = (LinearLayout) findViewById(R.id.movieType);
        String[] typeNames = {"動作", "愛情", "喜劇", "恐怖", "科幻", "動畫", "劇情"};
        for (int i = 0; i < typeNames.length; i++) {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(typeNames[i]);
            mt.addView(cb);
        }
    }

    public void printMovieList() {
        ll = (LinearLayout) findViewById(R.id.movieList);
        for (int i = 0; i < 5; i++) {
            LinearLayout movie = new LinearLayout(getApplicationContext());
            if (i % 2 == 0)
                movie.setBackgroundColor(Color.parseColor("#FFFFFF"));//white
            else
                movie.setBackgroundColor(Color.parseColor("#EEEEEE"));//gray

            ImageView poster = new ImageView(getApplicationContext());
            poster.setImageResource(R.drawable.poster);
            poster.setLayoutParams(new LinearLayout.LayoutParams(500, 250));

            LinearLayout info = new LinearLayout(getApplicationContext());
            info.setOrientation(LinearLayout.VERTICAL);
            String[] infoNames = {"名稱", "類別", "級別", "片長"};
            for (int j = 0; j < infoNames.length; j++) {
                TextView tv = new TextView(getApplicationContext());
                tv.setText(infoNames[j] + "：");
                info.addView(tv);
            }

            movie.addView(poster);
            movie.addView(info);
            movie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goMoviePage();
                }
            });
            ll.addView(movie);
        }
    }

    public void goMoviePage() {
        Intent intent = new Intent(this, moviePage.class);
        startActivity(intent);
    }

    public void enter(View view) {
        //
    }
}


