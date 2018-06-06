package com.example.janan83315.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    int memberId;

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //banner ad
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //interstitial ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                super.onAdClosed();
                finish();
            }
        });

        memberId = -1;
        iv = (ImageView)findViewById(R.id.imageView);
        iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goRecommendMovie();
            }
        });
        //iv.setImageURI();

    }

    public void showInterstitial(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed(){
        //show ad of app exit
        showInterstitial();
    }

    public void movieList(View view){
        Intent intent = new Intent(this,movieList.class);
        startActivity(intent);
    }

    public void myFavorite(View view){
        Intent intent = new Intent(this,myFavorite.class);
        startActivity(intent);
    }

    public void memberCenter(View view){
        if(memberId==-1){
            Intent intent = new Intent(this,loggin.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this,memberCenter.class);
            intent.putExtra("memberId",memberId);
            startActivity(intent);
        }
    }

    public void theaterList(View view){
        Intent intent = new Intent(this,selectArea.class);
        startActivity(intent);
    }

    public void goRecommendMovie(){
        Intent intent = new Intent(this,moviePage.class);
        startActivity(intent);
    }

}

