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

public class EmployeeService implements ICRUDService<Employee> {
    Connection connection = ConnectionToMySQL.getConnection();
    BranchService branchService;
    @Override
    public void add(Employee employee) {
        String sql = "insert into employee(employeeCode, nameEmployee, age, img, salary, idBranch) value (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployeeCode());
            preparedStatement.setString(2, employee.getNameEmployee());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getImg());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getBranch().getIdBranch());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < getAll().size(); i++) {
                    if(getAll().get(i).getIdEmployee() == id){
                        return i;
                    }
        }
        return -1;
    }

    @Override
    public void edit(int id, Employee employee) {

    }

    @Override
    public void delete(int id) {
        String sql = "delete from employee where idEmployee = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        branchService = new BranchService();
        String sql = "select employee.*, branch.nameBranch from employee inner join branch on employee.idBranch = branch.idBranch;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idEmployee = resultSet.getInt("idEmployee");
                String employeeCode = resultSet.getString("employeeCode");
                String nameEmployee = resultSet.getString("nameEmployee");
                int age = resultSet.getInt("age");
                String img = resultSet.getString("img");
                int salary = resultSet.getInt("salary");
                int idBranch = resultSet.getInt("idBranch");
                String nameBranch = resultSet.getString("nameBranch");
                Branch branch = new Branch(idBranch, nameBranch);
                employees.add(new Employee(idEmployee, employeeCode, nameEmployee, age, img, salary, branch));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
