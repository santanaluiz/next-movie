package net.luizsantana.nextmovie.splash.presenters;

import android.util.Log;

import net.luizsantana.nextmovie.common.mvp.BaseView;
import net.luizsantana.nextmovie.common.utils.DelayTask;
import net.luizsantana.nextmovie.splash.contracts.SplashContact;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by luiz on 02/05/17.
 */

public class SplashPresenter implements SplashContact.Presenter {

    public static final String TAG = SplashPresenter.class.getName();
    private SplashContact.View view;

    public SplashPresenter(SplashContact.View view) {
        this.view = view;
    }

    @Override
    public void onStart() {
        view.animateBeforeLeave();
        startTimer();
    }

    private void startTimer() {
        DelayTask.waitFor(1, SECONDS)
                .withTask(new DelayTask.Task() {
                    @Override
                    public void run() {
                        routeToMoviesList();
                    }
                })
                .execute();
    }

    private void routeToMoviesList() {
        Log.d(TAG, "Routing to movies list");
    }

    @Override
    public void onStop() {

    }
}
