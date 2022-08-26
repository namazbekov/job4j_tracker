package ru.job4j.tracker;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        SqlTracker tracker = new SqlTracker(connection);
        initConnection();
        Item item = new Item(1, "item",localDateTime);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndDropItem() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        SqlTracker tracker = new SqlTracker(connection);
        initConnection();
        Item item = new Item(1, "item",localDateTime);
        tracker.add(item);
        assertThat(tracker.delete(item.getId()), is(true));
    }

    @Test
    public void whenSaveItemAndReplaceItem() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        SqlTracker tracker = new SqlTracker(connection);
        initConnection();
        Item item = new Item(1, "item",localDateTime);
        Item item2 = new Item(item.getId(), "item222",localDateTime);
        tracker.add(item);
        assertThat(tracker.replace(item.getId(), item2), is(true));
    }

    @Test
    public void whenSaveItemAndRFindByNameItem() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        SqlTracker tracker = new SqlTracker(connection);
        initConnection();
        List<Item> list = new ArrayList<>();
        Item item = new Item(1, "item", localDateTime);
        tracker.add(item);
        list.add(item);
        assertThat(tracker.findByName("item"), is(list));
    }

    @Test
    public void whenSaveItemAndRFindAllItems() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        SqlTracker tracker = new SqlTracker(connection);
        initConnection();
        List<Item> list = new ArrayList<>();
        Item item = new Item(1, "item", localDateTime);
        tracker.add(item);
        list.add(item);
        assertThat(tracker.findAll(), is(list));
    }
}