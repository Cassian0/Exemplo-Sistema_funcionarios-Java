package br.com.System_Sale.dao;

import br.com.System_Sale.model.Address;
import br.com.System_Sale.model.Seller;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SellerDaoImplTest {

    private Seller seller;
    private SellerDao sellerDao;
    private List<Seller> dataSeller;
    private Address address;

    public SellerDaoImplTest() {
        sellerDao = new SellerDaoImpl();
    }

    //@Test
    public void testSave() throws Exception {
        System.out.println("Salvar");
        seller = new Seller("Seller", "Test", null, "Seller", "Test", "Sellert", "Test");
        address = new Address(null, "SellerAdd", "SellerAdd", "SellerAdd", "SellerAdd");
        seller.setAddress(address);
        sellerDao.save(seller);

    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("Alterar");
        int id = 10;
        seller = new Seller("NewSeller", "NewSeller", id, "NewSeller", "NewSeller", "NewSeller", "NewSeller");
        sellerDao.change(seller);
    }

    //@Test
    public void testDelete() throws Exception {
        System.out.println("deletar");
        int id = 4;
        sellerDao.delete(id);
    }

    //@Test
    public void testSearchById() throws Exception {
        System.out.println("pesquisar por ID");
        int id = 9;
        seller = (Seller) sellerDao.searchById(id);
        System.out.println("ID: " + seller.getId());
        System.out.println("Nome: " + seller.getName());
        System.out.println("Email: " + seller.getEmail());
        System.out.println("Tipo: " + seller.getType());
        System.out.println("Telefone: " + seller.getPhone());
        System.out.println("CPF: " + seller.getIndividualRegistration());
        System.out.println("RG: " + seller.getIdentityDocument());
        System.out.println("ID endereço: " + seller.getAddress().getId());
        System.out.println("Rua: " + seller.getAddress().getRoad());
        System.out.println("Bairro: " + seller.getAddress().getNeighborhood());
        System.out.println("Cidade: " + seller.getAddress().getCity());
        System.out.println("Estado: " + seller.getAddress().getState());

    }

    //@Test
    public void testSearchByName() throws Exception {
        System.out.println("pesquisar por Nome");
        String name = "e";
        dataSeller = sellerDao.searchByName(name);
        for (Seller seller1 : dataSeller) {
            System.out.println("ID: " + seller1.getId());
            System.out.println("Nome: " + seller1.getName());
            System.out.println("Email: " + seller1.getEmail());
            System.out.println("Tipo: " + seller1.getType());
            System.out.println("Telefone: " + seller1.getPhone());
            System.out.println("CPF: " + seller1.getIndividualRegistration());
            System.out.println("RG: " + seller1.getIdentityDocument());
            System.out.println("ID endereço: " + seller1.getAddress().getId());
            System.out.println("Rua: " + seller1.getAddress().getRoad());
            System.out.println("Bairro: " + seller1.getAddress().getNeighborhood());
            System.out.println("Cidade: " + seller1.getAddress().getCity());
            System.out.println("Estado: " + seller1.getAddress().getState());
            System.out.println();

        }
    }

}
