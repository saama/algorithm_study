public class ship {
    private List<KeyVersion> processEventsInBucket(String bucketName) {
      final AmazonS3 s3Client = EventHandler.getS3Client();
      ObjectListing files = s3Client.listObjects(bucketName);
}
    public void test() {
      while(true) {
        System.out.println('aaaa');
      }
    }
    public static long sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum+= a[i];
        }
        return sum;
    }
}
