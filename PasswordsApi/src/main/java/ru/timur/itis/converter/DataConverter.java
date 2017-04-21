package ru.timur.itis.converter;

import ru.timur.itis.dto.DataDto;
import ru.timur.itis.model.Data;

public class DataConverter {
    public static DataDto converter(Data data) {
        return new DataDto(data.getKey(),data.getValue());
    }
}
