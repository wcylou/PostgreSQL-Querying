package com.flux.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flux.models.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

	List<Transactions> findAll();
	
	@Query("SELECT t FROM Transactions t WHERE t.state= :state")
	List<Transactions> getTransactionInState(@Param("state") String state);

	@Query("SELECT t FROM Transactions t WHERE t.id= :id")
	List<Transactions> getTransactionById(@Param("id") UUID id);

	@Modifying
	@Query("UPDATE Transactions t SET t.state = :state, t.matchedWith = :id2 WHERE t.id = :id")
	int matchTransaction(@Param("state") String state, @Param("id2") UUID id2, @Param("id") UUID id);
	
	@Modifying
	@Query("UPDATE Transactions t SET t.state = :state, t.matchedWith=NULL WHERE t.id = :id")
	int unmatchTransaction(@Param("state") String state, @Param("id") UUID id);

}
