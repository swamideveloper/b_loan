
package com.gopal.fast.vid.ads;

import static com.gopal.fast.vid.ads.InterEvent.isInterShowing;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.gopal.fast.vid.PermissionActivity;
import com.gopal.fast.vid.ads.client.APIClient;
import com.gopal.fast.vid.ads.client.APIInterface;
import com.gopal.fast.vid.ads.client.ResModel.MainResModel;
import com.gopal.fast.vid.ui.StartActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;

public abstract class AdsController extends Application implements ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    public void startMainActivity(Context context) {
        if (isNetworkConnected(currentActivity)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(AdsController.this, StartActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                } else {
                    context.startActivity(new Intent(AdsController.this, PermissionActivity.class));
                }
            }
        }

    }

    private AppOpenAdManager appOpenAdManager;
    public Activity currentActivity;
    APIInterface apiInterface;
    public static int interCount, nativeCount, backInterCount;
    public static int interLoad = 1, nativeLoad = 1, backLoad = 1;
    public static String interKey = "", nativeKey = "", adsTag = "", appOpenKey = "";

    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(this);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        appOpenAdManager = new AppOpenAdManager();

        getData();

    }

    private void getData() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<MainResModel> call = apiInterface.doGetListData();
        call.enqueue(new Callback<MainResModel>() {
            @Override
            public void onResponse(Call<MainResModel> call, retrofit2.Response<MainResModel> response) {
                if (response.body().getSuccess()) {
                    interCount = Integer.parseInt(response.body().getData().getExtraFields().getInterFrequency());
                    nativeCount = Integer.parseInt(response.body().getData().getExtraFields().getNativeFrequency());
                    backInterCount = Integer.parseInt(response.body().getData().getExtraFields().getBackInterFrequency());
                    interKey = response.body().getData().getAdsUnits().get(0).getInterFrequency();
                    nativeKey = response.body().getData().getAdsUnits().get(0).getNativeFrequency();
                    appOpenKey = response.body().getData().getAdsUnits().get(0).getAppOpen();
                    adsTag = response.body().getData().getExtraFields().getAds();
                    NativeAds.load(currentActivity);
                    InterEvent.load(currentActivity, new AdLoad() {
                        @Override
                        public void onAdsLoaded() {
                            if (adsTag.equalsIgnoreCase("on")) {
//                                appOpenAdManager.showAdIfAvailable(currentActivity);
                                appOpenAdManager.loadAd(currentActivity);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createTimer();
                                    }
                                }, 5000);
                            } else {
                                startMainActivity(currentActivity);
                            }

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<MainResModel> call, Throwable t) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isNetworkConnected(currentActivity)){
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                                    Intent intent = new Intent(AdsController.this, StartActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    currentActivity.startActivity(intent);
                                } else {
                                    currentActivity.startActivity(new Intent(AdsController.this, PermissionActivity.class));

                                }
                            }
                        }

                    }
                }, 1000);
            }
        });
    }


    private void createTimer() {
        if (adsTag.equalsIgnoreCase("on")) {
            Application application = currentActivity.getApplication();

            if (!(application instanceof AdsController)) {
                startMainActivity(currentActivity);
                return;
            }
            appOpenAdManager.showAdIfAvailable(currentActivity, new OnShowAdCompleteListener() {
                @Override
                public void onShowAdComplete() {
                    startMainActivity(currentActivity);
                }
            });
        } else {
            startMainActivity(currentActivity);
        }

    }


    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);
        if (adsTag.equalsIgnoreCase("on")) {
            appOpenAdManager.showAdIfAvailable(currentActivity);
        }
    }


    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity;
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    protected abstract void onCreate(@Nullable Bundle savedInstanceState);

    public interface OnShowAdCompleteListener {
        void onShowAdComplete();
    }

    private class AppOpenAdManager {

        private AppOpenAd appOpenAd = null;
        private boolean isLoadingAd = false;
        private boolean isShowingAd = false;

        private long loadTime = 0;

        public AppOpenAdManager() {
        }

        private void loadAd(Context context) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (isLoadingAd || isAdAvailable()) {
                    return;
                }
                isLoadingAd = true;
                AdRequest request = new AdRequest.Builder().build();
                AppOpenAd.load(context, appOpenKey, request, new AppOpenAdLoadCallback() {

                    @Override
                    public void onAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        isLoadingAd = false;
                        loadTime = (new Date()).getTime();
                    }


                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        isLoadingAd = false;
                    }
                });
            }
        }

        private boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
            long dateDifference = (new Date()).getTime() - loadTime;
            long numMilliSecondsPerHour = 3600000;
            return (dateDifference < (numMilliSecondsPerHour * numHours));
        }

        private boolean isAdAvailable() {
            return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
        }


        private void showAdIfAvailable(@NonNull final Activity activity) {
            showAdIfAvailable(activity, new OnShowAdCompleteListener() {
                @Override
                public void onShowAdComplete() {
                }
            });
        }

        private void showAdIfAvailable(@NonNull final Activity activity, @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
            if (isShowingAd) {
                return;
            }

            if (!isAdAvailable()) {
                onShowAdCompleteListener.onShowAdComplete();
                loadAd(activity);
                return;
            }


            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    appOpenAd = null;
                    isShowingAd = false;
                    Log.e("vbvbfgfg", "onAdDismissedFullScreenContent: ");
                    onShowAdCompleteListener.onShowAdComplete();
                    loadAd(activity);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    appOpenAd = null;
                    isShowingAd = false;

                    onShowAdCompleteListener.onShowAdComplete();
                    loadAd(activity);
                }

                @Override
                public void onAdShowedFullScreenContent() {

                }
            });

            if (!isInterShowing) {
                isShowingAd = true;
                appOpenAd.show(activity);
            }
        }

    }

    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
