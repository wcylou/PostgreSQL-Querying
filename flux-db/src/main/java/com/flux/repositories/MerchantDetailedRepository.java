package com.flux.repositories;

import java.util.List;
import java.util.UUID;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.springframework.stereotype.Repository;

import com.flux.models.MerchantsDetailed;

@Repository
public class MerchantDetailedRepository {
	
	@PersistenceContext
	private EntityManager em;
		
	@SuppressWarnings("unchecked")
	public List<MerchantsDetailed> merchantIncludingLocation(UUID id) {
		Query query = em.createNativeQuery("SELECT m.id, m.name, l.name as locationName from Merchants m JOIN Locations l ON m.id = l.merchant_id WHERE m.id= :id", "MerchantsDetailed");
		query.setParameter("id", id);
		return query.getResultList();
	}
		
		@SqlResultSetMapping(
			name="MerchantsDetailed",
			    classes={
			      @ConstructorResult(
			        targetClass=MerchantsDetailed.class,
			        columns={
			          @ColumnResult(name="id", type=UUID.class),
			          @ColumnResult(name="name", type=String.class),
			          @ColumnResult(name="locationName", type=String.class),
			          }
			        )
			      }
			)  @Entity class SQLMappingCfgEntity{@Id int id;}
		
	}

