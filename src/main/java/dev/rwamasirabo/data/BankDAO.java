package dev.rwamasirabo.data;

import dev.rwamasirabo.entities.BankUser;

import java.util.List;
// we are implementing our CRUD functionality througha Dao interface and this will house all our interfaces and services classes
// two class- level generics T: represents the actual class object to pass to and from database
// whereas I is the class od the entity's primary key.

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