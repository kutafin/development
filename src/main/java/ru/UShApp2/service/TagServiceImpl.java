package ru.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springapp.dao.TagDao;
import ru.springapp.model.Tag;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService{
    @Autowired
    @Qualifier("TagDao")
    private TagDao tagDao;

    @Override
    public List<Tag> getTags() {
        List<Tag> tags = tagDao.listTag();
        return tags;
    }

    @Override
    public Tag getTagByID(Integer idTag) {
        Tag tag = tagDao.findById(idTag);
        return tag;

    }

    @Override
    public void save(Tag tag) {
        this.tagDao.save(tag);

    }

    @Override
    public Tag getTagByName(String tagname) {
        Tag tag = tagDao.findByName(tagname);
        return tag;
    }
}
