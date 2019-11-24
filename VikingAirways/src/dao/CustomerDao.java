package dao;

import java.util.List;
import java.util.Optional;

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
