package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Product;

public class ProductDAO {
    private int noOfRecords;

    public ProductDAO() {
    }

    public List<Product> viewAllProducts(int offset, int noOfRecords) {
        String query = "select SQL_CALC_FOUND_ROWS * from ProductDB.Product limit " + offset + ", " + noOfRecords;
        List<Product> products = new ArrayList<Product>();
        Product product = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)
                    initContext.lookup("java:comp/env");
            DataSource ds = (DataSource)
                    envContext.lookup("jdbc/ProductDB");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("price"),
                        resultSet.getInt("category_id")
                ));
            }

            resultSet.close();
            resultSet = statement.executeQuery("select found_rows()");
            if (resultSet.next()) {
                this.noOfRecords = resultSet.getInt(1);
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }
}