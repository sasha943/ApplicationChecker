package com.worldapp.qa;


import org.apache.log4j.Logger;
import java.io.IOException;

public class ApplicationRunner {

    private static Logger LOG = Logger.getLogger(ApplicationRunner.class);

    public static void main(String[] args) throws Exception {

        /*if (!isValidArguments(args)) {
            throw new IllegalArgumentException("Invalid arguments, example:
            java -jar jarName appType{cordova/native} platform{android/ios} formcomExpectedValue keysurveyExpectedValue");
        }*/

        String androidVersion = "8.18.882";//args[1];
        String iosVersion = "818882";//args[2];

        String applicationType = "cordova";//args[0];
        String platform = "android";

        ApplicationChecker applicationChecker = new ApplicationChecker();

        try {
            if (applicationType.equals("cordova")) {
                LOG.info("Check cordova application");

                if (platform.equals("android")) {
                    LOG.info("---------------------Check Android application---------------------");
                    String actualFormComHash = applicationChecker.getFormComHash();
                    String actualKeySurveyHash = applicationChecker.getKeySurveyHash();
                    LOG.info("Form.com: " + actualFormComHash + " KeySurvey: " + actualKeySurveyHash);
                }

                if (platform.equals("ios")) {
                    LOG.info("---------------------Check IOS application---------------------");
                    String actualIosFormComReleaseDate = applicationChecker.getIosFormComReleaseDate();
                    String actualIosKeySurveyReleaseDate = applicationChecker.getIosKeySurveyReleaseDate();
                    LOG.info("Form.com: " + actualIosFormComReleaseDate + " KeySurvey: " + actualIosKeySurveyReleaseDate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        EmailUtil.sendEmailToInfoSec();
    }

    private static boolean isValidArguments(String[] args) {
        return args.length == 4 && (args[0].equals("cordova") || args[1].equals("ios") || args[1].equals("android"));
    }
}
