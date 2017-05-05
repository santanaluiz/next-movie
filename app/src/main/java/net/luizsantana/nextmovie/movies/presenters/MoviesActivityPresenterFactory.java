package net.luizsantana.nextmovie.movies.presenters;

import net.luizsantana.nextmovie.common.mvp.PresenterFactory;
import net.luizsantana.nextmovie.movies.contracts.MoviesActivityContract;

/**
 * Created by luiz on 05/05/17.
 */

public class MoviesActivityPresenterFactory implements PresenterFactory<MoviesActivityContract.Presenter> {
    @Override
    public MoviesActivityContract.Presenter create() {
        return new MoviesActivityPresenter();
    }
}
