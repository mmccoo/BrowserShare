package com.mmccoo.browsershare;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "com.mmccoo.mytestmay2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView textView = (TextView) findViewById(R.id.maintext);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Set<String> keys = bundle.keySet();

            String str = "";
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                str += (key + ":" + bundle.get(key));
            }
            textView.setText(str);
            Log.d(TAG, "bundle: " + str);
        }

        if (intent.getAction() == Intent.ACTION_SEND) {
            String newweburl = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.d(TAG, "got url " + newweburl);
        } else {
            Log.d(TAG, "other intent");
        }
    }
}
