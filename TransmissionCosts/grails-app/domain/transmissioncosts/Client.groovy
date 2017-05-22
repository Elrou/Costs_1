package transmissioncosts

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class Client {
  String code
  long  costbyte
  Date datetime

    static constraints = {

       costbyte min: 0L
    }
}
