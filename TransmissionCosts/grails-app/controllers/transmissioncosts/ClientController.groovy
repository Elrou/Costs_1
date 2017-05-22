package transmissioncosts

import org.joda.time.DateTime

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClientController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    ClientService clientService
    def index(){}
    def Search () {

        params.max = Math.min(params.max ? params.int('max') : 5, 100) 

                List<Client> clientList = clientService.search(params)
        def T = clientService.Total(clientList)
        respond  Total: T, clientInstanceList: clientList,clientInstanceTotal: clientList.totalCount, filterParams: params


            }




                      }