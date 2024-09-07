package onlinefooddelivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import onlinefooddelivery.model.Menu;
import onlinefooddelivery.model.Restaurant;

public class RestaurantDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public RestaurantDao(Connection con) {
        this.con = con;
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            query = "SELECT * FROM restaurants";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(rs.getInt("id"));
                restaurant.setName(rs.getString("name"));
                restaurant.setCategory(rs.getString("category"));
                restaurant.setPrice(rs.getDouble("price"));
                restaurant.setImage(rs.getString("image"));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return restaurants;
    }

    public Restaurant getSingleProduct(int id) {
        Restaurant restaurant = null;
        try {
            query = "SELECT * FROM restaurants WHERE id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                restaurant = new Restaurant();
                restaurant.setId(rs.getInt("id"));
                restaurant.setName(rs.getString("name"));
                restaurant.setCategory(rs.getString("category"));
                restaurant.setPrice(rs.getDouble("price"));
                restaurant.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return restaurant;
    }

    public double getTotalMenuPrice(ArrayList<Menu> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Menu item : cartList) {
                    query = "SELECT price FROM restaurants WHERE id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    public List<Menu> getCartProducts(ArrayList<Menu> cartList) {
        List<Menu> products = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Menu item : cartList) {
                    query = "SELECT * FROM restaurants WHERE id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Menu menu = new Menu();
                        menu.setId(rs.getInt("id"));
                        menu.setName(rs.getString("name"));
                        menu.setCategory(rs.getString("category"));
                        menu.setPrice(rs.getDouble("price") * item.getQuantity());
                        menu.setQuantity(item.getQuantity());
                        products.add(menu);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }
}
