package mx.edu.utez.Productos.model.ProductLine;

import mx.edu.utez.Productos.dateBase.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProductLine {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stm;
    String query;

    public List<ProductLine> findAll() {
        List<ProductLine> listProductLine = new ArrayList();
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM productlines;";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                ProductLine productLi = new ProductLine();
                productLi.setProductLine(rs.getString("ProductLine"));
                productLi.setTextDescription(rs.getString("TextDescription"));
                productLi.setHtmlDescription(rs.getString("HtmlDescription"));
                productLi.setImage(rs.getString("Image"));
                listProductLine.add(productLi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return listProductLine;
    }

    public ProductLine findByProductlinesCode(String  productLine) {
        ProductLine productLi = null;
        try {
            con = ConnectionMySQL.getConnection();
            query = "SELECT * FROM productlines WHERE productLine = ? ;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, productLine);
            rs = pstm.executeQuery();
            if (rs.next()) {
                productLi = new ProductLine();
                productLi.setProductLine(rs.getString("ProductLine"));
                productLi.setTextDescription(rs.getString("TextDescription"));
                productLi.setHtmlDescription(rs.getString("HtmlDescription"));
                productLi.setImage(rs.getString("Image"));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return productLi;
    }

    public boolean saveProductlines(ProductLine productLi, boolean isCreated) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            if (isCreated) {
                query = "INSERT INTO productlines(productLine , textDescription, htmlDescription, image) VALUES(?,?,?,?);";
                pstm = con.prepareStatement(query);
                pstm.setString(1, productLi.getProductLine());
                pstm.setString(2, productLi.getTextDescription());
                pstm.setString(3, productLi.getHtmlDescription());
                pstm.setString(4, productLi.getImage());
                state = pstm.executeUpdate() == 1;
            } else {
                query = "UPDATE productlines SET textDescription = ?, htmlDescription = ?, image = ? WHERE productLine = ?;";
                pstm = con.prepareStatement(query);
                pstm.setString(4, productLi.getProductLine());
                pstm.setString(1, productLi.getTextDescription());
                pstm.setString(2, productLi.getHtmlDescription());
                pstm.setString(3, productLi.getImage());
                state = pstm.executeUpdate() == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return state;
    }

    public boolean deleteProductlines(String productLine) {
        boolean state = false;
        try {
            con = ConnectionMySQL.getConnection();
            query = "DELETE FROM productlines WHERE productLine = ?;";
            pstm = con.prepareStatement(query);
            pstm.setString(1, productLine);
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
