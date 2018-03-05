package com.worldapp.qa.managers;

import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileManager {

    private static Logger LOG = Logger.getLogger(FileManager.class);

    private static final int BUFFER_SIZE = 4096;

    public static File downloadFile(String fileURL, String saveDir) throws IOException {
        if (fileURL.isEmpty()) {
            throw new IllegalArgumentException("Download file url can not be empty");
        }
        String saveFilePath = "";
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");

        int responseCode = httpConn.getResponseCode();

        LOG.info("Check response status code from download server");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String fileName = getFileName(fileURL, disposition);

            InputStream inputStream = httpConn.getInputStream();
            saveFilePath = saveDir + File.separator + fileName;

            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();

            LOG.info("File with name " + fileName + " downloaded.");
        } else {
            LOG.error("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
        return new File(saveFilePath);
    }

    public static String createDownloadFolder(String name) {
        String downloadingFolder = getCurrentFolder() + "/downloadedFiles";
        new File(downloadingFolder).mkdir();
        LOG.info("Directory by path " + downloadingFolder + " created");

        String customDirectory = downloadingFolder + "/" + name;
        File customDir = new File(customDirectory);
        customDir.mkdir();
        LOG.info("Directory by path " + name + " created");
        return customDir.getAbsolutePath();
    }


    public static String getSHA256FileHash(File file) throws NoSuchAlgorithmException, IOException {
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

    private static String getFileName(String fileURL, String disposition) {
        String fileName = "";

        if (disposition != null) {
            // extracts file name from header field
            int index = disposition.indexOf("filename=");
            if (index > 0) {
                fileName = disposition.substring(index + 10,
                        disposition.length() - 1);
            }
        } else {
            // extracts file name from URL
            fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length()).split("\\?")[0];

        }
        return fileName;
    }

    private static String getCurrentFolder() {
        return System.getProperty("user.dir");
    }
}
