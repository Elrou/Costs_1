package transmissioncosts
import org.springframework.beans.factory.annotation.Autowired

class StoreDataJob {
    @Autowired
    ClientService clientService
    static triggers = {
        cron name: 'myTrigger', cronExpression: "0  29 11 ? * MON-SUN"
    }

    def execute() {
        clientService.serviceMethod()
    }
}
