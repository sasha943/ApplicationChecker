package com.worldapp.qa;


public class ApplicationRunner {

    public static void main(String[] args) {

        if (!isValidArguments(args)) {
            assert false : "";
        }

        String platform = args[0];
        String version = args[1];

        if (platform.equals("cordova")) {

        }

        if (platform.equals("native")) {

        }

        assert false : "Fuck";
    }

    private static boolean isValidArguments(String[] args){
        // validation will be added
        return false;
    }
}
