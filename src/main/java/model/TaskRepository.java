package model;

import db.HibernateUtil;
import db.Repository;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TaskRepository implements Repository<Task> {
    private Session session;
    private static TaskRepository instance = null;

    public static TaskRepository getInstance() {
        if (instance == null)
            instance = new TaskRepository();
        instance.session = HibernateUtil.getSessionFactory().openSession();
        return instance;
    }

    private TaskRepository() {

    }

    @Override
    public void persist(Task task) {
        try {
            session.save(task);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Task task) {
        try {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAll() {
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Task> cr = cb.createQuery(Task.class);
            Root<Task> root = cr.from(Task.class);
            cr.select(root);
            Query query = session.createQuery(cr);
            List<Task> list = query.getResultList();
            session.close();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteRow(int id) {
        try {
            Task entity = new Task();
            entity.setId(id);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
