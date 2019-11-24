package model;

public class GeneratePassword {
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
