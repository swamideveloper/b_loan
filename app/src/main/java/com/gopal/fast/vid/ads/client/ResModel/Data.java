package com.gopal.fast.vid.ads.client.ResModel;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Keep
public class Data {

    @SerializedName("Appname")
    @Expose
    private String appname;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("extra_fields")
    @Expose
    private ExtraFields extraFields;
    @SerializedName("ads_units")
    @Expose
    private List<AdsUnit> adsUnits = null;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public ExtraFields getExtraFields() {
        return extraFields;
    }

    public void setExtraFields(ExtraFields extraFields) {
        this.extraFields = extraFields;
    }

    public List<AdsUnit> getAdsUnits() {
        return adsUnits;
    }

    public void setAdsUnits(List<AdsUnit> adsUnits) {
        this.adsUnits = adsUnits;
    }

}