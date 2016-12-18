package ru.itis.inform.dao;

import ru.itis.inform.models.Studio;

import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface StudioDao {
    // Получить модель студии по айди фильма
    Studio getStudioByFilmId(int id);

    // Добавить студию по модели студии
    boolean addStudio(Studio role);

    //Получить модель студии по имени
    Studio getStudio(String name);

    //Получить весь список студий моделей студио
    LinkedList<Studio> getStudios();
}
