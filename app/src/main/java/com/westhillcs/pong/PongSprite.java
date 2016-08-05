package com.westhillcs.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Chandan on 7/12/2016.
 */
public class PongSprite {

    private static final Random RG = new Random();
    private static final int MAX_RANDOM = 5;

    private int x, y;
    private int trajectory_x, trajectory_y;
    private int height, width;
    private int speed;
    private Paint paint;

    public PongSprite(int x, int y, int trajectory_x, int trajectory_y, int height, int width, int speed, Paint paint) {
        this.x = x;
        this.y = y;
        this.trajectory_x = trajectory_x;
        this.trajectory_y = trajectory_y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.paint = paint;
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(new Rect(this.x, this.y, this.x + this.width, this.y + this.height), this.paint);
    }

    public void move() {
        this.x += (this.trajectory_x * this.speed);
        this.y += (this.trajectory_y * this.speed);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reverseTrajectoryX() {
        this.trajectory_x *= -1;
    }

    public void reverseTrajectoryY() {
        this.trajectory_y *= -1;
    }

    public void randomTrajectory() {
        this.trajectory_x = RG.nextInt(MAX_RANDOM);
        this.trajectory_y = RG.nextInt(MAX_RANDOM);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTrajectory_x() {
        return trajectory_x;
    }

    public void setTrajectory_x(int trajectory_x) {
        this.trajectory_x = trajectory_x;
    }

    public int getTrajectory_y() {
        return trajectory_y;
    }

    public void setTrajectory_y(int trajectory_y) {
        this.trajectory_y = trajectory_y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
