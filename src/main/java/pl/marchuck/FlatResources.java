package pl.marchuck;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 46
 */
@RestController
public class FlatResources {

    private static String findPropertyGreedy(Element element, String... properties) {
        Element rootElement = element;
        for (String s : properties) {
            Elements elements = rootElement.getElementsByClass(s);
            if (elements.size() > 0) {
                rootElement = elements.first();
            } else {
                return elements.get(0).text();
            }
        }

        return rootElement.text();
    }

    private static final String gumtree_base = "http://www.gumtree.pl/s-pokoje-do-wynajecia/krakow/v1c9000l3200208p";

    @RequestMapping(method = RequestMethod.GET, value = "/flat", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<List<FlatDetail>> getTopPastas() {
        return Observable.range(1, 3, Schedulers.io()
        ).flatMap(new Func1<Integer, Observable<Document>>() {
            @Override
            public Observable<Document> call(Integer integer) {
                return JsoupUtils.getJsoupDocument(gumtree_base + integer);
            }
        }).flatMap(new Func1<Document, Observable<Element>>() {
            @Override
            public Observable<Element> call(Document document) {
                Elements elements = document.select("container");
                return Observable.from(elements);
            }
        }).map(element -> {
            Elements element1 = element.getElementsByClass("href-link");
            String detail = "null";
            String price = "-1";
            if (element1 != null && element1.size() > 0) {
                price = findPropertyGreedy(element1.get(0), "info", "price", "value", "amount");
                detail = element1.text();
            }
            return new FlatDetail(detail, price, "null");
        }).toList();

    }
}
