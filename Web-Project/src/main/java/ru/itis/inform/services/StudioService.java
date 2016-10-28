package ru.itis.inform.services;

import ru.itis.inform.models.Studio;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public interface StudioService {
    boolean addStudio(Studio studio);
    Studio getStudio(String name);
    LinkedList<Studio> getAllStudio();
}
