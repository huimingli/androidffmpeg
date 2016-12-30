package com.android.camera.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class MainActivity extends Activity {

    static {
        System.loadLibrary("sffhelloworld");
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
    }

    public  native String avcodecinfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.txt)).setText(avcodecinfo());
    }
}
