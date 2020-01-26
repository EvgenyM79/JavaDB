import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

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
    public List<EducateBuilding> getObjFromTable(String nameObj, String val) throws SQLException {
        //String query = "FROM " + nameObj + " WHERE "+ nameObj + ".as_area = " + val;
        String query = "select ebuilding.eb_name FROM ebuilding WHERE ebuilding.as_area = \"Октябрьский\"";
        List<EducateBuilding> listObjs = new ArrayList<EducateBuilding>();
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

    /*@Override
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

     //Запрос на выборку по одинаковой фамилии (актуально, если нужно найти только Мужчин и мальчиков)
     //работает, но нужно дорабатывать
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
                System.out.println(""+ parents.getFirst_name()+"\t DEPT NAME="+ children.getFirst_name());
            }
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return null;
    }
*/

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
            CriteriaQuery<EducateBuilding> criteriaQuery = builder.createQuery(EducateBuilding.class);
            //CriteriaQuery<Children> cq = criteriaQuery.select(answers);
            Root<EducateBuilding> educateBuildingRoot = criteriaQuery.from(EducateBuilding.class);
            Root<Children> childrenRoot = criteriaQuery.from(Children.class);
            criteriaQuery.where(builder.equal(childrenRoot.get(Children_.child_id), "child_id"));
            Join<Children, EducateBuilding> childrenEducateBuildingJoin = childrenRoot.join("children");
            CriteriaQuery<EducateBuilding> educateBuildingCriteriaQuery = criteriaQuery.select(childrenEducateBuildingJoin);
            TypedQuery<T> query = (TypedQuery<T>) session.createQuery(educateBuildingCriteriaQuery);
            List<T> list = query.getResultList();
            for (Object objects : list) {
                EducateBuilding educateBuilding = (EducateBuilding) objects;
                Children children = (Children) objects;
                System.out.println("EMP NAME=" + educateBuilding.getAreaStreet() + "\t DEPT NAME=" + children.getFirst_name());
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

    @Override
    public Parents findByIdParent(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(Parents.class, id);
    }

    @Override
    public Children findByIdChild(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(Children.class, id);
    }

    @Override
    public EducateBuilding findByIdEducation(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(EducateBuilding.class, id);
    }
}