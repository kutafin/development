package ru.UShApp2.dao;


import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.UShApp2.model.ShUrl;
import org.hibernate.Criteria;
import ru.UShApp2.model.Tag;


import java.util.List;
@Repository
public class ShUrlDaoImpl implements ShUrlDao  {

    private static final Logger logger = LoggerFactory.getLogger(ShUrlDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession() ;
    }

    @Override
        public void createUrl(ShUrl shUrl) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(shUrl);
        session.save(shUrl.getTag());

    }

    @Override
    public void updateUrl(ShUrl shUrl) {
        Session session=this.sessionFactory.getCurrentSession();
        ShUrl updateShUrl=(ShUrl) session.get(ShUrl.class, shUrl.getIdUrl());
        updateShUrl.setDescription(shUrl.getDescription());
        updateShUrl.setTag(shUrl.getTag());
        session.saveOrUpdate(updateShUrl);
        logger.info("Shorturl"+shUrl +"successfully update");
    }

    @Override
    public void removeUrl(int idUrl) {
      Session session = this.sessionFactory.getCurrentSession();
      ShUrl shUrl = (ShUrl) session.load(ShUrl.class,new Integer(idUrl));
        if(shUrl!=null){
            session.delete(shUrl);
        }

    }

    @Override
    public ShUrl findUrlByName(String url) {
        Criteria cr = getSession().createCriteria(Tag.class,"shorturl");
        cr.createAlias("shorturl.tag","tag");
        cr.add(Restrictions.like("url",url));

        return(ShUrl) cr.uniqueResult();
    }

    @Override
        public ShUrl findUrlById(int idUrl){
        return (ShUrl) getSession().get(ShUrl.class,idUrl);
    }


    @Override
    @SuppressWarnings(value = "uncheked")
    public List<ShUrl> listUrl() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ShUrl> urlList = session.createQuery("from ru.springapp.model.ShUrl").list();
        return urlList;
    }




    @Override
    @SuppressWarnings("uncheked")
    public List<ShUrl> findByTagName(String tagname) {
                Criteria cr = getSession()
                .createCriteria(ShUrl.class, "shorturl");
        cr.createAlias("shorturl.tag", "tag");
        cr.add(Restrictions.eq("tag.tagname", tagname));
        return (List<ShUrl>) cr.list();
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<ShUrl> findByUsername(String username) {
                Criteria cr = getSession()
                .createCriteria(ShUrl.class, "shorturl");
        cr.createAlias("shorturl.user", "user");
        cr.add(Restrictions.eq("user.username", username));
        return (List<ShUrl>) cr.list();
    }

    @Override
    public List<ShUrl> findByTag(int idTag) {
        Criteria cr = getSession().createCriteria(ShUrl.class,"shorturl")
                .add(Restrictions.eq("tag.idTag",idTag));
        return cr.list();
    }


}
