package net.luizsantana.nextmovie.movies.presenters;

import net.luizsantana.nextmovie.common.mvp.BaseView;
import net.luizsantana.nextmovie.movies.activity.MoviesActivity;
import net.luizsantana.nextmovie.movies.contracts.MoviesActivityContract;

/**
 * Created by luiz on 02/05/17.
 */

public class MoviesActivityPresenter implements MoviesActivityContract.Presenter {

    private MoviesActivityContract.View view;

    @Override
    public void onViewAttached(BaseView view) {
        this.view = (MoviesActivityContract.View) view;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}
