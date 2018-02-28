package com.worldapp.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldapp.qa.managers.FileManager;
import com.worldapp.qa.models.ios.IosInfo;
import com.worldapp.qa.models.ios.Result;
import com.worldapp.qa.parser.ApkFileParser;
import com.worldapp.qa.urlGenerator.ApkDownloadingUrl;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.stream.StreamSupport;

public class ApplicationChecker {

    private static final Logger LOG = Logger.getLogger(ApplicationChecker.class);

    private String androidExpectedVersion;
    private String iosExpectedVersion;

    public ApplicationChecker(String androidExpectedVersion, String iosExpectedVersion) {
        this.androidExpectedVersion = androidExpectedVersion;
        this.iosExpectedVersion = iosExpectedVersion;
    }

    public boolean checkAndroidApp() throws IOException {
        String downloadFolder = FileManager.createDownloadFolder("apk");
        LOG.info("Check android cordova Form.com app");
        ApkFileParser apkFormComFileParser = downloadAndGetApkVersionCode(ApplicationBundle.FORM_CORDOVA.getBundleName(), downloadFolder);
        Long formComVersionCode = apkFormComFileParser.getVersionCode();
        LOG.info("Android cordova Form.com app actual version is: " + formComVersionCode + " and expected: " + androidExpectedVersion);
        boolean isFormComCorrectVersion = formComVersionCode.equals(androidExpectedVersion);

        LOG.info("Check android cordova KeySurvey app");
        ApkFileParser apkKeySurveyFileParser = downloadAndGetApkVersionCode(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName(), downloadFolder);
        Long keySurveyVersionCode = apkKeySurveyFileParser.getVersionCode();
        boolean isKeySurveyCorrectVersion = keySurveyVersionCode.equals(androidExpectedVersion);
        LOG.info("Android cordova KeySurvey app actual version is: " + keySurveyVersionCode + " and expected: " + androidExpectedVersion);
        return isFormComCorrectVersion && isKeySurveyCorrectVersion;
    }

    public boolean checkIosApp() throws IOException {
        LOG.info("Check iOS cordova Form.com app");
        String iosFormComVersion = downloadAndGetIosVersion(ApplicationBundle.FORM_CORDOVA.getBundleName());
        LOG.info("iOS cordova Form.com app actual version is: " + iosFormComVersion + " and expected: " + iosExpectedVersion);
        LOG.info("Check iOS cordova KeySurvey app");
        String iosKeySurveyVersion = downloadAndGetIosVersion(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName());
        LOG.info("iOS cordova KeySurvey app actual version is: " + iosKeySurveyVersion + " and expected: " + iosExpectedVersion);
        return iosKeySurveyVersion.equals(iosExpectedVersion) && iosFormComVersion.equals(iosExpectedVersion);
    }

    public boolean checkNativeAndroidApp() throws IOException {
        String downloadFolder = FileManager.createDownloadFolder("apk");
        LOG.info("Check android native app");
        ApkFileParser apkFileParser = downloadAndGetApkVersionCode(ApplicationBundle.ANDROID_NATIVE.getBundleName(), downloadFolder);
        Long versionCode = apkFileParser.getVersionCode();
        LOG.info("Android native app actual version is: " + versionCode + " and expected: " + androidExpectedVersion);
        return versionCode.equals(androidExpectedVersion);
    }

    public boolean checkNativeIosApp() throws IOException {
        LOG.info("Check iOS native app");
        String nativeVersion = downloadAndGetIosVersion(ApplicationBundle.IOS_NATIVE.getBundleName());
        LOG.info("iOS native app actual version is: " + nativeVersion + " and expected: " + iosExpectedVersion);
        return nativeVersion.equals(iosExpectedVersion);
    }

    private ApkFileParser downloadAndGetApkVersionCode(String bundleId, String dir) throws IOException {
        String apkDownloadingUrl = ApkDownloadingUrl.getApkDownloadingUrl(bundleId);
        File downloadFile = FileManager.downloadFile(apkDownloadingUrl, dir);
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
