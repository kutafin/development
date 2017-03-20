package ru.UShApp2.dao;

import ru.UShApp2.model.Tag;

import java.util.List;

public interface TagDao {

      Tag save(Tag tag);

      Tag findById(int idTag);

      Tag findByName(String tagname);

      List<Tag> listTag();
}
