package model;

/**
 * This class generates a random temporary password.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */
public class GeneratePassword {

    /**
     * @return a String containing a random password consisting of
     * numbers and letters in lower and upper case.
     */
     public static String generateTempPass(){
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sbr = new StringBuilder(8);
        for (int i = 0; i <8; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            sbr.append(alphaNumericString.charAt(index));
        }
        return sbr.toString();
    }
}
