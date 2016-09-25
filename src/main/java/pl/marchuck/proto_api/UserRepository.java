package pl.marchuck.proto_api;

import pl.marchuck.model.UserProtos;

/**
 * CrawlApi
 *
 * @author Lukasz Marczak
 * @since 25 wrz 2016.
 * 22 : 55
 */
public interface UserRepository {
   UserProtos.User getUserById(int id);
}