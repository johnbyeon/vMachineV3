package DAO;

import java.util.List;

public class CreditCardDAO implements CrudInterface{
    @Override
    public int insert(Object object) {
        return 0;
    }

    @Override
    public int update(Object object) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Object> getListAll() {
        return List.of();
    }

    @Override
    public Object getOne(Long id) {
        return null;
    }

    @Override
    public Object getOne(String id) {
        return null;
    }

    @Override
    public List<Object> searchKeyword(int num, String keyword) {
        return List.of();
    }
}
