package com.westhillcs.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Chandan on 7/13/2016.
 */
public class PongView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private PongThread pongThread;


    public PongView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        this.setFocusable(true);
        this.pongThread = new PongThread(surfaceHolder);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {
        return pongThread.getPongGame().keyPressed(keyCode);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        pongThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}






































