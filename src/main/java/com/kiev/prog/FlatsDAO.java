package com.kiev.prog;

import java.sql.SQLException;
import java.util.List;

public interface FlatsDAO {
        void init();
        void addFlat(String district, String adress, double square, int numberRooms, int cost);
        void deleteFlat() throws SQLException;
        List<Flat> getAll();
    }





