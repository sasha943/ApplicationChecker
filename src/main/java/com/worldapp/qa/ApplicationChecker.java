package com.worldapp.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldapp.qa.managers.FileManager;
import com.worldapp.qa.models.ios.IosInfo;
import com.worldapp.qa.models.ios.Result;
import com.worldapp.qa.urlGenerator.ApkDownloadingUrl;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class ApplicationChecker {

    private static final Logger LOG = Logger.getLogger(ApplicationChecker.class);

    /**
    * Android Application
    * */

    public String getFormComHash() throws IOException, NoSuchAlgorithmException {
        File filePath = downloadAndSaveFile(ApplicationBundle.FORM_CORDOVA.getBundleName(), "apk");
        return FileManager.getSHA256FileHash(filePath);
    }

    public String getKeySurveyHash() throws IOException, NoSuchAlgorithmException {
        File filePath = downloadAndSaveFile(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName(), "apk");
        return FileManager.getSHA256FileHash(filePath);
    }

    /**
    * iOS Application
    * */

    public String getIosKeySurveyReleaseDate() throws IOException {
        LOG.info("Check iOS cordova KeySurvey app");
        String iosKeySurveyDate = downloadAndGetIosReleaseDate(ApplicationBundle.KEYSURBEY_CORDOVA.getBundleName());
        LOG.info("iOS cordova KeySurvey app actual version is: " + iosKeySurveyDate);
        return iosKeySurveyDate;
    }

    public String getIosFormComReleaseDate() throws IOException {
        LOG.info("Check iOS cordova KeySurvey app");
        String iosFormComDate = downloadAndGetIosReleaseDate(ApplicationBundle.FORM_CORDOVA.getBundleName());
        LOG.info("iOS cordova KeySurvey app actual version is: " + iosFormComDate);
        return iosFormComDate;
    }

    private File downloadAndSaveFile(String bundleId, String dir) throws IOException {
        String apkDownloadingUrl = ApkDownloadingUrl.getApkDownloadingUrl(bundleId);
        return FileManager.downloadFile(apkDownloadingUrl, dir);
    }

    private String downloadAndGetIosReleaseDate(String bundleId) throws IOException {
        String downloadFileUrl = AppSearchingUrl.IOS_SEARCH_URL.getUrl() + bundleId;
        ObjectMapper mapper = new ObjectMapper();
        IosInfo iosInfo = mapper.readValue(new URL(downloadFileUrl), IosInfo.class);
        return iosInfo.getResults().stream().map(Result::getReleaseDate).findFirst().get();
    }
}
