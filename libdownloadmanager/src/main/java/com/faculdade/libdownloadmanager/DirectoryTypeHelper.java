package com.faculdade.libdownloadmanager;

import android.os.Environment;

final class DirectoryTypeHelper {
    private static final String[] PICTURE = {
            "jpg",
            "jpeg",
            "png"
    };
    private static final String[] VIDEO = {
            "mp4",
            "3gp"
    };
    private static final String[] MUSIC = {
            "mp3"
    };

    // We don't instantiate this one
    private DirectoryTypeHelper(){}

    public static String giveDirectoryType(String type) {
        if (type.charAt(0) == '.') {
            type = type.substring(1);
        }

        for (String picture : PICTURE) {
            if (type.equals(picture)) {
                return Environment.DIRECTORY_PICTURES;
            }
        }

        for (String video : VIDEO) {
            if (type.equals(video)) {
                return Environment.DIRECTORY_MOVIES;
            }
        }

        for (String music : MUSIC) {
            if (type.equals(music)) {
                return Environment.DIRECTORY_MUSIC;
            }
        }

        return Environment.DIRECTORY_DOWNLOADS;
    }
}
