package net.luizsantana.nextmovie.common.utils;

import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by luiz on 02/05/17.
 */

public class DelayTask {

    private long waitTime;
    private Task task;

    // do not call this constructor
    private DelayTask() {}

    private DelayTask(long waitTime) {
        this.waitTime = waitTime;
    }

    public static DelayTask waitFor(long milliseconds) {
        return new DelayTask(milliseconds);
    }

    public static DelayTask waitFor(long duration, TimeUnit timeUnit) {
        return new DelayTask(timeUnit.toMillis(duration));
    }

    public DelayTask withTask(Task task) {
        this.task = task;
        return this;
    }

    public boolean execute() {
        if (task == null) return false;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, waitTime);

        return true;
    }

    public interface Task {
        void run();
    }
}
