package br.com.System_Sale.dao;

import java.sql.SQLException;

public interface BaseDao {

    /*
    CLASSE SERA UTILIZADA PARA IMPLEMENTAÇÃO DE TODAS AS ENTIDADES 
     */
    public abstract void save(Object object) throws SQLException, Exception;

    public abstract void change(Object object) throws SQLException;

    public abstract void delete(int id) throws SQLException;

    public abstract Object searchById(int id) throws SQLException;

}
