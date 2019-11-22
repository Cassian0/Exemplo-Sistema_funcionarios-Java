package br.com.System_Sale.dao;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends BaseDao {

    public abstract List searchByName(String name) throws SQLException;

}
