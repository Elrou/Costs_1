package transmissioncosts

import grails.config.Config
import grails.core.GrailsApplication
import com.amazonaws.services.s3.model.ListObjectsV2Request
import com.amazonaws.services.s3.model.ListObjectsV2Result
import net.sf.ehcache.search.aggregator.Sum
import org.hibernate.criterion.Projection
import org.springframework.beans.factory.InitializingBean
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.S3ObjectSummary
import java.util.zip.GZIPInputStream
import grails.transaction.Transactional

@Transactional
class ClientService implements InitializingBean {

    String accessKey    // = "AKIAJPMYHNBCLQ7H743Q"
    String secretKey    // = "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"
    String bucketName
    String bucketPrefix
    AmazonS3 s3
    GrailsApplication grailsApplication

    def lst = [], clst = []
    int v = 0




    @Override
    void afterPropertiesSet () throws Exception {
        Config config = grailsApplication.config
        accessKey = config.getProperty("plugins.awssdk.accesskey", String, "AKIAJPMYHNBCLQ7H743Q")
        secretKey = config.getProperty("plugins.awssdk.secretkey", String, "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")
        bucketName = config.getProperty("app.s3.bucketName")
        bucketPrefix = config.getProperty("app.s3.bucketPrefix")

        s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey))

    }

    def serviceMethod () {

        ListObjectsV2Request lor = new ListObjectsV2Request().withBucketName(bucketName).withPrefix(bucketPrefix)
        ListObjectsV2Result objectListing = s3.listObjectsV2(lor)
        for (S3ObjectSummary summary : objectListing.getObjectSummaries()) {

            S3Object s3object = s3.getObject(new GetObjectRequest(bucketName, summary.getKey()))

            InputStream objectStream = s3object.getObjectContent()
            BufferedReader x = new BufferedReader(new InputStreamReader(new GZIPInputStream(objectStream)))



            String content
            while ((content = x.readLine()) != null) {
                content.eachLine { String line ->
                    def L = extractData(line)
                    if (L != null) {
                        saveDataLogFile(L)
                    }
                }
                lor.setContinuationToken(objectListing.getNextContinuationToken())

            }
            x.close()
        }
    }


    def saveDataLogFile (def L) {
        println("datetime": L.day, "code": L.cod, "costbyte": L.cost)

        Client c = new Client("datetime": L.day, "code": L.cod, "costbyte": L.cost)
        if (!c.validate()) {
            println c.hasErrors()
            println c.errors
        } else {
            println "Saving"
            c.save()
        }

    }

    def extractData (String line) {
        if (line.startsWith("2")) {
            lst = line.split()
            clst = lst[7].split("/")
            if ((clst.size() >= 3) && ('0123456789'.contains(clst[1][0]))) {
                 long c = Long.parseLong(clst[1])
                 float y = Float.parseFloat(lst[3])
                 def d = new Date().parse('yyyy-MM-dd', lst[0])
                println d
                 return [cost: y, cod: clst[1], day: d]

            }

        }

        return null
    }



       def Total (def L ) {
           def T = L.sum{it.costbyte}
           return T
           }


       def search(def params) {

                  def clientList = Client.createCriteria().list(params) {
                  if (params.query && params.day1 && params.day2) {
                      ilike("code", "%${params.query}%") && between("datetime", params.day1, params.day2)
                   }               }
                   return   clientList


              }



           }

