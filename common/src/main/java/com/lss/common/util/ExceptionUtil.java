package com.lss.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        try {
            throwable.printStackTrace(pw);
            return sw.getBuffer().toString();
        } finally {
            pw.close();
        }
    }
}
