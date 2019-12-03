package com.faculdade.libdownloadmanager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class DownloadController implements IDownloadController {

    private DownloadController() {}

    private static class Singleton {
        static final DownloadController INSTANCE = new DownloadController();
}

    public static DownloadController getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void download(Context context, String url, String name, String type) {
        //Toast.makeText(context, url, Toast.LENGTH_LONG).show();

        //These are the 4 parameters that we are going to use to download something
        Intent intent = new Intent(context, DownloadService.class)
                .putExtra("url", url)
                .putExtra("name", name)
                .putExtra("type", type);
        context.startService(intent);
    }
}
