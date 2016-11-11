package io.reist.sandbox.core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.robolectric.shadows.ShadowLog;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by m039 on 12/1/15.
 */
public class RobolectricTestCase {

    @BeforeClass
    public static void setLogs(){
        ShadowLog.stream = System.out;
    }

    @BeforeClass
    public static void registerRxHooks() {
        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler getNewThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @AfterClass
    public static void resetRxHooks() {
        RxAndroidPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().reset();
    }
}
