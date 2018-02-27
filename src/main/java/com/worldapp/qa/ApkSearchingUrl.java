package com.worldapp.qa;


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
