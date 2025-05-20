package org.example.Utilities;

import java.io.File;
import java.util.Arrays;

public class FileDownloader {
    private final String downloadPath;

    public FileDownloader(String downloadPath) {
        this.downloadPath = downloadPath;
        new File(downloadPath).mkdirs(); // Auto-create directory if needed
    }

    public boolean isFileDownloaded(String fileNamePattern, int timeoutSeconds) throws InterruptedException {
        long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000L);

        while (System.currentTimeMillis() < endTime) {
            File[] files = new File(downloadPath).listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().contains(fileNamePattern)) {
                        return true;
                    }
                }
            }
            Thread.sleep(1000); // Check every second
        }
        return false;
    }

    public void cleanupDownloads() {
        File[] files = new File(downloadPath).listFiles();
        if (files != null) Arrays.stream(files).forEach(File::delete);
    }
}