package pl.marchuck;

import com.sun.xml.internal.xsom.impl.parser.DelayedRef;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 46
 */
@RestController
public class FlatResource {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    private static final String gumtree_base = "http://www.gumtree.pl/s-pokoje-do-wynajecia/krakow/v1c9000l3200208p";

    @RequestMapping(method = RequestMethod.GET, value = "/gumtree", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<List<FlatDetail>> getTopPastas() {
        return JsoupUtils.getJsoupDocument(gumtree_base + "1")
                .map(document -> document.getAllElements()
                        .stream()
                        .map(e -> new FlatDetail(e.text()))
                        .collect(Collectors.toList()));
//
//                .flatMap(new Func1<Document, Observable<Element>>() {
//                    @Override
//                    public Observable<Element> call(Document document) {
//                        Elements elements = document.select("container");
//                        return Observable.from(elements);
//                    }
//                })
//                .map(element -> {
//                    String detail = element.text();
//                    return new FlatDetail(detail, String.valueOf(atomicInteger.getAndIncrement()), "null");
//                }).toList().onErrorReturn(new Func1<Throwable, List<FlatDetail>>() {
//                    @Override
//                    public List<FlatDetail> call(Throwable throwable) {
//                        List<FlatDetail> list = new ArrayList<>();
//                        list.add(new FlatDetail(throwable.getMessage(), null, null));
//                        return list;
//                    }
//                });
    }
}
