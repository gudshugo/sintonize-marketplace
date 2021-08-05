CREATE TABLE album
 (
	id bigserial NOT NULL,
	nome varchar(255) NULL,
	nome_artista varchar(255) NULL,
	imagem varchar(255) NULL,
	unique_id uuid NULL,
	valor float8 NULL,
	id_api_spotify varchar(100) NULL,
	link_spotify varchar(100) NULL,
	CONSTRAINT album_pkey PRIMARY KEY (id)
);

CREATE TABLE album_venda (
	id bigserial NOT NULL,
	valor_cashback float8  NULL,
	valor_venda float8 NULL,
	album_id int8 NULL,
	venda_id int8 NULL,
	CONSTRAINT album_venda_pkey PRIMARY KEY (id)
);

CREATE TABLE venda (
	id bigserial NOT NULL,
	data_venda timestamp NULL,
	valor_cashback float8 NULL,
	valor_venda float8 NULL,
	CONSTRAINT venda_pkey PRIMARY KEY (id)
);