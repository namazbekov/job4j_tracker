package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
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
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items (name, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            statement.setTimestamp(2, timestampFromLDT);
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            statement.setTimestamp(2, timestampFromLDT);
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(iteration(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select id, name, created from items where name like ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(iteration(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select id, name, created from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                    item = iteration(resultSet);
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }


    public Item iteration(ResultSet set) throws SQLException {
        return new Item(
                    set.getInt(1),
                    set.getString(2),
                    set.getTimestamp("created").toLocalDateTime()
        );
    }

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        Timestamp timestampFromLDT = Timestamp.valueOf(localDateTime);
        Item item = new Item(1, "test1", localDateTime);
        Item item1 = new Item(2, "test2", localDateTime);
        Item item2 = new Item(3, "test3", localDateTime);
        Item item3 = new Item(1, "Test111", localDateTime);
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        System.out.println(item);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(sqlTracker.replace(1 ,item3));
        System.out.println(sqlTracker.delete(1));
        System.out.println(sqlTracker.findById(2));
        System.out.println(sqlTracker.findAll());
        System.out.println(sqlTracker.findByName("test2"));
        System.out.println(sqlTracker.findById(5));
    }
}