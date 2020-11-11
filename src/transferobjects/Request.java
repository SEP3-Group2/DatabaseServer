package transferobjects;

import java.io.Serializable;

public class Request implements Serializable
{
    private Object arg;
    private String type;

    public Request(String type, Object arg)
    {
        this.arg = arg;
        this.type = type;
    }

    public Object getArg()
    {
        return arg;
    }

    public String getType()
    {
        return type;
    }
}
