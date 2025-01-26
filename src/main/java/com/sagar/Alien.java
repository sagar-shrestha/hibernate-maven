package com.sagar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    private int alienId;
    private AlienName alienName;
    private String alienColor;

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public AlienName getAlienName() {
        return alienName;
    }

    public void setAlienName(AlienName alienName) {
        this.alienName = alienName;
    }

    public String getAlienColor() {
        return alienColor;
    }

    public void setAlienColor(String alienColor) {
        this.alienColor = alienColor;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", alienName=" + alienName +
                ", alienColor='" + alienColor + '\'' +
                '}';
    }
}
