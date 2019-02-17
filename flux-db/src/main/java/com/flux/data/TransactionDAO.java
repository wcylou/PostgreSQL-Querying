package com.flux.data;

import java.util.UUID;

public interface TransactionDAO {

	void match(UUID id1, UUID id2);

	void unmatch(UUID id1, UUID id2);

}
