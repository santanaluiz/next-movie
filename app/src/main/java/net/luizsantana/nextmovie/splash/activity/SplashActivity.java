package net.luizsantana.nextmovie.splash.activity;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.luizsantana.nextmovie.R;
import net.luizsantana.nextmovie.common.mvp.BasePresenter;
import net.luizsantana.nextmovie.common.mvp.PresenterLoader;
import net.luizsantana.nextmovie.movies.activity.MoviesActivity;
import net.luizsantana.nextmovie.splash.contracts.SplashContact;
import net.luizsantana.nextmovie.splash.presenters.SplashPresenter;
import net.luizsantana.nextmovie.splash.presenters.SplashPresenterFactory;

public class SplashActivity extends AppCompatActivity implements SplashContact.View, LoaderManager.LoaderCallbacks<SplashContact.Presenter> {

    public static final String TAG = SplashActivity.class.getName();
    private static final int PRESENTER_LOADER_ID = 101;
    private SplashContact.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportLoaderManager()
                .initLoader(PRESENTER_LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewAttached(this);
    }

    @Override
    protected void onStop() {
        presenter.onViewDetached();
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
        startActivity(new Intent(this, MoviesActivity.class));
        finish();
    }

    @Override
    public Loader<SplashContact.Presenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(this, new SplashPresenterFactory());
    }

    @Override
    public void onLoadFinished(Loader<SplashContact.Presenter> loader, SplashContact.Presenter data) {
        this.presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<SplashContact.Presenter> loader) {
        this.presenter = null;
    }
}
