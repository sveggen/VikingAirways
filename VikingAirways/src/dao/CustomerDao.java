package dao;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object for all customer related operations -
 * can be used by other classes to send queries to the DB.
 */
public class CustomerDao implements Dao {
    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }
}
