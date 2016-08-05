package com.westhillcs.pong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PongActivity extends AppCompatActivity {
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = new PongView(this);
        this.setContentView(view);
    }
}
