package net.luizsantana.nextmovie.splash;

import net.luizsantana.nextmovie.splash.contracts.SplashContact;
import net.luizsantana.nextmovie.splash.presenters.SplashPresenter;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Created by luiz on 02/05/17.
 */

public class SplashActivityTest {

    @Test
    public void presenterCallsViewAnimation() {
        SplashContact.View viewMock = Mockito.mock(SplashContact.View.class);
        SplashContact.Presenter presenter = new SplashPresenter(viewMock);

        presenter.onStart();

        verify(viewMock, atLeastOnce()).animateBeforeLeave();
    }

}
