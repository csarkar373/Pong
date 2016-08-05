package com.westhillcs.pong;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Chandan on 7/13/2016.
 */
public class PongThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private PongGameEngine pongGame;
    private Canvas canvas;

    public PongThread(SurfaceHolder surfaceHolder) {
        super();
        this.surfaceHolder = surfaceHolder;
    }

    public PongGameEngine getPongGame() {
        return pongGame;
    }

    @Override
    public void run() {
        Log.v("Starting Pong Game", " ");
        this.canvas = this.surfaceHolder.lockCanvas();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        this.surfaceHolder.unlockCanvasAndPost(canvas);
        pongGame = new PongGameEngine(height, width);
        while (true) {
            this.canvas = this.surfaceHolder.lockCanvas();
            this.pongGame.update();
            this.pongGame.draw(canvas);
            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }


}
















































    /*

    private SurfaceHolder surfaceHolder;
    private PongGameEngine pongGame;
    private Canvas canvas;

    public PongThread(SurfaceHolder surfaceHolder) {
        super();
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        Log.v("STARTING GAME", " ");
        this.canvas = this.surfaceHolder.lockCanvas();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        this.surfaceHolder.unlockCanvasAndPost(canvas);
        pongGame = new PongGameEngine(height, width);
        while(true) {
            this.canvas = surfaceHolder.lockCanvas();
            this.pongGame.update();
            this.pongGame.draw(canvas);
            this.surfaceHolder.unlockCanvasAndPost(canvas);
           // Log.v("GAME CYCLE", " ");
        }
    }

    public PongGameEngine getPongGame() {
        return pongGame;
    }
    }
    */

