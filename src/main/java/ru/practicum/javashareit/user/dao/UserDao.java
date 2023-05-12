package ru.practicum.javashareit.user.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.javashareit.user.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class UserDao {

    private Connection connection;

    private final String USER_SELECT_BY_ID_QUERY = "select * from users where id = ?";
    private final String USER_SELECT_ALL_QUERY = "select * from users";

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public UserModel findItemById(final Long id) throws SQLException {
            if (connection != null){
                System.out.println("мы подключились к бд");
            } else {
                System.out.println("БД не доступна");
            }
            PreparedStatement selectQuery  = connection.prepareStatement(USER_SELECT_BY_ID_QUERY);
            selectQuery.setLong(1, id);
            ResultSet resultSet = selectQuery.executeQuery();
            UserModel userModel = new UserModel();
            userModel.setName(resultSet.getString("name"));
            userModel.setEmail(resultSet.getString("email"));
            System.out.println(userModel);
            return userModel;
    }

    public List<UserModel> findAllUsers() throws SQLException {
            PreparedStatement selectQuery  = connection.prepareStatement(USER_SELECT_ALL_QUERY);
            ResultSet resultSet = selectQuery.executeQuery();
            List<UserModel> userModelList = new ArrayList<>();
            while (resultSet.next()){
                UserModel userModel = new UserModel();
                userModel.setName(resultSet.getString("name"));
                userModel.setEmail(resultSet.getString("email"));
                userModelList.add(userModel);
            }
            return userModelList;
    }

    //заготовка для сохранения юзера в базе
    public void saveUserInDatabase(UserModel userModel){

    }

    //заготовка для внесения изменения в юзера в базе
    public void updateUserInDatabase(UserModel userModel){

    }

    //заготовка для внесения изменения в юзера в базе
    public void deleteUserFromDatabase(final Long id){

    }
}
