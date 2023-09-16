package com.gopal.fast.vid.ads;

import static com.gopal.fast.vid.ads.AdsController.adsTag;
import static com.gopal.fast.vid.ads.AdsController.backInterCount;
import static com.gopal.fast.vid.ads.AdsController.backLoad;
import static com.gopal.fast.vid.ads.AdsController.interCount;
import static com.gopal.fast.vid.ads.AdsController.interKey;
import static com.gopal.fast.vid.ads.AdsController.interLoad;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class InterEvent {
    private static InterstitialAd interstitialAds;
    public static boolean isBackInterAd = false;
    public static boolean isInterShowing = false;

    public static void load(Activity activity, AdLoad load) {
        if (isNetworkConnected(activity)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (interstitialAds == null) {
                    AdRequest adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity, interKey, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            interstitialAds = interstitialAd;
                            load.onAdsLoaded();
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            load.onAdsLoaded();
                        }
                    });
                }
            } else {
                load.onAdsLoaded();
                if (isBackInterAd) {
                    activity.finish();
                }
            }
        }


    }

    public static void inter(Activity activity) {
        isBackInterAd = false;
        if (isNetworkConnected(activity)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (interCount == 0) {
                } else if (interCount == 1) {
                    if (interstitialAds != null) {
                        interstitialAds.show(activity);
                        interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                isInterShowing = false;
                                interstitialAds = null;
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                isInterShowing = false;
                                super.onAdFailedToShowFullScreenContent(adError);
                                interstitialAds = null;
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                                isInterShowing = true;
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }
                        });
                    } else {
                        load(activity, new AdLoad() {
                            @Override
                            public void onAdsLoaded() {

                            }
                        });
                    }
                } else {
                    if (interstitialAds != null) {
                        if (interCount == interLoad) {
                            interLoad = 1;
                            interstitialAds.show(activity);
                            interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    isInterShowing = false;
                                    interstitialAds = null;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    isInterShowing = false;
                                    interstitialAds = null;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });
                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                    isInterShowing = true;
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent();
                                }
                            });
                        } else {
                            interLoad = interLoad + 1;
                        }
                    } else {
                        load(activity, new AdLoad() {
                            @Override
                            public void onAdsLoaded() {

                            }
                        });
                    }
                }
            }
        }

    }

    public static void back(Activity activity) {
        isBackInterAd = true;
        if (isNetworkConnected(activity)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (backInterCount == 0) {
                    activity.finish();
                } else if (backInterCount == 1) {
                    if (interstitialAds != null) {
                        interstitialAds.show(activity);
                        interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                isInterShowing = false;
                                super.onAdDismissedFullScreenContent();
                                activity.finish();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                isInterShowing = false;
                                interstitialAds = null;
                                activity.finish();
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });

                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                                isInterShowing = true;
                                interstitialAds = null;
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }
                        });
                    } else {
                        failed(activity);
                    }
                } else {
                    if (interstitialAds != null) {
                        if (backInterCount == backLoad) {
                            interstitialAds.show(activity);
                            backLoad = 1;
                            interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    isInterShowing = false;
                                    super.onAdDismissedFullScreenContent();
                                    activity.finish();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    activity.finish();
                                    isInterShowing = false;
                                    interstitialAds = null;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });
                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                    isInterShowing = true;
                                    interstitialAds = null;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });

                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent();
                                }
                            });
                        } else {
                            backLoad = backLoad + 1;
                            activity.finish();
                        }

                    } else {
                        failed(activity);
                    }
                }
            } else {
                activity.finish();
            }


        } else {
            activity.finish();
        }

    }

    public static void interwithclose(Activity activity, InterCloseCallBack interCloseCallBack) {
        if (isNetworkConnected(activity)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (interCount == 0) {
                    interCloseCallBack.onAdsClose();
                } else if (interCount == 1) {
                    if (interstitialAds != null) {
                        interstitialAds.show(activity);
                        interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                isInterShowing = false;
                                interCloseCallBack.onAdsClose();
                                interstitialAds = null;
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                interCloseCallBack.onAdsClose();
                                isInterShowing = false;
                                interstitialAds = null;
                                load(activity, new AdLoad() {
                                    @Override
                                    public void onAdsLoaded() {

                                    }
                                });
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                                isInterShowing = true;
                            }
                        });
                    } else {
                        interCloseCallBack.onAdsClose();
                        load(activity, new AdLoad() {
                            @Override
                            public void onAdsLoaded() {

                            }
                        });
                    }
                } else {
                    if (interstitialAds != null) {
                        if (interCount == interLoad) {
                            interLoad = 1;
                            interstitialAds.show(activity);
                            interstitialAds.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    isInterShowing = false;
                                    interCloseCallBack.onAdsClose();
                                    interstitialAds = null;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    interCloseCallBack.onAdsClose();
                                    interstitialAds = null;
                                    isInterShowing = false;
                                    load(activity, new AdLoad() {
                                        @Override
                                        public void onAdsLoaded() {

                                        }
                                    });
                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                    isInterShowing = true;
                                }
                            });
                        } else {
                            interCloseCallBack.onAdsClose();
                            interLoad = interLoad + 1;
                        }
                    } else {
                        interCloseCallBack.onAdsClose();
                        load(activity, new AdLoad() {
                            @Override
                            public void onAdsLoaded() {

                            }
                        });
                    }
                }
            } else {
                interCloseCallBack.onAdsClose();
            }
        } else {
            interCloseCallBack.onAdsClose();
        }
    }

    private static void failed(Activity activity) {
        if (adsTag.equalsIgnoreCase("on")) {
            if (interstitialAds == null) {
                AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, interKey, adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        interstitialAds = interstitialAd;
                        activity.finish();
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        activity.finish();
                    }
                });
            } else {
                activity.finish();
            }

        } else {
            activity.finish();
        }

    }


    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}
