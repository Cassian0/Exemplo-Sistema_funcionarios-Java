/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Manager;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cassiano
 */
public class ManagerDaoImplTest {

    private Manager manager;
    private ManagerDao managerDao;
    private List<Manager> dataManager;
    private Address address;

    public ManagerDaoImplTest() {
        managerDao = new ManagerDaoImpl();

    }

    //@Test
    public void testSave() throws Exception {
        System.out.println("salvar");
        manager = new Manager("test", "test", null, "test", "test", "test", "test");
        address = new Address(null, "test", "test", "test", "test");
        manager.setAddress(address);
        managerDao.save(manager);

    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("alterar");
        int id = 7;
        manager = new Manager("test2", "test2", id, "test2", "test2", "test2", "test2");
        managerDao.change(manager);

    }

    //@Test
    public void testDelete() throws Exception {
        System.out.println("deletar");
        int id = 8;
        managerDao.delete(id);

    }

    //@Test
    public void testSearchById() throws Exception {
        System.out.println("pesquisar por ID");
        int id = 2;
        manager = (Manager) managerDao.searchById(id);
        System.out.println("ID: " + manager.getId());
        System.out.println("Nome: " + manager.getName());
        System.out.println("Email: " + manager.getEmail());
        System.out.println("Tipo: " + manager.getType());
        System.out.println("Telefone: " + manager.getPhone());
        System.out.println("Nº notebook: " + manager.getNumberBook());
        System.out.println("Tipo do Cargo: " + manager.getTypeRole());
        System.out.println("ID endereço: " + manager.getAddress().getId());
        System.out.println("Rua: " + manager.getAddress().getRoad());
        System.out.println("Bairro: " + manager.getAddress().getNeighborhood());
        System.out.println("Cidade: " + manager.getAddress().getCity());
        System.out.println("Estado: " + manager.getAddress().getState());

    }

    //@Test
    public void testSearchByName() throws Exception {
        System.out.println("pesquisar por nome");
        String name = "t";
        dataManager = managerDao.searchByName(name);
        for (Manager manager1 : dataManager) {
            System.out.println("ID: " + manager1.getId());
            System.out.println("Nome: " + manager1.getName());
            System.out.println("Email: " + manager1.getEmail());
            System.out.println("Tipo: " + manager1.getType());
            System.out.println("Telefone: " + manager1.getPhone());
            System.out.println("Nº notebook: " + manager1.getNumberBook());
            System.out.println("Tipo do Cargo: " + manager1.getTypeRole());
            System.out.println("ID endereço: " + manager1.getAddress().getId());
            System.out.println("Rua: " + manager1.getAddress().getRoad());
            System.out.println("Bairro: " + manager1.getAddress().getNeighborhood());
            System.out.println("Cidade: " + manager1.getAddress().getCity());
            System.out.println("Estado: " + manager1.getAddress().getState());
            System.out.println();

        }

    }

}
