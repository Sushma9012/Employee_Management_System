package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImp implements EmployeeDaoInterface{
    Connection con;

    @Override
    public void createEmployee(Employee emps) {
        con = DBConnection.createDBConnection();
        String query="insert into employeeapp values(?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emps.getId());
            pstm.setString(2,emps.getName());
            pstm.setDouble(3,emps.getSalary());
            pstm.setInt(4,emps.getAge());
            int cnt = pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee Inserted Successfully!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "select * from employeeapp";
        System.out.println("Employee Details : ");
        System.out.println("-------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        System.out.println("-------------------------------------");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("-------------------------------------");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from employeeapp where id="+id;
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employeeapp set name=? where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee Details updated successfully!!!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from employeeapp where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee Deleted Successfully"+id);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
