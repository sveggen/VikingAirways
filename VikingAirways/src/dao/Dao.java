package dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>
 */
public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

}