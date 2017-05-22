package transmissioncosts

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@Rollback
@TestFor(ClientService)
@Mock([Client])
class ClientServiceSpec extends Specification {

    def "Test Extracting Data "(String line, Map shouldBeValid) {

        expect:

        service.extractData(line) == shouldBeValid
        where:
        line                                                                                                                                 | shouldBeValid
        ""                                                                                                                                   | null
        "2017-02-28\t10:57:48\tSIN2\t37436\t139.162.21.142\tGET\td243ovm80pkprt.cloudfront.net\t/50100029/LongTestIFP_13/50000199913/78635/" | [cost: 37436.0, cod: "50100029", day: new Date().parse('dd-MM-yyyy', "28-02-2017")]

    }


//
//}
//
//
//
    def "Test Search Transmission"() {
        given:
//       def r=["query":50100029, "day1": new Date().parse('dd-MM-yyyy', "20-07-2017"), "day1_day":4, "day1_month":5, "day1_year":2017, day2: DateTime.now().toDate(), "day2_day":31, "day2_month":5, "day2_year":2017, "_action_Search":"Search", "controller":"client2", "action3":"search", "max":5]

        //def Count = service.search(["query":454554, "day1": (new Date().parse('dd-MM-yyyy', "20-07-2017")),"day2":(new Date().parse('dd-MM-yyyy', "23-07-2017"))])

        //def Count=service.search(["query":50100029, "day1": DateTime.now().toDate(), "day1_day":4, "day1_month":5, "day1_year":2017, "day2": DateTime.now().toDate(), "day2_day":31, "day2_month":5, "day2_year":2017, "_action_Search":"Search", "controller":"client2", "action3":"search", "max":5])

        LinkedHashMap<String, String> params1 = new LinkedHashMap<String, Objects>()
        params1.put("query", 454554)
        params1.put("day1", new Date().parse('dd-MM-yyyy', "20-07-2017"))
        params1.put("day2", new Date().parse('dd-MM-yyyy', "23-07-2017"))

        LinkedHashMap<String, String> params2 = new LinkedHashMap<String, Objects>()
        params2.put("query", 454554)
        params2.put("day1", new Date().parse('dd-MM-yyyy', "20-07-2017"))
        params2.put("day2", new Date().parse('dd-MM-yyyy', "23-07-2017"))

        LinkedHashMap<String, String> params3 = new LinkedHashMap<String, Objects>()
        params3.put("query", 454554)
        params3.put("day1", new Date().parse('dd-MM-yyyy', "20-07-2017"))
        params3.put("day2", new Date().parse('dd-MM-yyyy', "23-07-2017"))

        LinkedHashMap<String, String> params4 = new LinkedHashMap<String, Objects>()
        params4.put("query", 454554)
        params4.put("day1", new Date().parse('dd-MM-yyyy', "20-07-2017"))
        params4.put("day2", new Date().parse('dd-MM-yyyy', "23-07-2017"))

        LinkedHashMap<String, String> params5 = new LinkedHashMap<String, Objects>()
        params5.put("query", 454554)
        params5.put("day1", new Date().parse('dd-MM-yyyy', "20-07-2017"))
        params5.put("day2", new Date().parse('dd-MM-yyyy', "23-07-2017"))



        def count = service.search(params5)
        expect:

        count.size() == 16
        println count
    }



            def  "test CientService "() {
            //Object query_,Object day_1,Object day_2, Integer shouldBeValid

     given :
    LinkedHashMap<String, Objects> params2 = new LinkedHashMap<String, Objects>()
            params2.put("query",454554)
            params2.put("day1",new Date().parse('dd-MM-yyyy', "20-07-2017") )
            params2.put("day2",new Date().parse('dd-MM-yyyy', "23-07-2017"))

        expect:
        def count=service.search(params2)

        count.size() == 16

//        where:
//        query_        ||  day_1         ||  day_2              || shouldBeValid
//        454554        || "20-07-2017"   ||   "23-07-2017"      ||    16



    }
//
//
}