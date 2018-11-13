package com.example.testdepthfirstapp.utils;

import com.example.testdepthfirstapp.exception.DataFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);

    public static Boolean verifiedIsNullObject(Object object, String message) throws Exception {
        if (object != null) {
            return true;
        } else {
            String msg = message + " " + Constant.RESPONSE.MSG.DATA_NOT_FOUND;
            throw new DataFormatException(msg);
        }
    }

    public static Boolean verifiedGoogleIdNotNull(String googleId) throws Exception {
        if (googleId != null) {
            return true;
        } else {
            String msg = Constant.RESPONSE.MSG.DATA_NOT_FOUND + " invalid googleId";
            throw new DataFormatException(msg);
        }
    }
}
