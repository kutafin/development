package ru.UShApp2.model;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTag")
    private int idTag;

    @Column (name = "tagname")
    private String tagname;


    public Tag() {
    }

    public Tag(int idTag, String tagname) {
        this.idTag = idTag;
        this.tagname = tagname;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "idTag=" + idTag +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
