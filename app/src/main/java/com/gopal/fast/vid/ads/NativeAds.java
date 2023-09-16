package com.gopal.fast.vid.ads;

import static com.gopal.fast.vid.ads.AdsController.adsTag;
import static com.gopal.fast.vid.ads.AdsController.nativeCount;
import static com.gopal.fast.vid.ads.AdsController.nativeKey;
import static com.gopal.fast.vid.ads.AdsController.nativeLoad;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gopal.fast.vid.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

public class NativeAds {
    private static NativeAd nativeAds;

    public static void load(Activity context) {
        if (adsTag.equalsIgnoreCase("on")) {
            AdLoader.Builder builder = new AdLoader.Builder(context, nativeKey);

            builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                @Override
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    boolean isDestroyed = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        isDestroyed = context.isDestroyed();
                    }
                    if (isDestroyed || context.isFinishing() || context.isChangingConfigurations()) {
                        nativeAd.destroy();
                        return;
                    }
                    if (nativeAds != null) {
                        nativeAds.destroy();
                    }
                    nativeAds = nativeAd;

                }
            });

            VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(false).build();

            NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();

            builder.withNativeAdOptions(adOptions);

            AdLoader adLoader = builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    nativeAds = null;
                }
            }).build();

            adLoader.loadAd(new AdRequest.Builder().build());
        }
    }

    public static void nativeads(Activity context, ViewGroup viewGroup) {
        FrameLayout frameLayouts = (FrameLayout) viewGroup;
        NativeAdView adViews = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayouts, false);
        adViews.findViewById(R.id.ads).setVisibility(View.GONE);
        adViews.findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
        frameLayouts.removeAllViews();
        frameLayouts.addView(adViews);
        if (isNetworkConnected(context)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (nativeCount == 0) {
                } else if (nativeCount == 1) {
                    if (nativeAds != null) {
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                        populateNativeAdView(nativeAds, adView);
                        frameLayout.removeAllViews();
                        adView.findViewById(R.id.ads).setVisibility(View.VISIBLE);
                        adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                        frameLayout.addView(adView);
                        load(context);
                    } else {
                        load(context);
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                        frameLayout.removeAllViews();
                        adView.findViewById(R.id.ads).setVisibility(View.GONE);
                        adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                        frameLayout.addView(adView);
                    }


                } else {
                    if (nativeCount == nativeLoad) {
                        nativeLoad = 1;
                        if (nativeAds != null) {
                            FrameLayout frameLayout = (FrameLayout) viewGroup;
                            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                            populateNativeAdView(nativeAds, adView);
                            frameLayout.removeAllViews();
                            adView.findViewById(R.id.ads).setVisibility(View.VISIBLE);
                            adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                            frameLayout.addView(adView);
                            load(context);
                        } else {
                            load(context);
                            FrameLayout frameLayout = (FrameLayout) viewGroup;
                            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                            adView.findViewById(R.id.ads).setVisibility(View.GONE);
                            adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                            frameLayout.removeAllViews();
                            frameLayout.addView(adView);
                        }

                    } else {
                        nativeLoad = nativeLoad + 1;
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                        adView.findViewById(R.id.ads).setVisibility(View.GONE);
                        adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                        frameLayout.removeAllViews();
                        frameLayout.addView(adView);
                    }

                }
            } else {
                FrameLayout frameLayout = (FrameLayout) viewGroup;
                NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
                adView.findViewById(R.id.ads).setVisibility(View.GONE);
                adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }

        } else {
            FrameLayout frameLayout = (FrameLayout) viewGroup;
            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.ad_unified, frameLayout, false);
            adView.findViewById(R.id.ads).setVisibility(View.GONE);
            adView.findViewById(R.id.imageView).setVisibility(View.GONE);
            frameLayout.removeAllViews();
            frameLayout.addView(adView);
        }

    }

    public static void banner(Activity context, ViewGroup viewGroup) {
        FrameLayout frameLayouts = (FrameLayout) viewGroup;
        NativeAdView adViews = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayouts, false);
        adViews.findViewById(R.id.ads).setVisibility(View.GONE);
        adViews.findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
        frameLayouts.removeAllViews();
        frameLayouts.addView(adViews);
        if (isNetworkConnected(context)) {
            if (adsTag.equalsIgnoreCase("on")) {
                if (nativeCount == 1) {
                    if (nativeAds != null) {
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                        setBanner(nativeAds, adView);
                        frameLayout.removeAllViews();
                        adView.findViewById(R.id.ads).setVisibility(View.VISIBLE);
                        adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                        frameLayout.addView(adView);
                        load(context);
                    } else {
                        load(context);
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                        adView.findViewById(R.id.ads).setVisibility(View.GONE);
                        adView.findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                        frameLayout.removeAllViews();
                        frameLayout.addView(adView);
                    }

                } else {
                    if (nativeCount == nativeLoad) {
                        nativeLoad = 1;
                        if (nativeAds != null) {
                            FrameLayout frameLayout = (FrameLayout) viewGroup;
                            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                            setBanner(nativeAds, adView);
                            frameLayout.removeAllViews();
                            adView.findViewById(R.id.ads).setVisibility(View.VISIBLE);
                            adView.findViewById(R.id.imageView).setVisibility(View.GONE);
                            frameLayout.addView(adView);
                            load(context);
                        } else {
                            load(context);
                            FrameLayout frameLayout = (FrameLayout) viewGroup;
                            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                            adView.findViewById(R.id.ads).setVisibility(View.GONE);
                            adView.findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                            frameLayout.removeAllViews();
                            frameLayout.addView(adView);
                        }

                    } else {
                        nativeLoad = nativeLoad + 1;
                        FrameLayout frameLayout = (FrameLayout) viewGroup;
                        NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                        adView.findViewById(R.id.ads).setVisibility(View.GONE);
                        adView.findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                        frameLayout.removeAllViews();
                        frameLayout.addView(adView);
                    }
                }
            } else {
                FrameLayout frameLayout = (FrameLayout) viewGroup;
                NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
                adView.findViewById(R.id.ads).setVisibility(View.GONE);
                adView.findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }

        } else {
            FrameLayout frameLayout = (FrameLayout) viewGroup;
            NativeAdView adView = (NativeAdView) context.getLayoutInflater().inflate(R.layout.nativebanner, frameLayout, false);
            adView.findViewById(R.id.ads).setVisibility(View.GONE);
            adView.findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            frameLayout.removeAllViews();
            frameLayout.addView(adView);
        }
    }

    private static void setBanner(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.media_view));

        MediaView mediaView = adView.findViewById(R.id.media_view);

        mediaView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                if (child instanceof ImageView) {
                    ImageView imageView = (ImageView) child;
                    imageView.setAdjustViewBounds(true);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
            }
        });

        adView.setHeadlineView(adView.findViewById(R.id.primary));
        adView.setBodyView(adView.findViewById(R.id.body));
        adView.setCallToActionView(adView.findViewById(R.id.cta));
        adView.setIconView(adView.findViewById(R.id.icon));
        adView.setStarRatingView(adView.findViewById(R.id.rating_bar));
        adView.setStoreView(adView.findViewById(R.id.secondary));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
        VideoController vc = nativeAd.getMediaContent().getVideoController();
        if (nativeAd.getMediaContent() != null && nativeAd.getMediaContent().hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        } else {
        }
    }


    private static void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
        VideoController vc = nativeAd.getMediaContent().getVideoController();
        if (nativeAd.getMediaContent() != null && nativeAd.getMediaContent().hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }

    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}
