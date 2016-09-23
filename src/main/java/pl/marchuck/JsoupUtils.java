package pl.marchuck;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 49
 */
public class JsoupUtils {

    public static rx.Observable<Document> getJsoupDocument(final String url) {
        return rx.Observable.create(new rx.Observable.OnSubscribe<Document>() {
            @Override
            public void call(Subscriber<? super Document> subscriber) {
                Document document = null;
                try {
                    if (url.contains("vichan")) System.setProperty("javax.net.ssl.trustStore", "vichan.net.jks");
                    document = Jsoup.connect(url).get();
                } catch (Exception ignored) {
                    subscriber.onError(ignored);
                }
                subscriber.onNext(document);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }
}
