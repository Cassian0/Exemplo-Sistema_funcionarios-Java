package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDaoImpl implements AddressDao{

    protected PreparedStatement prepared;

    @Override
    public void save(Address address, int id, Connection connection, Object object) throws SQLException {
        String query = "INSERT INTO address (road, neighborhood, city, state, idEmployee) "
                + "VALUES (?,?,?,?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, address.getRoad());
            prepared.setString(2, address.getNeighborhood());
            prepared.setString(3, address.getCity());
            prepared.setString(4, address.getState());
            prepared.setInt(5, id);
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO GRAVAR ENDEREÇO " + e.getMessage());
        }

    }
}
