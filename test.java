public class test{
  rivate List<KeyVersion> processEventsInBucket(String bucketName) {
      final AmazonS3 s3Client = EventHandler.getS3Client();
      ObjectListing files = s3Client.listObjects(bucketName);
  }
}
