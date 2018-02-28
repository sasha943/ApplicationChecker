package com.worldapp.qa;


import java.io.IOException;

public class ApplicationRunner {

    public static void main(String[] args) throws Exception {

        if (!isValidArguments(args)) {
            throw new IllegalArgumentException("Invalid arguments, example: java -jar jarName cordova androidVersion iosVersion");
        }

        String applicationType = args[0];
        String androidVersion = args[1];
        String iosVersion = args[2];

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

        if (!isAndroidVersionCorrect || !isIosVersionCorrect) {
            EmailUtil.sendEmailToInfoSec();
        }
    }

    private static boolean isValidArguments(String[] args) {
        return args.length == 3 && (args[0].equals("cordova") || args[0].equals("native"));
    }
}
