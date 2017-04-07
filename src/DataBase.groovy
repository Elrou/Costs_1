import com.amazonaws.services.s3.model.ObjectListing
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

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

class Database {

    public static void main(String[] args) {
        def lst = []
        def clst = []



          MongoClient mongo = new MongoClient("localhost", 27017)
          def db = mongo.getDatabase("costs")
          MongoCollection<Document> collection = db.getCollection("Costs_Invoic")


          File Dir = new File("/Users/rbe/Desktop/Costs").eachFile {

          it.eachLine { String line ->
              if (line.startsWith("2")) {
                  lst = line.split()
                  clst = lst[7].split("/")
                 //  Long x= Long.parseLong(clst[1])
                   float y=Float.parseFloat(lst[3])
                  Document doc = new Document("Date", lst[0])
                    .append("time", lst[1])
                    .append("clientID", clst[1])
                    .append("sc_byte",y )
                  collection.insertOne(doc);
      }


        }


          }
    }
}


