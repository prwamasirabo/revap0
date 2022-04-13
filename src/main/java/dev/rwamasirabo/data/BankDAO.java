package dev.rwamasirabo.data;

import dev.rwamasirabo.entities.BankUser;

import java.util.List;
// we are implementing our CRUD functionality through Dao interface and this will house all our interfaces and services classes


public interface BankDAO {
    // Create
    BankUser createBankUser(BankUser bank);

    // Read
    BankUser getBankUserById(int id);
    List<BankUser> getAllBankusers();

    //Update
    BankUser updateBankUser(BankUser bankUser);

    //Delete
    boolean deleteBankuserById(int id);

}