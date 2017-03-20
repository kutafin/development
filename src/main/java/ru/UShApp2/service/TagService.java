package ru.springapp.service;

import ru.springapp.model.Tag;

import java.util.List;


public interface TagService {

    List<Tag> getTags();

    Tag getTagByID(Integer idTag);

    void save(Tag tag);

    Tag getTagByName(String tagname);

}
