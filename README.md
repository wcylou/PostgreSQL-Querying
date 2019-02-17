# PostgreSQL Querying

### How to run

```
$ docker-compose up
$ cd flux-db
$ mvn spring-boot:run
```

### Terminal Recording

1. Server starting
2. `GET /merchants?name={name}` - list merchant, not including locations (lightweight, top level)
* `curl -i GET http://localhost:8080/api/merchants?name=EAT.`
3. `GET /merchants/{id}` - grab a merchant by id, including locations
* `curl -i GET http://localhost:8080/api/merchants/92e50938-1aec-4ca7-995d-dc79ae0428fb`
4. `GET /transactions/stats` - get a map of state: count of transactions in said state i.e. `{ "MATCHED": 1, "UNMATCHED": 2 }`
* `curl -i GET http://localhost:8080/api/transactions/stats`
5. `GET /transactions?state={state}` - get a list of transactions in a specific state (i.e. MATCHED/UNMATCHED)
* `curl -i GET http://localhost:8080/api/transactions?state=MATCHED`
* `curl -i GET http://localhost:8080/api/transactions?state=UNMATCHED`
6. `GET /transactions/{id}` - get a transaction, state and candidates
* `curl -i GET http://localhost:8080/api/transactions/6939646b-c894-4406-bed9-7de87221e79e`
6. `POST /match` - match two transactions together
* `curl --data "id=6939646b-c894-4406-bed9-7de87221e79e&id2=156ce21a-5ad3-431e-b00c-f61b38b9c83f" -X POST http://localhost:8080/api/match`
* `curl -i GET http://localhost:8080/api/transactions?state=MATCHED`
7. `POST /unmatch` - unmatch two transactions
* `curl --data "id=6939646b-c894-4406-bed9-7de87221e79e&id2=156ce21a-5ad3-431e-b00c-f61b38b9c83f" -X POST http://localhost:8080/api/unmatch`
* `curl -i GET http://localhost:8080/api/transactions?state=UNMATCHED`

[![asciicast](https://asciinema.org/a/ombJeRFxCwT215n528uHVVWXU.svg)](https://asciinema.org/a/ombJeRFxCwT215n528uHVVWXU)

### License
This program is licensed under the MIT license.
Copyright (c) 2019 Wilson Lou.
