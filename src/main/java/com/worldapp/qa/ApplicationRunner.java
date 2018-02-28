package com.worldapp.qa;


import org.apache.log4j.Logger;

import java.io.IOException;

public class ApplicationRunner {

    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class);

    public static void main(String[] args) throws Exception {

        if (!isValidArguments(args)) {
            throw new IllegalArgumentException("Invalid arguments, example: java - jar cordova androidVersion iosVersion");
        }

        String applicationType = "cordova";
        String androidVersion = "8.18.882";
        String iosVersion = "8.23.881";

        ApplicationChecker applicationChecker = new ApplicationChecker(androidVersion, iosVersion);
        boolean isIosVersionCorrect = true;
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

        if (!isAndroidVersionCorrect || !isIosVersionCorrect) {
            LOG.info("Send email to InfoSec");
            EmailUtil.sendEmailToInfoSec();
        }
    }

    private static boolean isValidArguments(String[] args) throws Exception {
        return args.length == 3 && (args[0].equals("cordova") || args[0].equals("native"));
    }
}
