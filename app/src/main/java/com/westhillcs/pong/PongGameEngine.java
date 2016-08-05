package com.westhillcs.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;

/**
 * Created by Chandan on 7/12/2016.
 */
public class PongGameEngine {
    private int screenWidth, screenHeight;
    private PongSprite ball;
    private PongSprite paddle;
    private static final int PADDLE_SPEED = 30;

    public PongGameEngine(int screenHeight, int screenWidth) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;

        // the ball is RED
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        ball = new PongSprite(100,100, 1, 2, 10, 10, 1, redPaint);

        // the paddle will default to BLACK
        paddle = new PongSprite(screenWidth/2, screenHeight/2, 0, 0, 10, 90, PADDLE_SPEED, new Paint());
    }

    public void draw(Canvas canvas) {
        // screen background is white
        canvas.drawRGB(255, 255, 255);

        // draw the ball and paddle
        ball.draw(canvas);
        paddle.draw(canvas);
    }

    public void update() {
        ball.move();
        this.detectCollisions();
    }

    private void detectCollisions() {
        // if ball goes below the paddle, create a new ball
        // due to keyboard presence, usable screen is only
        // half the screen height
        if (ball.getY() > (paddle.getY() + paddle.getHeight())) {
            // move the ball to the center of the screen near the top
            ball.move(screenWidth/2, 20);
            ball.randomTrajectory();
        }

        // detect ceiling collision
        if (ball.getY() <= 0) {
            ball.reverseTrajectoryY();
        }

        // detect side collisions
        if (ball.getX() >= screenWidth || ball.getX() <= 0)
            ball.reverseTrajectoryX();

        // detect collisions with the paddle
        if (ball.getX() >= paddle.getX() && ball.getX() <= (paddle.getX() + paddle.getWidth()) &&
                ball.getY() >= paddle.getY())
            ball.reverseTrajectoryY(); // bounce

    }

    public boolean keyPressed(int keyCode) {
        // move left or right?
        if (keyCode == KeyEvent.KEYCODE_Q)
            paddle.setX(paddle.getX() - paddle.getSpeed());
        if (keyCode == KeyEvent.KEYCODE_W)
            paddle.setX(paddle.getX() + paddle.getSpeed());
        return true;
    }
}







