package pl.marchuck.proto_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marchuck.model.UserProtos;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 25 wrz 2016.
 * 22 : 54
 */
@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/customers/{id}")
    UserProtos.User customer(@PathVariable Integer id) {
        return this.userRepository.getUserById(id);
    }
}

