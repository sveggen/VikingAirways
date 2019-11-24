package dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>
 */
/**
 * Data Access Object-interface
 * can be implemented by other DAO-classes.
 */
public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

}