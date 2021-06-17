package com.example.dvij;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    int x=200,y=300;
    ImageView  image;
    ViewGroup.MarginLayoutParams marginParams;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = new ImageView(this);
        image.setImageResource(R.drawable.m_conus);
        marginParams=new ViewGroup.MarginLayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout = (RelativeLayout) findViewById(R.id.relaLayout);
        marginParams.setMargins(x, y, 0, 0);
        image.setLayoutParams(marginParams);
        layout.addView(image);
        CountDownTimer cdt=new CountDownTimer(30000, 1) {
            public void onTick(long millisUntilFinished) {
                y+=10;
                marginParams.setMargins(x, y, 0, 0);
                image.setLayoutParams(marginParams);
                layout.removeView(image);
                layout.addView(image);
            }
            public void onFinish() { }
        };
        cdt.start();
    }

}