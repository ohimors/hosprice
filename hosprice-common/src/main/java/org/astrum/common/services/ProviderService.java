package org.astrum.common.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.astrum.common.domain.Provider;
import org.astrum.common.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

	
	@Inject
	ProviderRepository providerRepository;
	
	@Inject
	EntityManagerFactory entityManagerFactory;
	
	
	public List<Provider> getProviderByParams(String qZipcode, String qCity, String qState){
		  EntityManager entityManager = entityManagerFactory.createEntityManager();
		  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		  
		  CriteriaQuery<Provider> q = cb.createQuery(Provider.class);
		  Root<Provider> c = q.from(Provider.class);
		  
		  ParameterExpression<String> zipcode = cb.parameter(String.class);
		  ParameterExpression<String> city = cb.parameter(String.class);
		  ParameterExpression<String> state = cb.parameter(String.class);
		  q.select(c)
		  .where(cb.and(
				 cb.equal(c.get("address").get("zipcode"), zipcode),
				  cb.equal(c.get("address").get("city"), city),
				  cb.equal(c.get("address").get("state"), state)	
				  ));
		  
		  TypedQuery<Provider> query = entityManager.createQuery(q);
		  query.setParameter(zipcode, qZipcode);
		  query.setParameter(city, qCity );
		  query.setParameter(state, qState);
		
		return query.getResultList();
	}
	
	public Provider getProviderByName(String name){
		return providerRepository.findByName(name);
	}
	public Provider getProviderById(Long providerId){
		return providerRepository.findOne(providerId);
	}
	public Provider getProviderByLegacyId(Long providerId){
		return providerRepository.findByLegacyId(providerId);
	}
	
	public List<Provider> findAll(){
		return providerRepository.findAll();
	}
}
