package com.flux.repositories;

import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.springframework.stereotype.Repository;

import com.flux.models.Stats;

@Repository
public class TransactionStatsRepository {
	
	@PersistenceContext
	private EntityManager em;
		
	@SuppressWarnings("unchecked")
	public List<Stats> transactionStats() {
		Query query = em.createNativeQuery("SELECT t.state, \n" + " COUNT(*) as total, \n"
				+ " sum(case when t.state='MATCHED' then 1 else 0 end) as matched , \n"
				+ " sum(case when t.state='UNMATCHED' then 1 else 0 end) as unmatched \n" + " from Transactions t \n"
				+ " group by t.state", "Statistics");
		return query.getResultList();
	}
		
		@SqlResultSetMapping(
			name="Statistics",
			    classes={
			      @ConstructorResult(
			        targetClass=Stats.class,
			        columns={
			          @ColumnResult(name="state", type=String.class),
			          @ColumnResult(name="total", type=Integer.class),
			          @ColumnResult(name="matched", type=Integer.class),
			          @ColumnResult(name="unmatched", type=Integer.class)
			          }
			        )
			      }
			)  @Entity class SQLMappingCfgEntity{@Id int id;}
		
	}

