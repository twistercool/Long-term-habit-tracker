package sample;

public class Goal
{

    private String name;
    private String content;
    private boolean isDone;

    public Goal(String name, String content)
    {
        this.name = name;
        this.content = content;
        isDone = false;
    }

    public Goal(String name, String content, boolean isDone)
    {
        this.name = name;
        this.content = content;
        this.isDone = isDone;
    }

    public String GetName()
    {
        return name;
    }

    public boolean GetIsDone()
    {
        return isDone;
    }

    public String GetContent()
    {
        return content;
    }

    public void ChangeName(String name)
    {
        this.name = name;
    }

    public void ChangeContent(String content)
    {
        this.content = content;
    }


}
