package ru.itis.inform.services;

import ru.itis.inform.models.Studio;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
//Все это сервисы с управлениями ДАО

public interface StudioService {
    Studio getStudioByFilmId(int id);
    boolean addStudio(Studio studio);
    Studio getStudio(String name);
    LinkedList<Studio> getAllStudio();
}
