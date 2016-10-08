package pl.marchuck.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
public class CustomerRestController {


    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    CustomerProtos.Customer customer(@PathVariable Integer id) {
        return this.customerRepository.findById(id);
    }


}
