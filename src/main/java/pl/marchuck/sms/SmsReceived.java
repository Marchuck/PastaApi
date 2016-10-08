package pl.marchuck.sms;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 08 paź 2016.
 * 11 : 09
 */
public class SmsReceived {
    private String uuid;
    private String message;
    private String number;
    private String date;

    public SmsReceived() {
    }

    public SmsReceived(String uuid, String message, String number, String date) {
        this.uuid = uuid;
        this.message = message;
        this.number = number;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
