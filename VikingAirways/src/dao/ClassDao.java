package dao;

import DBConnection.DBConnect;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object for all class related operations -
 * can be used by other classes to send queries to the DB.
 */
public class ClassDao implements Dao {

    DBConnect dbconnect = new DBConnect();

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

}
