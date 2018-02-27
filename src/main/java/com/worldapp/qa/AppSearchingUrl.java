package com.worldapp.qa;


public enum AppSearchingUrl {

    APK_SEARCHING_URL("http://apk-dl.com/"),
    IOS_SEARCH_URL("http://itunes.apple.com/lookup?bundleId=");

    private String url;

    AppSearchingUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
