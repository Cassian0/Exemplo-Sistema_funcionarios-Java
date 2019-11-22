
package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import java.sql.Connection;
import java.sql.SQLException;


public interface AddressDao {
    
    public void save(Address address, int id, Connection connection, Object object) throws SQLException;
    
}
