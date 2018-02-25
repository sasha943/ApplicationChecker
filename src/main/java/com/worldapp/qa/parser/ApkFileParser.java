package com.worldapp.qa.parser;


import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkSigner;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.List;

public class ApkFileParser {

    private ApkFile apkFile;

    public ApkFileParser(File file) throws IOException {
        apkFile = new ApkFile(file);
    }

    public String getApkLabel() throws IOException {
        return apkFile.getApkMeta().getLabel();
    }

    public Long getVersionCode() throws IOException {
        return apkFile.getApkMeta().getVersionCode();
    }

    public String getApkPackageName() throws IOException {
        return apkFile.getApkMeta().getPackageName();
    }

    public List<ApkSigner> getApkSigners() throws IOException, CertificateException {
        return apkFile.getApkSingers();
    }
}
