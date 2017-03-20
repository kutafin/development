package ru.springapp.service;

        import ru.springapp.model.ShUrl;

        import java.util.List;

public interface ShUrlService {
    void createUrl (ShUrl shUrl);
    void updateUrl (ShUrl shUrl);
    void removeUrl (int idUrl);
    ShUrl getUrlById (int idUrl);
    ShUrl getUrlByName(int idTag);
    List<ShUrl> getUrls();
    List<ShUrl> getUrlByTagname(String tagname);
    List<ShUrl> getUrlByUsername(String username);
    }
