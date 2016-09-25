package pl.marchuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import pl.marchuck.customer.CustomerProtos;
import pl.marchuck.customer.CustomerRepository;
import pl.marchuck.model.UserProtos;
import pl.marchuck.proto_api.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@SpringBootApplication
public class CrawlApiApplication {

    public static void main(String[] args) {

        // Tell Boot to look for registration-server.yml
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(CrawlApiApplication.class, args);
    }


    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    private CustomerProtos.Customer customer(int id, String f, String l, Collection<String> emails) {
        Collection<CustomerProtos.Customer.EmailAddress> emailAddresses =
                emails.stream().map(e -> CustomerProtos.Customer.EmailAddress.newBuilder()
                        .setType(CustomerProtos.Customer.EmailType.PROFESSIONAL)
                        .setEmail(e).build())
                        .collect(Collectors.toList());

        return CustomerProtos.Customer.newBuilder()
                .setFirstName(f)
                .setLastName(l)
                .setId(id)
                .addAllEmail(emailAddresses)
                .build();
    }

    private UserProtos.User user(int id, String f, String l, Collection<String> emails) {
        Collection<UserProtos.User.Monster> monsters =
                emails.stream().map(e -> UserProtos.User.Monster.newBuilder()
                        .setName(e)
                        .setId(e.length()).build())
                        .collect(Collectors.toList());

        return UserProtos.User.newBuilder()
                .setFirstName(f)
                .setLastName(l)
                .setId(id)
                .addAllMonsters(monsters)
                .build();
    }

    @Bean
    CustomerRepository customerRepository() {
        Map<Integer, CustomerProtos.Customer> customers = new ConcurrentHashMap<>();
        // populate with some dummy data
        Arrays.asList(
                customer(1, "Chris", "Richardson", Arrays.asList("crichardson@email.com")),
                customer(2, "Josh", "Long", Arrays.asList("jlong@email.com")),
                customer(3, "Matt", "Stine", Arrays.asList("mstine@email.com")),
                customer(4, "Russ", "Miles", Arrays.asList("rmiles@email.com"))
        ).forEach(c -> customers.put(c.getId(), c));

        // our lambda just gets forwarded to Map#get(Integer)
        return customers::get;
    }

    @Bean
    UserRepository userRepository() {
        Map<Integer, UserProtos.User> users = new ConcurrentHashMap<Integer, UserProtos.User>();
        // populate with some dummy data
        Arrays.asList(
                user(1, "Chris", "Richardson", Arrays.asList("crichardson@email.com")),
                user(2, "Josh", "Long", Arrays.asList("jlong@email.com")),
                user(3, "Matt", "Stine", Arrays.asList("mstine@email.com")),
                user(4, "Russ", "Miles", Arrays.asList("rmiles@email.com"))
        ).forEach(c -> users.put(c.getId(), c));

        return users::get;
    }

}
