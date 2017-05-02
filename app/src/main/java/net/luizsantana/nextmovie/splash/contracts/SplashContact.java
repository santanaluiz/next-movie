package net.luizsantana.nextmovie.splash.contracts;

import net.luizsantana.nextmovie.common.mvp.BasePresenter;
import net.luizsantana.nextmovie.common.mvp.BaseView;

/**
 * Created by luiz on 02/05/17.
 */

public interface SplashContact {

    interface View extends BaseView {
        void animateBeforeLeave();
    }

    interface Presenter extends BasePresenter {

    }

}
