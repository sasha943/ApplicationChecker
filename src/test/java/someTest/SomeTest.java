package someTest;


import com.worldapp.qa.downloaders.FileManager;
import com.worldapp.qa.parser.ApkFileParser;
import com.worldapp.qa.urlGenerator.ApkDownloadingUrl;
import net.dongliu.apk.parser.bean.ApkSigner;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;

public class SomeTest {

    private static Logger LOG = Logger.getLogger(SomeTest.class);

    public static void main(String[] args) throws IOException, CertificateException {
        String apkDownloginUrl = ApkDownloadingUrl.getApkDownloadingUrl("com.form.offline");
        LOG.info(apkDownloginUrl);
        File apkFile = FileManager.downloadFile(apkDownloginUrl, "src/main/resources/apk");
        ApkFileParser apkFileParser = new ApkFileParser(apkFile);
        LOG.info(apkFileParser.getApkLabel());
        LOG.info(apkFileParser.getApkPackageName());
        LOG.info(apkFileParser.getVersionCode());

        for (ApkSigner apkSigner : apkFileParser.getApkSigners()) {
            LOG.info(apkSigner.getCertificateMetas().toString());
            LOG.info(apkSigner.getPath());
        }
    }
}
