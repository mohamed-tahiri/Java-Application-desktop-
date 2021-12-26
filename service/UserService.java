/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.Connexion;
import dao.IDao;
import entities.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class UserService implements IDao<User>{

    @Override
    public boolean create(User u) {
        try {
            String req = "insert into user values (null, ?, ?, ?, ?)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, u.getFullname());
            pr.setString(2, u.getEmail());
            pr.setString(3, u.getSecret());
            pr.setString(4, u.getPassword());
            if (pr.executeUpdate() == 1)
                    return true;
        } catch (SQLException e) {
                System.out.println("Create :: User : Erreur");
        }
        return false;
    }

    @Override
    public boolean update(User u) {
        try {
            String req = "update user set password = ? where secret = ? ";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, u.getPassword());
            pr.setString(2, u.getSecret());

            if (pr.executeUpdate() == 1)
                        return true;
        } catch (SQLException e) {
                System.out.println("Update :: User : Erreur");
        }
        return false;
    }

    @Override
    public boolean delete(User u) {
        try {
            String req = "delete from  user where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, u.getId());
            if (pr.executeUpdate() == 1)
                    return true;
        } catch (SQLException e) {
                System.out.println("Delete :: User : Erreur");
        }
        return false;
    }

    @Override
    public User findById(int id) {
        try {
            String req = "select * from user where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id") , rs.getString("fullname"), rs.getString("email"), rs.getString("secret"), rs.getString("password"));
            }

        } catch (SQLException e) {
                System.out.println("Erreur :: User : FindById");
        }

        return null;
    }
    
    public User findUserEmail(String email) {
        try {
            String req = "select * from user where email  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, email);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id") , rs.getString("fullname"), rs.getString("email"), rs.getString("secret"), rs.getString("password"));
            }
        } catch (SQLException e) {
                System.out.println("Erreur :: User : FindUserEmail ");
        }

        return null;
    }
    

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            String req = "select * from user";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                    users.add(new User( rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("secret"),rs.getString("password") ));
            }

        } catch (SQLException e) {
                System.out.println("Erreur :: User : findAll");
        }

        return users;
    }
    
}
