package transmissioncosts

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.*

import org.grails.datastore.mapping.query.Projections

@Transactional
@Integration
@TestFor(ClientService)
class ClientIntegrationSpec extends Specification {


    def setup () {
    }

    def cleanup () {
    }

    def " Test SaveDataLogFile " () {
        given:
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "20-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "20-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "20-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "20-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "20-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "27-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "27-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "27-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "21-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "22-07-2017"), "cod": 454554, "cost": 9948])
        service.saveDataLogFile(["day": new Date().parse('dd-MM-yyyy', "23-07-2018"), "cod": 454, "cost": 9999848])


        expect:

          Client.count== 11

    }



     def  "test CientService "(Object query_,Object day_1,Object day_2, Integer shouldBeValid) {

         given:
         LinkedHashMap<String, Objects> params2 = new LinkedHashMap<String, Objects>()
         params2.put("query", query_)
         params2.put("day1", new Date().parse('dd-MM-yyyy', day_1))
         params2.put("day2", new Date().parse('dd-MM-yyyy', day_2))

         expect:
         def count = service.search(params2)

         count.size() == shouldBeValid
         println count

         where:
         query_ || day_1        || day_2        || shouldBeValid
         454554 || "15-07-2017" || "27-07-2017" || 10
         454554 || "20-07-2017" || "27-07-2017" || 10
         454554 || "20-07-2017" || "31-07-2017" || 10
         454554 || "21-07-2017" || "25-07-2017" || 2
         454554 || "15-07-2017" || "31-08-2017" || 10
         454554 || "28-07-2017" || "31-07-2017" || 0
         454554 || "23-07-2017" || "25-07-2017" || 0





     }

}