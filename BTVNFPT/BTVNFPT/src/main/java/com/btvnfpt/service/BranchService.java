package com.btvnfpt.service;

import com.btvnfpt.model.Branch;
import com.btvnfpt.model.Employee;
import com.btvnfpt.service.ICRUDService.ICRUDService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchService implements ICRUDService<Branch> {
    Connection connection = ConnectionToMySQL.getConnection();

    public Branch findById(int id){
        Branch branch = null;
        String sql = "select * from branch where idBranch = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idBranch = resultSet.getInt("idBranch");
                String nameBranch = resultSet.getString("nameBranch");
                branch = new Branch(idBranch, nameBranch);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return branch;
    }

    @Override
    public void add(Branch branch) {

    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }

    @Override
    public void edit(int id, Branch branch) {

    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Branch> getAll() {
        List<Branch> branches = new ArrayList<>();
        String sql = "select * from branch;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idBranch = resultSet.getInt("idBranch");
                String nameBranch = resultSet.getString("nameBranch");
                branches.add(new Branch(idBranch, nameBranch));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return branches;
    }
}
