package net.luizsantana.nextmovie.movies.presenters;

import net.luizsantana.nextmovie.movies.activity.MoviesActivity;
import net.luizsantana.nextmovie.movies.contracts.MoviesActivityContract;

/**
 * Created by luiz on 02/05/17.
 */

public class MoviesActivityPresenter implements MoviesActivityContract.Presenter {

    private final MoviesActivityContract.View view;

    public MoviesActivityPresenter(MoviesActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
