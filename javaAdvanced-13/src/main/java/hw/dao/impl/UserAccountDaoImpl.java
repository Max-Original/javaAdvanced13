package hw.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import hw.dao.UserAccountDao;
import hw.domain.UserAccount;
import hw.shared.FactoryManager;


public class UserAccountDaoImpl implements UserAccountDao{
	
	private EntityManager em = FactoryManager.getEntityManager();
		
	
	@Override
	public UserAccount creat(UserAccount user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}





	@Override
	public UserAccount read(Integer id) {
		UserAccount user = null;
		try {
			user = em.find(UserAccount.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}





	@Override
	public UserAccount update(UserAccount t) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public List<UserAccount> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserAccount getUserAccountByEmail(String email) {
		UserAccount user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<UserAccount> criteria = builder.createQuery(UserAccount.class);
			Root<UserAccount> from = criteria.from(UserAccount.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<UserAccount> typed = em.createQuery(criteria);
			user = typed.getSingleResult();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return user;
	}

}
