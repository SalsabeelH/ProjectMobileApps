package birzeit.edu.projectmobileapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Timer;
import java.util.TimerTask;

import birzeit.edu.projectmobileapps.R;
import pl.droidsonroids.gif.GifImageView;

/**
 * Splash Screen
 */
public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private Animation animation1;
    private Animation animation2;
    private Animation animation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        animation1 = AnimationUtils.loadAnimation(this,R.anim.animation_alpha);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.animation_alpha2);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.animation_scale);
        gifImageView = findViewById(R.id.gifImageView);
        gifImageView.setImageResource(R.drawable.checklist);
        gifImageView.startAnimation(animation1);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                gifImageView.setImageResource(R.drawable.fitness_gif);
                gifImageView.startAnimation(animation2);
            }
        }, 3500);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                gifImageView.setImageResource(R.drawable.idea);
                gifImageView.startAnimation(animation3);
            }
        }, 6000);
        /**
         * Post delayed
         * first param object from Runnable
         * second time
         */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
                /**
                 * Destroy activity
                 */

            }
        }, 7500);
    }
}