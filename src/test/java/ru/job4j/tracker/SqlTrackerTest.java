package ru.job4j.tracker;

import org.junit.*;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndDropItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertTrue(tracker.delete(item.getId()));
        assertThat(item.getId(), is("null"));
    }

    @Test
    public void whenSaveItemAndReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item2 = new Item("item222");
        assertTrue(tracker.replace(item.getId(), item2));
        assertThat(item.getName(), is("item222"));
    }

    @Test
    public void whenSaveItemAndRFindByNameItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item"));
        Item item3 = tracker.add(new Item("item"));
        assertThat(tracker.findByName("item"),
                is(List.of(item, item2, item3)));
    }

    @Test
    public void whenSaveItemAndRFindAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item"));
        Item item3 = tracker.add(new Item("item"));
        assertThat(tracker.findAll(), is(List.of(item, item2, item3)));
    }
}