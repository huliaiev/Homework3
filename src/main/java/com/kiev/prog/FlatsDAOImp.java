package com.kiev.prog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatsDAOImp implements FlatsDAO {

    private final Connection conn;

    public FlatsDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void init() {
        try {
            Statement st = conn.createStatement();
            try {
                st.execute("DROP TABLE IF EXISTS Flats");
                st.execute("CREATE TABLE Flats " +
                        "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(20) NOT NULL, adress VARCHAR(20) NOT NULL," +
                        "square DOUBLE , numberRooms INT, cost INT )");
            } finally {
                st.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addFlat(String district, String adress, double square, int numberRooms, int cost) {

        try {
            try (PreparedStatement st = conn
                    .prepareStatement("INSERT INTO Flats (district, adress, square, numberRooms, cost) VALUES(?, ?, ?, ?, ?)")) {
                st.setString(1, district);
                st.setString(2, adress);
                st.setDouble(3, square);
                st.setInt(4, numberRooms);
                st.setInt(5, cost);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //удаление по названию района
    @Override
    public void deleteFlat() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter district name: ");
        String district = sc.nextLine();


        PreparedStatement ps = conn.prepareStatement("DELETE FROM Flats WHERE district = ?");
        try {
            ps.setString(1, district);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    @Override
    public List<Flat> getAll() {
        List<Flat> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Flats")) {
                    while (rs.next()) {
                        Flat flat = new Flat();

                        flat.setId(rs.getInt(1));
                        flat.setDistrict(rs.getString(2));
                        flat.setAdress(rs.getString(3));
                        flat.setSquare(rs.getDouble(4));
                        flat.setNumberRooms(rs.getInt(5));
                        flat.setCost(rs.getInt(6));

                        res.add(flat);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
