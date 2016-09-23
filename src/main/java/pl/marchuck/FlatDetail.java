package pl.marchuck;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 02 wrz 2016.
 * 18 : 11
 */
public class FlatDetail {
    private String detail;
    private String  price;
    private String description;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FlatDetail(String detail, String price, String description) {
        this.detail = detail;
        this.price = price;
        this.description = description;
    }

    public FlatDetail(String detail) {
        this.detail = detail;
    }
}
