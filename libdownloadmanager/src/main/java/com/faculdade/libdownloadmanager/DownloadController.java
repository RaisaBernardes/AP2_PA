package com.faculdade.libdownloadmanager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DownloadController implements IDownloadController {

    private DownloadController() {
        // TODO ???
    }

    private static class Singleton {
        static final DownloadController INSTANCE = new DownloadController();
    }

    public static DownloadController getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void download(Context context, String url, String type) {
        //Toast.makeText(context, url, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, DownloadService.class)
                .putExtra("url", url)
                .putExtra("type", type);
        context.startService(intent);
    }
}
