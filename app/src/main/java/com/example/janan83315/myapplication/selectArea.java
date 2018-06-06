package com.example.janan83315.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class selectArea extends AppCompatActivity {
    LinearLayout areaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_area);

        printAreaList();
    }

    public void printAreaList(){
        areaList = (LinearLayout)findViewById(R.id.areaList);
        String[] areas = {"台北","桃園","新竹","台中","台南","高雄","屏東","花蓮"};
        for(int i=0;i<areas.length;i++){
            Button b = new Button(getApplicationContext());
            b.setText(areas[i]);
            b.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    goArea();
                }
            });
            areaList.addView(b);
        }
    }

    public void goArea(){
        Intent intent = new Intent(this,area.class);
        startActivity(intent);
    }
}
