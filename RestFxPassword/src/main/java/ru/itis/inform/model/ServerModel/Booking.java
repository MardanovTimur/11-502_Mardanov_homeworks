package ru.itis.inform.model.ServerModel;


/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
public class Booking {
    private Integer id;

    private User user;
    private Seance seance;
    private String about;
    private int row;
    private int col;
    private int key;

    public Booking(Integer id, User user, Seance seance, String about, int row, int col, int key) {
        this.id = id;
        this.user = user;
        this.seance = seance;
        this.about = about;
        this.row = row;
        this.col = col;
        this.key = key;
    }

    public Booking(User user, Seance seance, String about, int row, int col, int key) {
        this.user = user;
        this.seance = seance;
        this.about = about;
        this.row = row;
        this.col = col;
        this.key = key;
    }

    public Booking() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Booking { " +
                "row=" + row +
                ", col=" + col +
                ", key=" + key +
                '}';
    }
}
