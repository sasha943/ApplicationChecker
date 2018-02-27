package com.worldapp.qa;


import org.apache.log4j.Logger;

import java.io.IOException;

public class ApplicationRunner {

    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {

        try {
            if (!isValidArguments(args)) {
                LOG.error("Invalid arguments, example: java - jar cordova androidVersion iosVersion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String applicationType = "cordova";
        String androidVersion = "8.18.882";
        String iosVersion = "8.18.882";

        ApplicationChecker applicationChecker = new ApplicationChecker(androidVersion, iosVersion);
        boolean isIosVersionCorrect = false;
        boolean isAndroidVersionCorrect = false;

        try {
            if (applicationType.equals("cordova")) {
                isAndroidVersionCorrect = applicationChecker.checkAndroidApp();
                isIosVersionCorrect = applicationChecker.checkIosApp();
            }
            if (applicationType.equals("native")) {
                isAndroidVersionCorrect = applicationChecker.checkNativeAndroidApp();
                isIosVersionCorrect = applicationChecker.checkNativeIosApp();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isAndroidVersionCorrect && isIosVersionCorrect) {

        }
    }

    private static boolean isValidArguments(String[] args) throws Exception {
        return args.length == 3 && (args[0].equals("cordova") || args[0].equals("native"));
    }
}
