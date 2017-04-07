/**
 * Created by rbe on 04/04/2017.
 */
import com.amazonaws.services.s3.model.ListObjectsV2Request
import com.amazonaws.services.s3.model.ListObjectsV2Result
import com.amazonaws.services.s3.model.ObjectListing
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

class Groovy {

    public static void main(String[] args) {
        def lst = [], clst = []
        int v

        String accessKey = "AKIAIGFYZ6ZAM4N3AYQA"
        String secretKey = "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"
        String bucketName = "log.esoftsystems.com"
        AmazonS3 s3


        MongoClient mongo = new MongoClient("localhost", 27017)
        def db = mongo.getDatabase("costs")
        MongoCollection<Document> collection = db.getCollection("log")

        /*FindIterable<Document> find = collection.find()
        MongoCursor<Document> cursor = find.iterator()

        while (cursor.hasNext()) {
            v++
            println cursor.next();
        }  */
        s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey))

        ListObjectsV2Request lor = new ListObjectsV2Request()
                .withBucketName(bucketName)
        ListObjectsV2Result objectListing
        objectListing = s3.listObjectsV2(lor)

         /* FindIterable<Document> objectListing = s3.listObjectsV2(lor)

        MongoCursor<Document> cur = s3.listObjectsV2(lor)
        while (cur.hasNext()) {
            v++
            println cur.next();
        }*/
      println v

    }}