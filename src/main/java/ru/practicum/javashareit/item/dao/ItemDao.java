package ru.practicum.javashareit.item.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.javashareit.item.model.ItemModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ItemDao {

    private Connection connection;

    private final String ITEM_SELECT_BY_ID_QUERY = "select * from items where id = ?";
    private final String ITEM_SELECT_ALL_QUERY = "select * from items";
    private final String ITEM_INSERT = "insert into items(name, description, available) values (?, ?, ?)";

    public ItemDao(Connection connection) {
        this.connection = connection;
    }

    //метод для нахождения элемента по айди
    public ItemModel findItemById(final Long id) throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(ITEM_SELECT_BY_ID_QUERY);
        selectQuery.setLong(1, id);
        ResultSet resultSet = selectQuery.executeQuery();
        ItemModel itemModel = new ItemModel();
        itemModel.setName(resultSet.getString("name"));
        itemModel.setDescription(resultSet.getString("description"));
        itemModel.setAvailable(resultSet.getBoolean("available"));
        System.out.println(itemModel);
        return itemModel;
    }

    //метод для получения всех элементов
    public List<ItemModel> findAllItems() throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(ITEM_SELECT_ALL_QUERY);
        ResultSet resultSet = selectQuery.executeQuery();
        List<ItemModel> itemModelList = new ArrayList<>();
        while (resultSet.next()) {
            ItemModel itemModel = new ItemModel();
            itemModel.setName(resultSet.getString("name"));
            itemModel.setDescription(resultSet.getString("description"));
            itemModel.setAvailable(resultSet.getBoolean("available"));
            itemModelList.add(itemModel);
        }
        return itemModelList;
    }


    //заготовка для сохранения элемента в базе
    public void saveItemInDatabase(ItemModel itemModel) throws SQLException{
        PreparedStatement selectQuery = connection.prepareStatement(ITEM_INSERT);
        ResultSet resultSet = selectQuery.executeQuery();
        
    }

    //заготовка для внесения изменения в элемент в базе
    public void updateItemInDatabase(ItemModel itemModel) {

    }

    //заготовка для внесения изменения в элемент в базе
    public void deleteItemFromDatabase(final Long id) {

    }
}
