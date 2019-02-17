package com.flux.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flux.models.Merchants;

@Repository
public interface MerchantsRepository extends JpaRepository<Merchants, Integer> {
	Optional<Merchants> findByName(String name);
	
	@Query("SELECT m.id, m.name, l.name as locationName from Merchants m JOIN Locations l ON m.id = l.merchantId WHERE m.id= :id")
	Merchants findByMerchantNameInclLocation(@Param("id") UUID id);

}
