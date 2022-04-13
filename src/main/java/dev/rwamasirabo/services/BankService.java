package dev.rwamasirabo.services;

import dev.rwamasirabo.entities.BankUser;

import java.util.List;

public interface BankService {
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
