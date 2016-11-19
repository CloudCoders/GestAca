package Model;

import java.util.Date;

/**
 * Created by JoseLlorens on 18/11/2016.
 */
public class Absence {
    private Date date;
    private int id;

    public Absence(Date date, int id) {
        this.date = date;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
