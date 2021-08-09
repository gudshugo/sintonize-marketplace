CREATE TABLE cashback (
	id bigserial NOT NULL,
	valor float8 NULL,
	dia int4 NULL,
	mes int4 NULL,
	CONSTRAINT cashback_venda_pkey PRIMARY KEY (id)
);


