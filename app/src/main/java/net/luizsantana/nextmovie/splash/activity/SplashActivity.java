package net.luizsantana.nextmovie.splash.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.luizsantana.nextmovie.R;
import net.luizsantana.nextmovie.splash.contracts.SplashContact;
import net.luizsantana.nextmovie.splash.presenters.SplashPresenter;

public class SplashActivity extends AppCompatActivity implements SplashContact.View {

    public static final String TAG = SplashActivity.class.getName();
    private SplashContact.Presenter presenter = new SplashPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void animateBeforeLeave() {
        // TODO animateLogo
        Log.d(TAG, "Animating view...");
    }

    @Override
    public void navigateToMoviesList() {
        Log.d(TAG, "Navigating to movies list");
    }
}
