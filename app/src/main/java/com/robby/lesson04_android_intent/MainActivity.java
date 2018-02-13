package com.robby.lesson04_android_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCall)
    public void actionCall() {
        Uri number = Uri.parse("tel:+62222012186");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    @OnClick(R.id.btnMap)
    public void actionMap() {
//        Uri location = Uri.parse("geo:0,0?q=Universitas+Kristen+Maranatha,+Bandung");
        // Or map point based on latitude/longitude
        Uri location = Uri.parse("geo:-6.924884,107.636569?q=-6.924884,107.636569&z=15"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @OnClick(R.id.btnWebsite)
    public void actionWeb() {
        Uri webPage = Uri.parse("http://www.it.maranatha.edu");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }

    @OnClick(R.id.btnCustomAct)
    public void actionCustomActivity() {
        Intent childIntent = new Intent(this, ChildActivity.class);
        startActivity(childIntent);
    }
}
