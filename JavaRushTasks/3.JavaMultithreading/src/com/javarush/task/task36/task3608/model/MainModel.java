package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by arseniy.barsegyan on 28.04.2017.
 */
public class MainModel implements Model {
    private  ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }
}
