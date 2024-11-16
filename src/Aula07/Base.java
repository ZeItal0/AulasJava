package Aula07;
import java.time.LocalDateTime;

public abstract class Base {

    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    public static final int REMOVED = 3;

    protected int id;
    protected int status = ENABLED;
    protected LocalDateTime dateCreated;

    protected String title;

    public Base() {
        this.dateCreated = LocalDateTime.now();
    }

    public boolean isActive() {
        return this.status == ENABLED;
    }

}