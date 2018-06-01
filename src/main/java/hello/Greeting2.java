package hello;

public class Greeting2 {

    private final long id;
    private final String content;

    Greeting2(long id, String content) {
        this.id = id;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


}
