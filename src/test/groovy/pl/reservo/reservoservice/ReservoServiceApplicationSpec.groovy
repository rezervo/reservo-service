package pl.reservo.reservoservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class ReservoServiceApplicationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def 'Spring context should start'() {
        expect:
        context != null
        context.containsBean("reservoServiceApplication")
    }
}
