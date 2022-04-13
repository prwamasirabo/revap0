package dev.rwamasirabo.daotests;

import dev.rwamasirabo.data.BankDAO;
import dev.rwamasirabo.data.BankDAOPostgresImpl;
import dev.rwamasirabo.entities.BankUser;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // to run test in order

public class BankDaoTests {
    static BankDAO bankDAO = new BankDAOPostgresImpl();
    static BankUser testbank = null;

    @Test
    @Order(1) // JUnit does not run tests in order by default
    void create_bankuser_test(){
        // An entity that is created but not yet saved should have an id of 0
        // once saved that book should be some non-zero value
        BankUser john = new BankUser(0,"John", "Smith", "john", "test1","pat@yahoo.com");
        BankUser savedBankuser = bankDAO.createBankUser(john);
        BankDaoTests.testbank = savedBankuser;// I have a bankuser  can use in other tests
        Assertions.assertNotEquals(0,savedBankuser.getId());
    }

    @Test
    @Order(2)
    void get_bankuser_by_id(){
        BankUser retrievedBook  = bankDAO.getBankUserById(testbank.getId());// use the id generated from the previous test
        // I have avoided hard coded values and made my test repeatable
        System.out.println(retrievedBook);
        Assertions.assertEquals("John", retrievedBook.getFirstName());
    }

    @Test
    @Order(3)
    void update_bankuser(){
        BankDaoTests.testbank.setFirstName( "John");
        bankDAO.updateBankUser(testbank);// the new title should be saved to the database
        BankUser retrievedBankUser = bankDAO.getBankUserById(testbank.getId());
        Assertions.assertEquals("John",retrievedBankUser.getFirstName());
    }

    @Test
    @Order(4)
    @Disabled // to not run something
    void delete_bankuser(){
        boolean result = bankDAO.deleteBankuserById(testbank.getId()); // true if successful
        Assertions.assertTrue(result);
    }

}
