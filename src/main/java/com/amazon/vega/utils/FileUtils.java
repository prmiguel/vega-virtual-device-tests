package com.amazon.vega.utils;

import java.util.Arrays;

public class FileUtils {
    public static String getFileNameFromUri(String uri) {
       return Arrays.stream(uri.split("/")).reduce((a, b) -> b).get();
    }
}
