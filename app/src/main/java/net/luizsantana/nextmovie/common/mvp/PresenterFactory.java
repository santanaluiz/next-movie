package net.luizsantana.nextmovie.common.mvp;

/**
 * Created by luiz on 05/05/17.
 */

public interface PresenterFactory<T extends BasePresenter> {
    T create();
}