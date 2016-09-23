package pl.marchuck.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 23 wrz 2016.
 * 18 : 28
 */

public class User {

    public String name;
    public String id;
    public String created;

    public User() {
    }

    public User(String name, String id, String created) {
        this.name = name;
        this.id = id;
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!id.equals(user.id)) return false;
        return created.equals(user.created);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + created.hashCode();
        return result;
    }
}
