import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Supplier;

public class ObjectDAO implements IObjectDAO {

    //private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");


    @Override
    public void save(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public List getObjFromTable(String nameObj) throws SQLException {
        String query = "FROM " + nameObj;
        List listObjs = new ArrayList<Object>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            listObjs = session.createQuery(query).list();
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return listObjs;
    }

    @Override
    public List getObjFromTable(String nameObj,String nameValue, List<Object> ids) throws SQLException {
        String query = "SELECT p FROM " + nameObj + " p WHERE p." + nameValue + " IN :ids";
        List listObjs = new ArrayList<Object>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            listObjs = session.createQuery(query).setParameter("ids", ids).getResultList();
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return listObjs;
    }

    @Override
    public List getObjFromTable(String nameObj, String queryString) throws SQLException {
        List results = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
            Root<Parents> parentsRoot = criteriaQuery.from(Parents.class);
            Root<Children> childrenRoot = criteriaQuery.from(Children.class);
            criteriaQuery.multiselect(parentsRoot, childrenRoot);
            criteriaQuery.where(builder.equal(parentsRoot.get("last_name"), childrenRoot.get("last_name")));
            Query<Object[]> query=session.createQuery(criteriaQuery);
            List<Object[]> list=query.getResultList();
            for (Object[] objects : list) {
                Parents parents = (Parents) objects[0];
                Children children = (Children) objects[1];
                System.out.println("EMP NAME="+ parents.getFirst_name()+"\t DEPT NAME="+ children.getFirst_name());
            }
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return null;
    }


    @Override
    public <T>List getObjFromTable() throws SQLException {
        List results = null;
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db2");
        //entityManagerFactory.createEntityManager();
        try {

            //CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
            //CriteriaQuery<Parents> criteriaQuery = criteriaBuilder.createQuery(Parents.class);
            //Root<Children> answerRoot = criteriaQuery.from(Children.class);
            //criteriaQuery.where(criteriaBuilder.equal(answerRoot.get(Children_.child_id),"child_id"));
            //SetJoin<Children, Parents> answers = (SetJoin<Children, Parents>) answerRoot.join(Children_.parents);
            //CriteriaQuery<Parents> cq = criteriaQuery.select(answers);
            //TypedQuery<Parents> query = criteriaBuilder.createQuery(cq);
            //return query.getResultList();

            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Parents> criteriaQuery = builder.createQuery(Parents.class);
            //CriteriaQuery<Children> cq = criteriaQuery.select(answers);
            Root<Parents> parentsRoot = criteriaQuery.from(Parents.class);
            Root<Children> childrenRoot = criteriaQuery.from(Children.class);
            criteriaQuery.where(builder.equal(childrenRoot.get(Children_.child_id), "child_id"));
            Join<Children, Parents> parentsChildrenJoin = childrenRoot.join("children");
            CriteriaQuery<Parents> cq = criteriaQuery.select(parentsChildrenJoin);
            TypedQuery<T> query = (TypedQuery<T>) session.createQuery(cq);
            List<T> list = query.getResultList();
            for (Object objects : list) {
                Parents parents = (Parents) objects;
                Children children = (Children) objects;
                System.out.println("EMP NAME=" + parents.getFirst_name() + "\t DEPT NAME=" + children.getFirst_name());
    /*select c from Category c " +
            "join c.categorizedItems ci " +
            "where ci.item = :itemParameter")
            .setParameter("itemParameter", item)
    .getResultList();*/
            }
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" , JOptionPane.OK_OPTION);
        }
        return null;
    }

    public Parents findById(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(Parents.class, id);
    }
}