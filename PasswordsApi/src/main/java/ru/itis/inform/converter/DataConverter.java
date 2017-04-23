package ru.itis.inform.converter;

import ru.itis.inform.dto.DataDto;
import ru.itis.inform.model.Data;

public class DataConverter {
    public static DataDto converter(Data data) {
        return new DataDto(data.getKey(),data.getValue());
    }
}
