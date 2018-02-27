package com.worldapp.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldapp.qa.downloaders.FileManager;
import com.worldapp.qa.parser.ApkFileParser;
import com.worldapp.qa.urlGenerator.ApkDownloadingUrl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ApplicationChecker {

    private String androidExpectedVersion;
    private String iosExpectedVersion;

    public ApplicationChecker(String androidExpectedVersion, String iosExpectedVersion) {
        this.androidExpectedVersion = androidExpectedVersion;
        this.iosExpectedVersion = iosExpectedVersion;
    }

    public boolean checkAndroidApp() throws IOException {
        //ApkFileParser apkFormComFileParser = downloadAndGetApkVersionCode(ApplicationBundle.FORM_CORDOVA.getBundleName());
        //boolean isFormComCorrectVersion = apkFormComFileParser.getVersionCode().equals(androidExpectedVersion);
        ApkFileParser apkKeySurveyFileParser = downloadAndGetApkVersionCode(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName());
        boolean isKeySurveyCorrectVersion = apkKeySurveyFileParser.getVersionCode().equals(androidExpectedVersion);
        return /*isFormComCorrectVersion &&*/ isKeySurveyCorrectVersion;
    }

    public boolean checkIosApp() throws IOException {
        FileManager.createDownloadFolder("ios");
        String iosFormComVersion = downloadAndGetIosVersion(ApplicationBundle.FORM_CORDOVA.getBundleName());
        String iosKeySurveyVersion = downloadAndGetIosVersion(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName());
        return iosKeySurveyVersion.equals(iosExpectedVersion) && iosFormComVersion.equals(iosExpectedVersion);
    }

    public boolean checkNativeAndroidApp() throws IOException {
        ApkFileParser apkFileParser = downloadAndGetApkVersionCode(ApplicationBundle.ANDROID_NATIVE.getBundleName());
        return apkFileParser.getVersionCode().equals(androidExpectedVersion);
    }

    public boolean checkNativeIosApp() throws IOException {
        return false;
    }

    private ApkFileParser downloadAndGetApkVersionCode(String bundleId) throws IOException {
        String downloadFolder = FileManager.createDownloadFolder("apk");
        String apkDownloadingUrl = ApkDownloadingUrl.getApkDownloadingUrl(bundleId);
        File downloadFile = FileManager.downloadFile(apkDownloadingUrl, downloadFolder);
        return new ApkFileParser(downloadFile);
    }

    private String downloadAndGetIosVersion(String bundleId) throws IOException {
        String downloadFileUrl = AppSearchingUrl.IOS_SEARCH_URL.getUrl() + bundleId;
        ObjectMapper mapper = new ObjectMapper();
        IosInfo iosInfo = mapper.readValue(new URL(downloadFileUrl), IosInfo.class);
        String iosVersion = "";
        for (Result result : iosInfo.getResults()) {
            iosVersion = result.getVersion();
        }
        return iosVersion;
    }
}
