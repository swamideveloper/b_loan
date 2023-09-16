package com.gopal.fast.vid.ads.client.ResModel;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
public class ExtraFields {


    @SerializedName("vpn")
    @Expose
    private String vpn;
    @SerializedName("not_now")
    @Expose
    private String notNow;
    @SerializedName("vpnId")
    @Expose
    private String vpnId;
    @SerializedName("vpnLink")
    @Expose
    private String vpnLink;
    @SerializedName("vpnCountry")
    @Expose
    private String vpnCountry;
    @SerializedName("ads")
    @Expose
    private String ads;
    @SerializedName("thankyou")
    @Expose
    private String thankyou;
    @SerializedName("moreapps")
    @Expose
    private String moreapps;
    @SerializedName("extra_screen")
    @Expose
    private String extraScreen;
    @SerializedName("exit_dialogue")
    @Expose
    private String exitDialogue;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("privacy_policy")
    @Expose
    private String privacyPolicy;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("permission")
    @Expose
    private String permission;
    @SerializedName("native_on_off")
    @Expose
    private String nativeOnOff;
    @SerializedName("start_button")
    @Expose
    private String startButton;
    @SerializedName("IN_APP_ONOFF")
    @Expose
    private String inAppOnoff;
    @SerializedName("groupname")
    @Expose
    private String groupname;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("inter_frequency")
    @Expose
    private String interFrequency;
    @SerializedName("native_frequency")
    @Expose
    private String nativeFrequency;
    @SerializedName("back_inter_frequency")
    @Expose
    private String backInterFrequency;
    @SerializedName("LoginONOFF")
    @Expose
    private String loginONOFF;

    public String getComboAds() {
        return comboAds;
    }

    public void setComboAds(String comboAds) {
        this.comboAds = comboAds;
    }

    @SerializedName("combo-ads")
    @Expose
    private String comboAds;

    public String getDoPermission() {
        return doPermission;
    }

    public void setDoPermission(String doPermission) {
        this.doPermission = doPermission;
    }

    @SerializedName("do-permission")
    @Expose
    private String doPermission;

    public String getFakeCall() {
        return FakeCall;
    }

    public void setFakeCall(String fakeCall) {
        FakeCall = fakeCall;
    }

    @SerializedName("FakeCall")
    @Expose
    private String FakeCall;

    public String getAlternetAppOpen() {
        return alternetAppOpen;
    }

    public void setAlternetAppOpen(String alternetAppOpen) {
        this.alternetAppOpen = alternetAppOpen;
    }

    @SerializedName("alternet_app_open")
    @Expose
    private String alternetAppOpen;

    public String getClickAppOpen() {
        return clickAppOpen;
    }

    public void setClickAppOpen(String clickAppOpen) {
        this.clickAppOpen = clickAppOpen;
    }

    @SerializedName("click_app_open")
    @Expose
    private String clickAppOpen;

    public String getBackAppOpen() {
        return backAppOpen;
    }

    public void setBackAppOpen(String backAppOpen) {
        this.backAppOpen = backAppOpen;
    }

    @SerializedName("back_app_open")
    @Expose
    private String backAppOpen;

    public String getVpn() {
        return vpn;
    }

    public void setVpn(String vpn) {
        this.vpn = vpn;
    }

    public String getNotNow() {
        return notNow;
    }

    public void setNotNow(String notNow) {
        this.notNow = notNow;
    }

    public String getVpnId() {
        return vpnId;
    }

    public void setVpnId(String vpnId) {
        this.vpnId = vpnId;
    }

    public String getVpnLink() {
        return vpnLink;
    }

    public void setVpnLink(String vpnLink) {
        this.vpnLink = vpnLink;
    }

    public String getVpnCountry() {
        return vpnCountry;
    }

    public void setVpnCountry(String vpnCountry) {
        this.vpnCountry = vpnCountry;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public String getThankyou() {
        return thankyou;
    }

    public void setThankyou(String thankyou) {
        this.thankyou = thankyou;
    }

    public String getMoreapps() {
        return moreapps;
    }

    public void setMoreapps(String moreapps) {
        this.moreapps = moreapps;
    }

    public String getExtraScreen() {
        return extraScreen;
    }

    public void setExtraScreen(String extraScreen) {
        this.extraScreen = extraScreen;
    }

    public String getExitDialogue() {
        return exitDialogue;
    }

    public void setExitDialogue(String exitDialogue) {
        this.exitDialogue = exitDialogue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getNativeOnOff() {
        return nativeOnOff;
    }

    public void setNativeOnOff(String nativeOnOff) {
        this.nativeOnOff = nativeOnOff;
    }

    public String getStartButton() {
        return startButton;
    }

    public void setStartButton(String startButton) {
        this.startButton = startButton;
    }

    public String getInAppOnoff() {
        return inAppOnoff;
    }

    public void setInAppOnoff(String inAppOnoff) {
        this.inAppOnoff = inAppOnoff;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getInterFrequency() {
        return interFrequency;
    }

    public void setInterFrequency(String interFrequency) {
        this.interFrequency = interFrequency;
    }

    public String getNativeFrequency() {
        return nativeFrequency;
    }

    public void setNativeFrequency(String nativeFrequency) {
        this.nativeFrequency = nativeFrequency;
    }

    public String getBackInterFrequency() {
        return backInterFrequency;
    }

    public void setBackInterFrequency(String backInterFrequency) {
        this.backInterFrequency = backInterFrequency;
    }

    public String getLoginONOFF() {
        return loginONOFF;
    }

    public void setLoginONOFF(String loginONOFF) {
        this.loginONOFF = loginONOFF;
    }


}