package com.syntel.client.onboarding.kyc.filestore;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.apache.tika.Tika;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * AWS S3 implementation of file storage. Uploaded files are stored in
 */
public class AwsFileStore {

    private final AmazonS3 s3;
    private String bucketName;
    private final Tika tika = new Tika();

    public AwsFileStore(AmazonS3 s3, String bucketName) {
        this.s3 = s3;
        this.bucketName = bucketName;
    }

    /**
     * puts the file into the s2 bucket
     * @param fileBlob
     */
    public void put(FileBlob fileBlob){
        s3.putObject(bucketName, fileBlob.getName(), fileBlob.getInputStream(), new ObjectMetadata());
    }

    /**
     * returns the file from the s3 bucket
     * @param name
     * @return
     * @throws IOException
     */
    public Optional<FileBlob> get(String name) throws IOException {
        if (!s3.doesObjectExist(bucketName, name)) {
            return Optional.empty();
        }

        S3Object s3Object = s3.getObject(bucketName, name);
        S3ObjectInputStream fileContent = s3Object.getObjectContent();

        byte[] bytes = IOUtils.toByteArray(fileContent);

        return Optional.of(new FileBlob(
                name,
                new ByteArrayInputStream(bytes),
                tika.detect(bytes)
        ));

    }
}
