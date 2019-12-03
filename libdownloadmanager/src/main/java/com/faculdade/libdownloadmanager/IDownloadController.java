package com.faculdade.libdownloadmanager;

import android.content.Context;

public interface IDownloadController {
    void download(Context context, String url, String type);
}
