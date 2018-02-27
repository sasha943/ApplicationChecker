package com.worldapp.qa.urlGenerator;

import com.worldapp.qa.AppSearchingUrl;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ApkDownloadingUrl {

    private static Logger LOG = Logger.getLogger(ApkDownloadingUrl.class);

    private static final String HREF_ATTRIBUTE = "href";
    private static final int TIMEOUT = 60000;

    public static String getApkDownloadingUrl(String packageName) throws IOException {
        String url = AppSearchingUrl.APK_SEARCHING_URL.getUrl();
        String downloadFileUrl = "";
        Elements findElement = Jsoup.connect(url + packageName).get().select(".download-btn .mdl-button");

        if (findElement.size() > 0) {
            findElement = Jsoup.connect(url + findElement.attr(HREF_ATTRIBUTE)).timeout(TIMEOUT).get().select(".detail a");

            if (findElement.size() > 0) {
                findElement = Jsoup.connect(findElement.attr(HREF_ATTRIBUTE)).timeout(TIMEOUT).get().select(".contents a");
                if (findElement.size() > 0) {
                    downloadFileUrl = "http:" + findElement.attr(HREF_ATTRIBUTE);
                }
            }
        }
        LOG.info("Download file url is: " + downloadFileUrl);
        return downloadFileUrl;
    }

}
