package net.luizsantana.nextmovie.splash.presenters;

import android.util.Log;

import net.luizsantana.nextmovie.common.mvp.BaseView;
import net.luizsantana.nextmovie.common.utils.DelayTask;
import net.luizsantana.nextmovie.splash.contracts.SplashContact;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by luiz on 02/05/17.
 */

public class SplashPresenter implements SplashContact.Presenter {

    public static final String TAG = SplashPresenter.class.getName();
    private SplashContact.View view;
    private boolean timerStarted;

    @Override
    public void onViewAttached(BaseView view) {
        this.view = (SplashContact.View) view;
        if (timerStarted) return;

        this.view.animateBeforeLeave();
        startTimer();
    }

    private void startTimer() {
        timerStarted = DelayTask.waitFor(SPLASH_MINIMUM_WAIT_TIME)
                .withTask(new DelayTask.Task() {
                    @Override
                    public void run() {
                        view.navigateToMoviesList();
                    }
                })
                .execute();
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}
