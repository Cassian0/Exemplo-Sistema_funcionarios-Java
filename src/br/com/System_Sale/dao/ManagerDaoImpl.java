package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Manager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl extends EmployeeDaoImpl implements ManagerDao, Serializable {

    private Address address;
    private Manager manager;
    private List<Manager> dataManager;

    @Override
    public void save(Object object) throws SQLException, Exception {
        manager = (Manager) object;
        super.save(manager);
        String query = "INSERT INTO manager (numberBook, typeRole, idEmployee)"
                + " VALUES (?,?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, manager.getNumberBook());
            prepared.setString(2, manager.getTypeRole());
            prepared.setInt(3, manager.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR GERENTE " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }

    @Override
    public void change(Object object) throws SQLException {
        manager = (Manager) object;
        super.change(manager);
        String query = "UPDATE manager SET numberBook = ?, typeRole = ? WHERE idEmployee = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, manager.getNumberBook());
            prepared.setString(2, manager.getTypeRole());
            prepared.setInt(3, manager.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ALTERAR GERENTE " + e.getMessage());
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
        manager = new Manager();
        String query = "SELECT * FROM employee INNER JOIN manager ON employee.id = "
                + "manager.idEmployee INNER JOIN address ON address.idEmployee = "
                + "employee.id WHERE employee.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            manager.setId(result.getInt("manager.idEmployee"));
            manager.setName(result.getString("name"));
            manager.setType(result.getString("type"));
            manager.setEmail(result.getString("email"));
            manager.setPhone(result.getString("phone"));
            manager.setNumberBook(result.getString("numberBook"));
            manager.setTypeRole(result.getString("typeRole"));
            address = new Address();
            address.setId(result.getInt("address.id"));
            address.setRoad(result.getString("road"));
            address.setNeighborhood(result.getString("neighborhood"));
            address.setCity(result.getString("city"));
            address.setState(result.getString("state"));
            manager.setAddress(address);
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR GERENTE POR ID " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return manager;
    }

    @Override
    public List searchByName(String name) throws SQLException {
        dataManager = new ArrayList<>();
        String query = "SELECT * FROM employee INNER JOIN manager ON employee.id = "
                + "manager.idEmployee INNER JOIN address ON address.idEmployee = "
                + "employee.id WHERE name LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                manager = new Manager();
                manager.setId(result.getInt("manager.idEmployee"));
                manager.setName(result.getString("name"));
                manager.setType(result.getString("type"));
                manager.setEmail(result.getString("email"));
                manager.setPhone(result.getString("phone"));
                manager.setNumberBook(result.getString("numberBook"));
                manager.setTypeRole(result.getString("typeRole"));
                address = new Address();
                address.setId(result.getInt("address.id"));
                address.setRoad(result.getString("road"));
                address.setNeighborhood(result.getString("neighborhood"));
                address.setCity(result.getString("city"));
                address.setState(result.getString("state"));
                manager.setAddress(address);
                dataManager.add(manager);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR GERENTE POR NOME " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataManager;
    }
}
