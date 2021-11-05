package com.company;

import java.util.Scanner;
import java.sql.*;


public class DatabaseGroup3 {
    static final String DB_URL = "jdbc:mysql://group3database.ckfcq92zr1jy.eu-west-2.rds.amazonaws.com/Group3?characterEncoding=utf8";
    static final String USER = "admin";
    static final String PASS = "Group3database";
    static Connection conn = null;
    static Statement stmt = null;


    public static void insertExample() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the brand name of the bag: ");
        String brand = input.next();
        System.out.println("Enter the type of the bag: ");
        String type = input.next();
        System.out.println("Enter the material of the bag: ");
        String material = input.next();
        System.out.println("Enter the colour of the bag: ");
        String colour = input.next();
    }


    public static void insertWithValue(String brand, String type, String material,
                                       String colour) throws SQLException {


        String sql = "INSERT INTO Bags(Brand,Type,Material,Colour) VALUES ('" + brand + "','" + type + "','" + material + "','" + colour + "')";
        //  System.out.println("Inserted: " + stmt.execute(sql));
        stmt.execute(sql);
    }

    public static void main(String[] args) {
        try {
            //Return connection instance
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");

            //Create statement object
            stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the brand name of the bag: ");
            String brand = input.next();
            System.out.println("Enter the type of the bag: ");
            String type = input.next();
            System.out.println("Enter the material of the bag: ");
            String material = input.next();
            System.out.println("Enter the colour of the bag: ");
            String colour = input.next();


            insertWithValue(brand, type, material, colour);

        } catch (SQLException sqlException) {
            System.out.println("Error:" + sqlException.getMessage());
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
    }


}
