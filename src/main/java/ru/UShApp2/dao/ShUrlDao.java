package ru.springapp.dao;

import ru.springapp.model.ShUrl;

import java.util.List;

public interface ShUrlDao {
    void createUrl (ShUrl shUrl);
    void updateUrl (ShUrl shUrl);
    void removeUrl (int idUrl);
    ShUrl findUrlByName(String url);
    ShUrl findUrlById(int idUrl);
    List<ShUrl> listUrl();
    List<ShUrl> findByTagName(String tagname);
    List<ShUrl> findByUsername(String username);
    List<ShUrl> findByTag(int idTag);

}
