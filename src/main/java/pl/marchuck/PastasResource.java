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
public class PastasResource {
    private static final String endpoint = "https://vichan.net/pasty/top150";

    @RequestMapping(method = RequestMethod.GET, value = "/pastas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<List<SinglePasta>> getTopPastas() {
        return Observable.just(true)
                .subscribeOn(Schedulers.trampoline())
                .flatMap(new Func1<Boolean, Observable<Document>>() {
                    @Override
                    public Observable<Document> call(Boolean aBoolean) {
                        return JsoupUtils.getJsoupDocument(endpoint);
                    }
                }).flatMap(new Func1<Document, Observable<Element>>() {
                    @Override
                    public Observable<Element> call(Document document) {
                        Elements elements = document.getElementsByClass("quote_output");
                        return Observable.from(elements);
                    }
                }).map(element -> new SinglePasta(element.text()))
                .toList();
    }
}
