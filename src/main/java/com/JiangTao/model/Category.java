package com.JiangTao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int CategoryId;
    private String CategoryName;
    private String Description;
    private Boolean Active;

    public  Category(){}


    public Category(int categoryId, String categoryName, String description, Boolean active) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        Description = description;
        Active = active;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Active=" + Active +
                '}';
    }
    public static List<Category> findAllCategory(Connection con){
        List<Category> list=new ArrayList<Category>();
        String queryString="select * from Category";
        try {
            PreparedStatement statement=con.prepareStatement(queryString);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Category category=new Category();
                category.setCategoryId(resultSet.getInt("CategoryId"));
                category.setCategoryName(resultSet.getNString("CategoryName"));
                category.setDescription(resultSet.getNString("Description"));
                category.setActive(resultSet.getBoolean("Active"));
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static String findByCategoryId(Connection con,int categoryId){
        String categoryName=null;
        String sql="select CategoryName from Category where categoryId=?";
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setInt(1,categoryId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                categoryName=resultSet.getNString("categoryName");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryName;
    }

}
