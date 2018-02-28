package com.worldapp.qa;


public enum ApplicationBundle {

    FORM_CORDOVA("com.form.offline"),
    KEYSURBEY_CORDOVA("com.keysurvey.offline"),
    ANDROID_NATIVE("com.worldapp.app"),
    IOS_NATIVE("");

    private String bundleName;

    ApplicationBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getBundleName() {
        return bundleName;
    }
}
