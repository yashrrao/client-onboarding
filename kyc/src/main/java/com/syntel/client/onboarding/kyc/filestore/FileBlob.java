package com.syntel.client.onboarding.kyc.filestore;

import java.io.InputStream;

public class FileBlob {

    private final String name;
    private final InputStream inputStream;
    private final String contentType;

    public FileBlob(String name, InputStream inputStream, String contentType) {
        this.name = name;
        this.inputStream = inputStream;
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getContentType() {
        return contentType;
    }
}
