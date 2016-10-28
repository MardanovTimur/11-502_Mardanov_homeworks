package ru.itis.inform.dao;

import ru.itis.inform.models.Studio;

import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface StudioDao {
    boolean addStudio(Studio role);
    Studio getStudio(String name);
    LinkedList<Studio> getStudios();
}
