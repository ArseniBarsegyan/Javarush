package com.javarush.task.task36.task3608.model;

/**
 * Created by arseniy.barsegyan on 28.04.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
}
