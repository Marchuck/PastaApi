package pl.marchuck.apis;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marchuck.sms.SimpleResponse;
import pl.marchuck.sms.SmsReceived;
import pl.marchuck.sms.SmsesCollection;
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
public class SmsResource {

    public static List<SmsReceived> receivedSmses = new ArrayList<>();

    static {
        receivedSmses.add(new SmsReceived(
                "testId", "nic", "997", "wczoraj"
        ));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/single/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Single<SimpleResponse> postSingleSms(@RequestBody SmsReceived body,
                                                UriComponentsBuilder ignored) {

        receivedSmses.add(body);

        return Single.just(new SimpleResponse("OK"));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/bulk/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Single<SimpleResponse> postManySmses(@RequestBody SmsesCollection body,
                                                UriComponentsBuilder ignored) {

        receivedSmses.addAll(body.getSmses());

        return Single.just(new SimpleResponse("OK"));
    }


    @RequestMapping(method = RequestMethod.GET,
            value = "/smses/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<SmsReceived> getManySmses() {


        return Observable.from(receivedSmses);

    }
}
