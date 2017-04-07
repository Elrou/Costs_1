import com.amazonaws.services.s3.model.ListObjectsV2Request
import com.amazonaws.services.s3.model.ListObjectsV2Result
import com.amazonaws.services.s3.model.ObjectListing
import com.mongodb.AggregationOutput
import com.mongodb.BasicDBObject
import com.mongodb.DBCollection
import com.mongodb.DBCursor
import com.mongodb.FindIterableImpl
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor

import com.mongodb.DBObject
import java.util.zip.GZIPInputStream;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.cloudsearchdomain.model.Bucket
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.S3ObjectSummary

class AwsConnection{

    public static void main(String[] args) {
        def lst = [], clst = []
        int v = 0
        int c = 0
        String accessKey = "AKIAIGFYZ6ZAM4N3AYQA"
        String secretKey = "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"
        String bucketName = "log.esoftsystems.com"
        AmazonS3 s3


        MongoClient mongo = new MongoClient("localhost", 27017)
        def db = mongo.getDatabase("costs")
        MongoCollection<Document> collection = db.getCollection("Test")

        /*s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey))


          ListObjectsV2Request lor = new ListObjectsV2Request()
                  .withBucketName(bucketName)
          ListObjectsV2Result objectListing


        objectListing =s3.listObjectsV2(lor)

              for (S3ObjectSummary summary : objectListing.getObjectSummaries()){
            S3Object  s3object = s3.getObject(new GetObjectRequest(bucketName, summary.getKey()))
             InputStream objectStream = s3object.getObjectContent()
             BufferedReader x = new BufferedReader(new InputStreamReader(new GZIPInputStream(objectStream)
                  ))


                  String content
                  while ((content = x.readLine()) != null) {


                      content.eachLine { String line ->
                          if (line.startsWith("2")) {
                              println line

                              lst = line.split()
                              clst = lst[7].split("/")
                              if ((clst.size() >= 3) && ('0123456789'.contains(clst[1][0]))) {
                                  v++
                                  Long c = Long.parseLong(clst[1])
                                  float y = Float.parseFloat(lst[3])

                                  Document doc = new Document("Date", lst[0])
                                          .append("time", lst[1])
                                          .append("clientID", c)
                                          .append("sc_byte", y)
                                  collection.insertOne(doc);
                              }

                          }



                      }
                      lor.setContinuationToken(objectListing.getNextContinuationToken())
                  }
                  x.close()
              }



/*
        displayTextInputStream(s3object.getObjectContent());
https://s3-eu-west-1.amazonaws.com/log.esoftsystems.com/cf-m2test/E8QOGPZIOJ5FI.2017-03-01-01.cbf733bd.gz
https://s3-eu-west-1.amazonaws.com/log.esoftsystems.com/cf-m2test/E8QOGPZIOJ5FI.2017-03-08-15.552b48e4.gz

          InputStream nnn
          protected static displayTextInputStream(InputStream nnn)
                  throws IOException {
              // Read one text line at a time and display.
              BufferedReader reader = new BufferedReader(new
                      InputStreamReader(nnn));
              while (true) {
                  String line = reader.readLine();
                  if (line == null) break;

                  System.out.println("    " + line);
              }
              System.out.println();
          }
      }*/

        /*  List<Bucket> buckets = s3.listBuckets();
         for (String item : buckets) {
             System.out.println(item)
         }

        ListObjectsRequest lor = new ListObjectsRequest()
                .withBucketName(bucketName).withPrefix(key)

        ObjectListing objectListing = s3.listObjects(lor);
        for (S3ObjectSummary summary: objectListing.getObjectSummaries()) {

            BufferedReader x = new BufferedReader(new InputStreamReader(
                    // new GZIPInputStream(new FileInputStream("/Users/rbe/Desktop/rihab.gz"))
                    new GZIPInputStream(new FileInputStream( ))
            ))

            String content;

            while ((content = x.readLine()) != null)

                System.out.println(content);


        }}




/*        String readed;
        while ((readed = x.readLine()) != null) {
            System.out.println(readed);
        }

println v */





        BasicDBObject AllClient = new BasicDBObject()
        DBObject clientID = new BasicDBObject()
        clientID.put("clientID")

        MongoCursor<Document> cursor = collection.find(clientID).iterator()

        try {

            while (cursor.hasNext()) {
                c++
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

println c
    }}