package net.luizsantana.nextmovie.movies.activity;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.luizsantana.nextmovie.R;
import net.luizsantana.nextmovie.common.mvp.PresenterLoader;
import net.luizsantana.nextmovie.movies.contracts.MoviesActivityContract;
import net.luizsantana.nextmovie.movies.presenters.MoviesActivityPresenter;
import net.luizsantana.nextmovie.movies.presenters.MoviesActivityPresenterFactory;

public class MoviesActivity extends AppCompatActivity
        implements MoviesActivityContract.View, LoaderManager.LoaderCallbacks<MoviesActivityContract.Presenter> {

    private static final int PRESENTER_LOADER_ID = 101;
    private MoviesActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

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
    public Loader<MoviesActivityContract.Presenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(this, new MoviesActivityPresenterFactory());
    }

    @Override
    public void onLoadFinished(Loader<MoviesActivityContract.Presenter> loader, MoviesActivityContract.Presenter data) {
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<MoviesActivityContract.Presenter> loader) {
        presenter = null;
    }
}
