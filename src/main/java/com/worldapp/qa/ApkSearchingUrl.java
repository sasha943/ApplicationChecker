package com.worldapp.qa;

/**
 * Created by ubuntu on 25.02.18.
 */
public enum ApkSearchingUrl {

    APK_SEARCHING_URL("http://apk-dl.com/");

    private String url;

    ApkSearchingUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
