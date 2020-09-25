package com.example.test.bean;

public class  Manages {
    private Integer id;
    private String  solvingDoubts;
    private String  blank;

    @Override
    public String toString() {
        return "Manages{" +
                "id=" + id +
                ", solvingDoubts='" + solvingDoubts + '\'' +
                ", blank='" + blank + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSolvingDoubts() {
        return solvingDoubts;
    }

    public void setSolvingDoubts(String solvingDoubts) {
        this.solvingDoubts = solvingDoubts;
    }

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }
}
