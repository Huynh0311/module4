package com.demospringmvc.service;

import com.demospringmvc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Connection connection = ConnectionToMySQL.getConnection();

    public ProductService() {
    }

    public void add(Product product) {
        String sql = "insert into product(name, price, img) value (?, ? ,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(int id) {
        for(Product product : getAll()){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public void edit(Product product){
        String sql = "update product set name = ?, price = ?, img = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getImg());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Product product){
        String sql = "delete from product where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> getAll(){
        List<Product> products1 = new ArrayList<>();
        String sql = "select * from product;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                products1.add(new Product(id, name, price, img));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products1;
    }
    public List<Product> findByName(String name){
        List<Product> products = new ArrayList<>();
        for (Product product : getAll()){
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                products.add(product);
            }
        }
        return products;
    }
}
