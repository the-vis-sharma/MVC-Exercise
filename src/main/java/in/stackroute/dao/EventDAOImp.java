package in.stackroute.dao;

import in.stackroute.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class EventDAOImp implements EventDAO {

//    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean insertEvent(Event event) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public List<Event> getAllEvents() {
        String hql = new String("from Event");
        Query query = sessionFactory.openSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Event> searchEvent(String query) {
        String hql = new String("from Event where name like :query or type like :query");
        Query query1 = sessionFactory.openSession().createQuery(hql);
        query1.setParameter("query", query);
        return query1.list();
    }

    @Override
    public Event getEventDetail(int id) {
        return sessionFactory.openSession().get(Event.class, id);
    }
}
