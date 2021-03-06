package com.flux.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flux.models.Merchants;
import com.flux.models.MerchantsDetailed;
import com.flux.repositories.MerchantDetailedRepository;
import com.flux.repositories.MerchantsRepository;

@RequestMapping("api/")
@RestController
public class MerchantController {

	static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);

	@Autowired
	MerchantsRepository merchantRepository;

	@Autowired
	MerchantDetailedRepository merchantDetailedRepository;

	private Merchants merchant;

	@RequestMapping(path = "merchants", method = RequestMethod.GET)
	public Merchants getMerchantByName(@RequestParam String name) {
		LOGGER.info("Finding merchant {}", name);
		try {
			Optional<Merchants> result = merchantRepository.findByName(name);
			merchant = result.get();
			LOGGER.info("Merchant found: {}", merchant);
		} catch (NoSuchElementException e) {
			LOGGER.error("No such merchant with name {} found", name);
		}
		return merchant;
	}

	@RequestMapping(path = "merchants/{id}", method = RequestMethod.GET)
	public List<MerchantsDetailed> getMerchantById(@PathVariable UUID id) {
		List<MerchantsDetailed> merchants = merchantDetailedRepository.merchantIncludingLocation(id);
		for (MerchantsDetailed merchant : merchants) {
			LOGGER.info("Finding merchant {}", id);
			LOGGER.info("Merchant: [ID: {}, Name: {}, Location: {}]", merchant.getId(), merchant.getName(),
					merchant.getLocationName());
		}
		return merchants;
	}

}
