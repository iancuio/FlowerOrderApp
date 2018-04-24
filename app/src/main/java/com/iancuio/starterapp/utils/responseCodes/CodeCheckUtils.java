package com.iancuio.starterapp.utils.responseCodes;

/**
 * Created by vlad.iancu on 4/8/2016.
 */
public class CodeCheckUtils {
    public static void codeCheck(int responseCode, CodeCheck codeCheck) {
        if (responseCode == 200) {
            codeCheck.on200();
        } else if (responseCode == 401) {
            codeCheck.on401();
        } else if (responseCode == 404) {
            codeCheck.on404();
        } else if (responseCode == 500) {
            codeCheck.on500();
        } else {
            codeCheck.onOther();
        }
    }
}
