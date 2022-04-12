package dev.rwamasirabo.data;

import dev.rwamasirabo.entities.BankUser;
import dev.rwamasirabo.utilities.Listtest;
import dev.rwamasirabo.utilities.jdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankDAOPostgresImpl implements BankDAO{

    @Override
    public BankUser createBankUser (BankUser bankUser){
        try {
            Connection conn = jdbcConnection.getConnection();
            String sql = "insert into bankuser values (default,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bankUser.getFirstName());
            ps.setString(2, bankUser.getLastName());
            ps.setString(4, bankUser.getUserName());
            ps.setString(3, bankUser.getPassword());
            ps.setString(4, bankUser.getEmail());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedIDd = rs.getInt( "bankuser_id");
            bankUser.setId(generatedIDd);
            return bankUser;
        } catch (SQLException e) {
            e.printStackTrace();
      //      Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
   }
   @Override

    public BankUser getBankUserById(int id) {

        try {
            Connection conn = jdbcConnection.getConnection();
            String sql = "select * from bankuser where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next(); // move to first record
            BankUser bank = new BankUser();
            bank.setId(rs.getInt("user_id"));
            bank.setFirstName(rs.getString("first_name"));
            bank.setLastName(rs.getString("last_name"));
            bank.setUserName(rs.getString("user_name"));
            bank.setPassword(rs.getString("password"));
            bank.setEmail(rs.getString("email"));


            return bank;

        } catch (SQLException e) {
            e.printStackTrace();
         //   Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }

    }

    @Override
    public List<BankUser> getAllBankusers() {
        try {
            Connection conn = jdbcConnection.getConnection();
            String sql = "select * from bankusers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

           // List<BankUser> bankusers = new ArrayList()<> ;
            List<BankUser> bankusers = new ArrayList();
            while (rs.next()){
                BankUser bank = new BankUser();
                bank.setId(rs.getInt("user_id"));
                bank.setFirstName(rs.getString("first_name"));
                bank.setLastName(rs.getString("last_name"));
                bank.setUserName(rs.getString("user_name"));
                bank.setPassword(rs.getString("password"));
                bank.setEmail(rs.getString("email"));
                bankusers.add(bank);
            }

            return bankusers;

        } catch (SQLException e) {
            e.printStackTrace();
          //  Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public BankUser updateBankUser(BankUser bankuser) {

        try {
            Connection conn = jdbcConnection.getConnection();
            String sql = "update bankuser set first_name= ?, last_name = ?, user_name = ?,password = ?, email =? , where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bankuser.getFirstName());
            ps.setString(2, bankuser.getLastName());
            ps.setString(3, bankuser.getUserName());
            ps.setString(4,bankuser.getPassword());
            ps.setString(5,bankuser.getEmail());
            ps.setInt(6, bankuser.getId());
            ps.executeUpdate();
            return  bankuser;

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public boolean deleteBankuserById(int id) {

        try {
            Connection conn = jdbcConnection.getConnection();
            String sql = "delete from bankuser where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}