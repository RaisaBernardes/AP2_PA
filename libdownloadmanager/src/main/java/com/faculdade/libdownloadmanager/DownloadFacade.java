package com.faculdade.libdownloadmanager;

public class DownloadFacade {

    private IDownloadController downloadController;

    private DownloadFacade() {
        downloadController = DownloadController.getInstance();
    }

    private static final class Singleton {
        static final DownloadFacade INSTANCE = new DownloadFacade();
    }

    public static DownloadFacade getInstance() {
        return Singleton.INSTANCE;
    }

    public IDownloadController getDownloadController() {
        return downloadController;
    }
}
