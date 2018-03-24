/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciencias.is.capisoft.modelo.dao;

import mx.ciencias.is.capisoft.modelo.Comentario;
import mx.ciencias.is.capisoft.modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Data Access Object para la entidad Comentario
 *
 * @author acv629
 * @version 1.0
 */
public class ComentarioDAO {

  private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  /**
   * Añade un nuevo comentario
   *
   * @param comentarioNuevo El comentario a añadir a la BD
   */
  public void crear(Comentario comentarioNuevo) {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    try {
      tx.begin();

      session.persist(comentarioNuevo);

      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

}
