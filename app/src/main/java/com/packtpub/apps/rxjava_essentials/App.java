package com.packtpub.apps.rxjava_essentials;

import android.app.Application;
import android.content.Context;
import com.alterego.advancedandroidlogger.implementations.DetailedAndroidLogger;
import com.alterego.advancedandroidlogger.interfaces.IAndroidLogger;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class App extends Application {

  public static DetailedAndroidLogger L;

  public static Context instance;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;

    L = new DetailedAndroidLogger("RXJAVA", IAndroidLogger.LoggingLevel.DEBUG);

    DisplayImageOptions defaultOptions =
        new DisplayImageOptions.Builder().showImageOnFail(R.drawable.ic_launcher)
            .showImageOnLoading(R.drawable.ic_launcher)
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();
    ImageLoaderConfiguration config =
        new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(
            defaultOptions).build();
    ImageLoader.getInstance().init(config);
  }
}
