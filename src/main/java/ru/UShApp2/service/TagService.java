package ru.UShApp2.service;

import ru.UShApp2.model.Tag;

import java.util.List;


public interface TagService {

    List<Tag> getTags();

    Tag getTagByID(Integer idTag);

    void save(Tag tag);

    Tag getTagByName(String tagname);

}
