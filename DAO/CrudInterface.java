package DAO;

import java.util.List;

public interface CrudInterface {
    // 입력
    int insert(Object object);
    // 수정
    int update(Object object);
    // 삭제
    int delete(Long id);
    // 전체검색
    List<Object> getListAll();
    // 단일레코드 검색
    Object getOne(Long num);
    Object getOne(String id);
    List<Object> searchKeyword(int num, String keyword);
}
