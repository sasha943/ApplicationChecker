package com.worldapp.qa.parser;


import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkSigner;
import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public String getSHA256Hash(File file) throws NoSuchAlgorithmException, IOException {
        byte[] buffer= new byte[8192];
        int count;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
        while ((count = bis.read(buffer)) > 0) {
            digest.update(buffer, 0, count);
        }
        byte[] hash = digest.digest();
        return new BASE64Encoder().encode(hash);
    }
}
