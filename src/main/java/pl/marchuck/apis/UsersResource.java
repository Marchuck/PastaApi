package pl.marchuck.apis;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marchuck.model.Monster;
import pl.marchuck.model.User;
import rx.Observable;
import rx.Single;

import java.util.ArrayList;
import java.util.List;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 46
 */
@RestController
public class UsersResource {

    @RequestMapping(method = RequestMethod.GET,
            value = "/user",
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Single<User> getUser(@RequestParam("id") String id) {
        if (id.equals("12"))
            return Single.just(new User("Janusz", "Pawlacz", "today"));
        else
            return Single.just(new User("David", "X", "wczoraj"));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/user/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Single<User> createUser(@RequestBody User body, UriComponentsBuilder ucBuilder) {

        if (!users.contains(body)) return Single.just(body);
        return Single.just(new User());
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/{userId}/monsters",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<Monster> postMonsters(@PathVariable("userId") String id,
                                            @RequestBody List<Monster> monsters, UriComponentsBuilder ignored) {
        if (id.equals("0")) return Observable.from(monsters);
        else return Observable.from(new Monster[]{
                new Monster(),
                new Monster("Bulbasaur", "22", "345", "grass", "23-23-23", 10)
        });
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/{userId}/monsters",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<Monster> getMonsters(@PathVariable("userId") String id) {

        Monster m = new Monster("Pikachu", "0", id, "electric", "forest", 5);
        return Observable.range(1, 10)
                .map(integer -> m.deepCopy().withId(String.valueOf(integer)));

    }

    static List<User> users = new ArrayList<>();

}
