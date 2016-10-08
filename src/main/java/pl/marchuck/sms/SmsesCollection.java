package pl.marchuck.sms;

import java.util.ArrayList;
import java.util.List;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 08 paź 2016.
 * 11 : 55
 */
public class SmsesCollection {
    private List<SmsReceived> smses = new ArrayList<>();

    public SmsesCollection(List<SmsReceived> smses) {
        this.smses = smses;
    }

    public SmsesCollection() {
    }

    public List<SmsReceived> getSmses() {
        return smses;
    }

    public void setSmses(List<SmsReceived> smses) {
        this.smses = smses;
    }
}

