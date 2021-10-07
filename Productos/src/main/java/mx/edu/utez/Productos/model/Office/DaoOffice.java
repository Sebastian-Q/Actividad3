package mx.edu.utez.Productos.model.Office;

import mx.edu.utez.Productos.dateBase.ConnectionMySQL;
import mx.edu.utez.Productos.model.ProductLine.ProductLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOffice {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;
    String query;

    public List<Office> findAll() {
        List<Office> listOffice = new ArrayList();
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM offices;";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Office Oficina = new Office();
                Oficina.setOfficeCode(rs.getString("OfficeCode"));
                Oficina.setCity(rs.getString("City"));
                Oficina.setPhone(rs.getString("Phone"));
                Oficina.setAddressLine1(rs.getString("AddressLine1"));
                Oficina.setAddressLine2(rs.getString("AddressLine2"));
                Oficina.setState(rs.getString("State"));
                Oficina.setCountry(rs.getString("Country"));
                Oficina.setPostalCode(rs.getString("PostalCode"));
                Oficina.setTerritory(rs.getString("Territory"));
                listOffice.add(Oficina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return listOffice;
    }

    public Office findByOffice(String  officeCode) {
        Office Oficina = null;
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM offices WHERE officeCode = ? ;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, officeCode);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Oficina = new Office();
                Oficina.setOfficeCode(rs.getString("OfficeCode"));
                Oficina.setCity(rs.getString("City"));
                Oficina.setPhone(rs.getString("Phone"));
                Oficina.setAddressLine1(rs.getString("AddressLine1"));
                Oficina.setAddressLine2(rs.getString("AddressLine2"));
                Oficina.setState(rs.getString("State"));
                Oficina.setCountry(rs.getString("Country"));
                Oficina.setPostalCode(rs.getString("PostalCode"));
                Oficina.setTerritory(rs.getString("Territory"));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return Oficina;
    }

    public boolean saveOffices(Office oficina, boolean isCreated) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            if (isCreated) {
                query = "INSERT INTO offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) VALUES(?,?,?,?,?,?,?,?,?);";
                pstm = con.prepareStatement(query);
                pstm.setString(1, oficina.getOfficeCode());
                pstm.setString(2, oficina.getCity());
                pstm.setString(3, oficina.getPhone());
                pstm.setString(4, oficina.getAddressLine1());
                pstm.setString(5, oficina.getAddressLine2());
                pstm.setString(6, oficina.getState());
                pstm.setString(7, oficina.getCountry());
                pstm.setString(8, oficina.getPostalCode());
                pstm.setString(9, oficina.getTerritory());
                state = pstm.executeUpdate() == 1;
            } else {
                query = "UPDATE offices SET city = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ?, " +
                        "WHERE officeCode = ?;";
                pstm = con.prepareStatement(query);
                pstm.setString(9, oficina.getOfficeCode());
                pstm.setString(1, oficina.getCity());
                pstm.setString(2, oficina.getPhone());
                pstm.setString(3, oficina.getAddressLine1());
                pstm.setString(4, oficina.getAddressLine2());
                pstm.setString(5, oficina.getState());
                pstm.setString(6, oficina.getCountry());
                pstm.setString(7, oficina.getPostalCode());
                pstm.setString(8, oficina.getTerritory());
                state = pstm.executeUpdate() == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return state;
    }

    public boolean deleteOffice(String officeCode) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            query = "DELETE FROM offices WHERE officeCode = ?;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, officeCode);
            state = pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return state;
    }

    public void closeConnections() {
        try {
            if (con != null) {
                con.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
