package mx.edu.utez.Productos.model.Products;

import mx.edu.utez.Productos.dateBase.ConnectionMySQL;
import mx.edu.utez.Productos.model.Products.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProducts {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;
    String query;

    public List<Products> findAll() {
        List<Products> listProducts = new ArrayList();
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM products;";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Products product = new Products();
                product.setProductCode(rs.getString("ProductCode"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductLine(rs.getString("ProductLine"));
                product.setProductScale(rs.getString("ProductScale"));
                product.setProductVendor(rs.getString("ProductVendor"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setQuantityInStock(rs.getInt("QuantityInStock"));
                product.setBuyPrice(rs.getDouble("BuyPrice"));
                product.setMSRP(rs.getDouble("MSRP"));
                listProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return listProducts;
    }

    public Products findByProductCode(String  productCode) {
        Products product = null;
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM products WHERE productCode = ?;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, productCode);
            rs = pstm.executeQuery();
            if (rs.next()) {
                product = new Products();
                product.setProductCode(rs.getString("ProductCode"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductLine(rs.getString("ProductLine"));
                product.setProductScale(rs.getString("ProductScale"));
                product.setProductVendor(rs.getString("ProductVendor"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setQuantityInStock(rs.getInt("QuantityInStock"));
                product.setBuyPrice(rs.getDouble("BuyPrice"));
                product.setMSRP(rs.getDouble("MSRP"));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return product;
    }


    public boolean saveProducts(Products product, boolean isCreated) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            if (isCreated) {
                query = "INSERT INTO products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock," +
                        "buyPrice, MSRP) VALUES(?,?,?,?,?,?,?,?,?);";
                pstm = con.prepareStatement(query);
                pstm.setString(1, product.getProductCode());
                pstm.setString(2, product.getProductName());
                pstm.setString(3,product.getProductLine());
                pstm.setString(4, product.getProductScale());
                pstm.setString(5, product.getProductVendor());
                pstm.setString(6, product.getProductDescription());
                pstm.setInt(7, product.getQuantityInStock());
                pstm.setDouble(8, product.getBuyPrice());
                pstm.setDouble(9, product.getMSRP());
                state = pstm.executeUpdate() == 1;
            } else {
                query = "UPDATE products SET productName = ?, productLine = ?, productScale = ?, productVendor = ?, productDescription = ?, " +
                        "quantityInStock = ?, buyPrice = ?, MSRP = ? WHERE productCode = ?;";
                pstm = con.prepareStatement(query);
                pstm.setString(9, product.getProductCode());
                pstm.setString(1, product.getProductName());
                pstm.setString(2,product.getProductLine());
                pstm.setString(3, product.getProductScale());
                pstm.setString(4, product.getProductVendor());
                pstm.setString(5, product.getProductDescription());
                pstm.setInt(6, product.getQuantityInStock());
                pstm.setDouble(7, product.getBuyPrice());
                pstm.setDouble(8, product.getMSRP());
                state = pstm.executeUpdate() == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return state;
    }

    public boolean deleteProducts(String productCode) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            query = "DELETE FROM products WHERE productCode = ?;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, productCode);
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
