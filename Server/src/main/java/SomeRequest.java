/**
 * Created by Тимур on 09.12.2016.
 */
public class SomeRequest {
    private String name;
    public String text;

    public SomeRequest(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public SomeRequest(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
