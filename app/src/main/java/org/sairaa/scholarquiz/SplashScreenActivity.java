package org.sairaa.scholarquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    // Declaring global objects.
    private SharedPreferenceConfig sharedPreferenceConfig;

    // Constant for Splash time out.
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Here is the code for splash screen which will be showing till 4 second time out.
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                // check whether the user already logged in or not
                sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

                // This method will be executed once the timer is over
                // Start your app main activity

                if (sharedPreferenceConfig.readLoginStatus()){
                    startActivity(new Intent(SplashScreenActivity.this
                            ,LessonActivity.class));
                } else { // Now that user is not logged in take them to login page.
                    Intent loginIntent = new Intent(SplashScreenActivity.this
                            , LoginActivity.class);
                    startActivity(loginIntent);
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
