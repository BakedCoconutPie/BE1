
package utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author yuyu
 */
public final class StringHelper {

    /**
     * Make a string into align center form
     *
     * @param spacing number of spacing for string display
     * @param obj object that need to align center
     * @return a string with the content fit in center of the string, if the
     * content has length greater than 'spacing', then put all available content
     * in that spacing and ending with '...'
     */
    public static String center(int spacing, Object obj) {
        // get content from object by toString method
        String text = obj.toString();

        // if length of content greater than spacing
        if (text.length() > spacing) {
            // return with available content ending with ...
            return text.substring(0, spacing - 3).concat("...");
        }

        // otherwise calculate number of spaces covered the content
//        int spaces = spacing - text.length();
//        if (spaces != 0) {
//            return String.format("%" + (spaces / 2) + "s%s%" + (spaces - spaces / 2) + "s", "", text, "");
//        }
        return text;
    }

    public static String toTitle(String str) {
        if (str.trim().isEmpty()) {
            return "";
        }
        String[] words = str.trim().split("\\s+");
        return Arrays.stream(words)
                .map((word) -> " " + Character.toUpperCase(word.charAt(0)) + (word.length() > 1 ? word.toLowerCase().substring(1) : ""))
                .reduce("", String::concat)
                .substring(1);
    }

    public static String SHA256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encoded = md.digest(str.getBytes());

            String result = "";
            for (byte b : encoded) {
                String hex = Integer.toHexString(b);
                result += (hex.length() == 1 ? "0" : "") + hex;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}