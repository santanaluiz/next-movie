package net.luizsantana.nextmovie.common.mvp;

/**
 * Created by luiz on 02/05/17.
 */

public interface BasePresenter {
    void onViewAttached(BaseView view);
    void onViewDetached();
    void onDestroyed();
}
