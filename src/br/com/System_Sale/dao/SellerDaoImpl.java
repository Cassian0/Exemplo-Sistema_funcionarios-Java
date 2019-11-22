package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Seller;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoImpl extends EmployeeDaoImpl implements SellerDao, Serializable {

    private Address address;
    private Seller seller;
    private List<Seller> dataSeller;

    @Override
    public void save(Object object) throws SQLException, Exception {
        seller = (Seller) object;
        super.save(seller);
        String query = "INSERT INTO seller (individualRegistration, identityDocument, idEmployee)"
                + "VALUES (?,?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, seller.getIndividualRegistration());
            prepared.setString(2, seller.getIdentityDocument());
            prepared.setInt(3, seller.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR VENDEDOR " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }

    @Override
    public void change(Object object) throws SQLException {
        seller = (Seller) object;
        super.change(seller);
        String query = "UPDATE seller SET individualRegistration = ?, identityDocument = ? "
                + "WHERE idEmployee = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, seller.getIndividualRegistration());
            prepared.setString(2, seller.getIdentityDocument());
            prepared.setInt(3, seller.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR VENDEDOR " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        super.delete(id);
    }

    @Override
    public Object searchById(int id) throws SQLException {
        seller = new Seller();
        String query = "SELECT * FROM employee INNER JOIN seller ON employee.id = "
                + "seller.idEmployee INNER JOIN address ON address.idEmployee = "
                + "employee.id WHERE employee.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            seller.setId(result.getInt("seller.idEmployee"));
            seller.setName(result.getString("name"));
            seller.setType(result.getString("type"));
            seller.setEmail(result.getString("email"));
            seller.setPhone(result.getString("phone"));
            seller.setIndividualRegistration(result.getString("individualRegistration"));
            seller.setIdentityDocument(result.getString("identityDocument"));
            address = new Address();
            address.setId(result.getInt("address.id"));
            address.setRoad(result.getString("road"));
            address.setNeighborhood(result.getString("neighborhood"));
            address.setCity(result.getString("city"));
            address.setState(result.getString("state"));
            seller.setAddress(address);
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR VENDEDOR POR ID: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
        return seller;
    }

    @Override
    public List searchByName(String name) throws SQLException {
        dataSeller = new ArrayList<>();
        String query = "SELECT * FROM employee INNER JOIN seller ON employee.id = "
                + "seller.idEmployee INNER JOIN address ON address.idEmployee = "
                + "employee.id WHERE name LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                seller = new Seller();
                seller.setId(result.getInt("seller.idEmployee"));
                seller.setName(result.getString("name"));
                seller.setType(result.getString("type"));
                seller.setEmail(result.getString("email"));
                seller.setPhone(result.getString("phone"));
                seller.setIndividualRegistration(result.getString("individualRegistration"));
                seller.setIdentityDocument(result.getString("identityDocument"));
                address = new Address();
                address.setId(result.getInt("address.id"));
                address.setRoad(result.getString("road"));
                address.setNeighborhood(result.getString("neighborhood"));
                address.setCity(result.getString("city"));
                address.setState(result.getString("state"));
                seller.setAddress(address);
                dataSeller.add(seller);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR VENDEDOR POR NOME " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataSeller;
    }
}
