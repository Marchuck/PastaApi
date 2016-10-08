package pl.marchuck.sms;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 08 paź 2016.
 * 11 : 10
 */
public class SimpleResponse {
    private String status;

    public SimpleResponse() {
    }

    public SimpleResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return status;
    }
}
