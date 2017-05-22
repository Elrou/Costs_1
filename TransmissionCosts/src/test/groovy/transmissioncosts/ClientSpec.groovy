package transmissioncosts

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Client)
class ClientSpec extends Specification {

   def setup() {
        //mockDomain(Client, [new Client(code: '50100016')])
        //mock a Client with some data (put unique violations in here so they can be tested, the others aren't needed)

    }

    @Unroll('validate on a Client with costbyte#CostByteClient should have returned #shouldBeValid')

    def "test Client Costbyte"() {

            expect:
            new Client(costbyte: CostByteClient ).validate(['costbyte']) == shouldBeValid

            where:
            CostByteClient  | shouldBeValid
            0               | true
            1               | true
            -5              | false
            -10             | false

        }
    @Unroll('validate on a Client with code #code should have returned #valid')
    def "test Client code "() {

        expect:
        new Client( code: code  ).validate(['code']) == valid
        where:

        code            | valid
        " "             |false
    }




        /*void 'test code cannot be null'() {
        when:
        domain.code = null

        then:
        !domain.validate(['code'])
        domain.errors['code'].code == 'nullable'
    }

    void 'test code cannot be blank'() {
        when:
        domain.code = ''

        then:
        !domain.validate(['code'])
    }

    void 'test code can have a maximum of 255 characters' (){
        when: 'for a string of 256 characters'
        String str = 'a' * 256
        domain.code = str

        then: 'code validation fails'
        !domain.validate(['code'])
        domain.errors['code'].code == 'maxSize.exceeded'

        when: 'for a string of 256 characters'
        str = 'a' * 255
        domain.code = str

        then: 'code validation passes'
        domain.validate(['code'])
    }
*/
        }



