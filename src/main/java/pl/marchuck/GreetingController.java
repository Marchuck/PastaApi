package pl.marchuck;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 30
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="man!!") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
