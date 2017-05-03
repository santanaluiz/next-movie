package net.luizsantana.nextmovie.movies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.luizsantana.nextmovie.R;
import net.luizsantana.nextmovie.movies.contracts.MoviesActivityContract;
import net.luizsantana.nextmovie.movies.presenters.MoviesActivityPresenter;

public class MoviesActivity extends AppCompatActivity implements MoviesActivityContract.View {

    private MoviesActivityContract.Presenter presenter = new MoviesActivityPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
