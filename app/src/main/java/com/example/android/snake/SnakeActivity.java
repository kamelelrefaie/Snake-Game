package com.example.android.snake;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;


public class SnakeActivity extends AppCompatActivity {

    // Declare an instance of SnakeEngine
    SnakeEngine snakeEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make screen in landscape mood
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        snakeEngine = new SnakeEngine(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(snakeEngine);

    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }


}
