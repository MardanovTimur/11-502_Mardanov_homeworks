package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AutoDaoImpl implements AutoDao {
	private File file;
	private Scanner sc;
    private PrintWriter pw;

	public AutoDaoImpl() throws FileNotFoundException{
	}

	public List findAll() throws FileNotFoundException{
		List list = new LinkedList();
        String elements;

        Auto newAuto = new Auto();
        this.file = new File("C:\\Android\\auto.txt");
	    this.sc = new Scanner(new File(file.getPath()));
        if (sc.hasNextLine()) {
            elements = sc.nextLine();
        } else
            return null;

        String element[] = elements.split(" ");


        for (int i = 0; i < element.length / 2; i++) {
            newAuto.setName(element[i * 2]);
            newAuto.setYear(element[i * 2 + 1]);
            list.add(newAuto);
            newAuto = new Auto();
        }
        return list;
	}

	public void save(Auto auto) throws FileNotFoundException {
		this.file = new File("C:\\Android\\auto.txt");
        this.sc = new Scanner(new File(file.getPath()));
        String textInScanner;
        if (sc.hasNextLine()) {
        	textInScanner = sc.nextLine();
        } else {
        	textInScanner = "";
        }
        String information = textInScanner + auto.getName() + " " + auto.getYear() + " ";
        PrintWriter pw = new PrintWriter(new File(file.getPath()));
        pw.print(information);
    }

    public Auto find(String string) throws FileNotFoundException {
    	this.file = new File("C:\\Android\\auto.txt");
        this.sc = new Scanner(new File(file.getPath()));
        String autos;
        if (sc.hasNextLine()) {
        	autos = sc.nextLine();
        } else 
        	return null;
        String auto[] = autos.split(" ");
        String name_a;
        name_a = "";
        name_a += string;
        Auto newAuto = null;
        for (int i = 0; i < auto.length / 2; i++) {
            if (name_a.equals(auto[i * 2])) {
                newAuto = new Auto(auto[i * 2], auto[i * 2 + 1]);
            }
        }
        if (newAuto != null) {
            return newAuto;
        } else
            return null;
    }

    public void closePW() {
        this.pw.close();
    }

    public void closeSC() {
        this.sc.close();
    }
}