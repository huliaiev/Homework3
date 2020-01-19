package com.kiev.prog;

import com.kiev.prog.*;
import com.kiev.prog.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb15?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        ConnectionFactory factory = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );

        Connection conn = factory.getConnection();
        try {
            FlatsDAO dao = new FlatsDAOImp(conn);
            dao.init();

            while (true) {
                System.out.println("1: add flat");
                System.out.println("2: delete flat");
                System.out.println("3: view flats");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter district: ");
                        String district = sc.nextLine();

                        System.out.print("Enter street: ");
                        String adress = sc.nextLine();

                        System.out.print("Enter square: ");
                        String Ssquare = sc.nextLine();

                        double square = Double.parseDouble(Ssquare);
                        System.out.print("Enter number rooms: ");
                        String SnumberRooms = sc.nextLine();
                        int numberRooms = Integer.parseInt(SnumberRooms);

                        System.out.print("Enter cost: ");
                        String Scost = sc.nextLine();
                        int cost = Integer.parseInt(Scost);

                        dao.addFlat(district, adress, square, numberRooms, cost);
                        break;

                    case "2":
                        dao.deleteFlat();
                        break;
                    case "3":
                        List<Flat> list = dao.getAll();
                        for (Flat client : list) {
                            System.out.println(client);
                        }
                        break;

                    default:
                        return;
                }
            }
        } finally {
            sc.close();
            if (conn != null) conn.close();
        }
    }
}
