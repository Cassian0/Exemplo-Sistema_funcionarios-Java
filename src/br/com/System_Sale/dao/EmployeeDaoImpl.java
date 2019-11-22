package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class EmployeeDaoImpl {

    protected Connection connection;
    protected PreparedStatement prepared;
    protected ResultSet result;
    private AddressDaoImpl addressDao;

    public void save(Employee employee) throws SQLException, Exception {
        String query = "INSERT INTO employee (name, type, email, phone) "
                + "VALUES (?, ?, ?, ?)";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, employee.getName());
            prepared.setString(2, employee.getType());
            prepared.setString(3, employee.getEmail());
            prepared.setString(4, employee.getPhone());
            prepared.executeUpdate();
            result = prepared.getGeneratedKeys();
            result.next();
            employee.setId(result.getInt(1));
            addressDao = new AddressDaoImpl();
            addressDao.save(employee.getAddress(), employee.getId(), connection, employee);

        } catch (Exception e) {
            System.out.println("ERRO AO SALVAR FUNCIONARIO " + e.getMessage());
        }
    }

    public void change(Employee employee) throws SQLException {
        String query = "UPDATE employee SET name = ?, type = ?, email = ?, phone = ? WHERE id = ? ";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, employee.getName());
            prepared.setString(2, employee.getType());
            prepared.setString(3, employee.getEmail());
            prepared.setString(4, employee.getPhone());
            prepared.setInt(5, employee.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR O FUNCIONARIO " + e.getMessage());
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM employee WHERE id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO DELETAR FUNCIONARIO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }
}
