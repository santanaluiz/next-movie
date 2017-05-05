package net.luizsantana.nextmovie.splash.presenters;

import net.luizsantana.nextmovie.common.mvp.PresenterFactory;
import net.luizsantana.nextmovie.splash.contracts.SplashContact;

/**
 * Created by luiz on 05/05/17.
 */

public class SplashPresenterFactory implements PresenterFactory<SplashContact.Presenter> {
    @Override
    public SplashContact.Presenter create() {
        return new SplashPresenter();
    }
}
