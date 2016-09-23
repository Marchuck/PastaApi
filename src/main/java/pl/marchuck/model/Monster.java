package pl.marchuck.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 23 wrz 2016.
 * 18 : 29
 */
public class Monster {
    public String name;
    public String id;
    public String ownerId;
    public String kind;
    public String from;
    public int level;

    public Monster withId(String id) {
        this.id = id;
        return this;
    }

    public Monster() {
    }

    public Monster(String name, String id, String ownerId, String kind, String from, int level) {
        this.name = name;
        this.id = id;
        this.ownerId = ownerId;
        this.kind = kind;
        this.from = from;
        this.level = level;
    }

    public Monster deepCopy() {
        return new Monster(name, id, ownerId, kind, from, level);
    }
}
