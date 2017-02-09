package com.android.camera.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {



//    public  native String avcodecinfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = (Button) this.findViewById(R.id.button_start);
        final EditText urlEdittext_input= (EditText) this.findViewById(R.id.input_url);
        final EditText urlEdittext_output= (EditText) this.findViewById(R.id.output_url);

        startButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0){

                String folderurl= Environment.getExternalStorageDirectory().getPath();

                String urltext_input=urlEdittext_input.getText().toString();
                String inputurl=folderurl+"/"+urltext_input;

                String urltext_output=urlEdittext_output.getText().toString();
                String outputurl=folderurl+"/"+urltext_output;

                Log.i("inputurl",inputurl);
                Log.i("outputurl",outputurl);

                decode(inputurl,outputurl);

            }
        });
    }



    //JNI
    public native int decode(String inputurl, String outputurl);

//    static{
//        System.loadLibrary("avutil");
//        System.loadLibrary("swresample-1");
//        System.loadLibrary("avcodec-56");
//        System.loadLibrary("avformat-56");
//        System.loadLibrary("swscale-3");
//        System.loadLibrary("postproc-53");
//        System.loadLibrary("avfilter-5");
//        System.loadLibrary("avdevice-56");
//        System.loadLibrary("sffhelloworld");
//    }
    static {
        System.loadLibrary("sffhelloworld");
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
    }
}
