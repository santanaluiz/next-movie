package net.luizsantana.nextmovie.splash;

import net.luizsantana.nextmovie.splash.contracts.SplashContact;
import net.luizsantana.nextmovie.splash.presenters.SplashPresenter;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static net.luizsantana.nextmovie.splash.contracts.SplashContact.Presenter.SPLASH_MINIMUM_WAIT_TIME;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Created by luiz on 02/05/17.
 */

public class SplashActivityTest {

    private CountDownLatch lock = new CountDownLatch(1);

    @Test
    public void presenterCallsViewAnimation() {
        SplashContact.View viewMock = Mockito.mock(SplashContact.View.class);
        SplashContact.Presenter presenter = new SplashPresenter(viewMock);

        presenter.onStart();

        verify(viewMock, atLeastOnce()).animateBeforeLeave();
    }

    @Test
    public void presenterCallsNavigateToMoviesList() throws InterruptedException {
        SplashContact.View viewMock = Mockito.mock(SplashContact.View.class);
        SplashContact.Presenter presenter = new SplashPresenter(viewMock);

        presenter.onStart();

        lock.await(SPLASH_MINIMUM_WAIT_TIME, TimeUnit.SECONDS);

        verify(viewMock, atLeastOnce()).navigateToMoviesList();
    }

}
