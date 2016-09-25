package pl.marchuck.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers/{id}")
    CustomerProtos.Customer customer(@PathVariable Integer id) {
        return this.customerRepository.findById(id);
    }
}
