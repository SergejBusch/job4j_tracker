package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sql = "INSERT INTO items (name) VALUES (?)";
        try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = (int) rs.getLong(1);
                        String name = rs.getString(2);
                        return new Item(id, name);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        String sql = "UPDATE items SET name=? WHERE id=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setLong(2, Long.parseLong(id));
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM items WHERE id=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(id));
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Item(id, name));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE name=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Item(id, name));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        String sql = "SELECT * FROM items WHERE id=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                return new Item(Integer.parseInt(id), name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
