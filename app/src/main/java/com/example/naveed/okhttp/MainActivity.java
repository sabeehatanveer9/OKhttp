package com.example.naveed.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    Button btn;
    EditText editText;
    private OkHttpClient okHttpClient;
    private Request request;
    private String url="http://color.mocklab.io/thing/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.et);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize http client
                okHttpClient= new OkHttpClient();
                //initialize request
                request= new Request.Builder().url(url).build();
                //execute request
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        Log.i(TAG, e.getMessage());
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        Log.i(TAG, response.body().string());
                    }
                });
            }
        });

    }
}
