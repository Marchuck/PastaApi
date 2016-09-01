package pl.marchuck;

/**
 * FirstSprintInitializer
 *
 * @author Lukasz Marczak
 * @since 01 wrz 2016.
 * 19 : 29
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
