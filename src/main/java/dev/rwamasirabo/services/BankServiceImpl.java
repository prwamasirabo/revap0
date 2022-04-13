package dev.rwamasirabo.services;

import dev.rwamasirabo.data.BankDAO;
import dev.rwamasirabo.entities.BankUser;

import java.util.List;

public class BankServiceImpl implements BankService {

    BankDAO bankdao;


    public BankServiceImpl(BankDAO bankdao) {
        this.bankdao = bankdao;

    }

    @Override
    public BankUser createBankUser(BankUser bank) {
        return this.bankdao.createBankUser(bank);
    }

    @Override
    public BankUser getBankUserById(int id) {
        return this.bankdao.getBankUserById(id);
    }

    @Override
    public List<BankUser> getAllBankusers() {
        return this.bankdao.getAllBankusers();
    }

    @Override
    public BankUser updateBankUser(BankUser bankUser) {
        return this.bankdao.updateBankUser(bankUser);
    }

    @Override
    public boolean deleteBankuserById(int id) {
        return this.bankdao.deleteBankuserById(id);
    }
}
