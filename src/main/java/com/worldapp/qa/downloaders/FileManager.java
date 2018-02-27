package com.worldapp.qa.downloaders;

import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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

        // always check HTTP response code first
        LOG.info("Check response status code from download server");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");

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

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
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

    private static String getCurrentFolder() {
        return System.getProperty("user.dir");
    }
}
