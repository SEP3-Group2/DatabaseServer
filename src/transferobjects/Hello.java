package transferobjects;

import java.io.Serializable;

public class Hello implements Serializable
{
    private final String content;

    public Hello(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
