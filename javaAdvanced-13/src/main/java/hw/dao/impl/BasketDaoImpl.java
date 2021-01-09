package hw.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hw.dao.BasketDao;
import hw.domain.Basket;
import hw.shared.FactoryManager;

public class BasketDaoImpl implements BasketDao {

	private EntityManager em = FactoryManager.getEntityManager();
	
	@Override
	public Basket creat(Basket basket) {
		try {
			em.getTransaction().begin();
			em.persist(basket);
			em.getTransaction().commit();
		} catch (Exception e) {
 		e.printStackTrace();
		}
		return basket;
	}

	@Override
	public Basket read(Integer id) {
		Basket basket = null;
		try {
		 basket = em.find(Basket.class, id);	
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

	@Override
	public Basket update(Basket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			Basket basket = read(id);
			em.getTransaction().begin();
			em.remove(basket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Basket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("Select e From Basket e");
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return query.getResultList();
	}



}
