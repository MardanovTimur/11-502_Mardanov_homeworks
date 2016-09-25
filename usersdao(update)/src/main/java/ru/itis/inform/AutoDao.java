package ru.itis.inform;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface AutoDao{
	List findAll() throws FileNotFoundException, SQLException;
	void save(Auto auto) throws FileNotFoundException;
	Auto find(String string) throws FileNotFoundException;
	void closePW();
	void closeSC();
}