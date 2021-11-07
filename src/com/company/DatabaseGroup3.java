package com.company;

import java.util.Scanner;
import java.sql.*;


public class DatabaseGroup3 {
    static final String DB_URL = "jdbc:mysql://group3database.ckfcq92zr1jy.eu-west-2.rds.amazonaws.com/Group3?characterEncoding=utf8";
    static final String USER = "admin";
    static final String PASS = "Group3database";
    static Connection conn = null;
    static Statement stmt = null;

    public static void insertWithValue(String brand, String type, String material,
                                       String colour) throws SQLException {


        String sql = "INSERT INTO Bags(Brand,Type,Material,Colour) VALUES ('" + brand + "','" + type + "','" + material + "','" + colour + "')";

        stmt.execute(sql);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");

            stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);
            String continuation;
            do {
                System.out.println("Enter the brand name of the bag: ");
                String brand = input.next();
                System.out.println("Enter the type of the bag: ");
                String type = input.next();
                System.out.println("Enter the material of the bag: ");
                String material = input.next();
                System.out.println("Enter the colour of the bag: ");
                String colour = input.next();
                System.out.println("Would you like to enter another bag into database? y/n");
                continuation = input.next();

                insertWithValue(brand, type, material, colour);

            }while (continuation.equalsIgnoreCase("y"));

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
