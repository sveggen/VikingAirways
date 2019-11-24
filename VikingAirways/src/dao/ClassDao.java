package dao;

import DBConnection.DBConnect;

import java.util.List;
import java.util.Optional;

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
