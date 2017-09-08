import java.util.List;

public class History {
    private String name;
    private List<Integer> counts;
    private int averageScore;

    public History(String name, List<Integer> counts) {
        this.name = name;
        this.counts = counts;
    }

    public void calculateAverageScore() {
        for (Integer number: counts) {
            averageScore+=number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return name+" "+averageScore;
    }
}
