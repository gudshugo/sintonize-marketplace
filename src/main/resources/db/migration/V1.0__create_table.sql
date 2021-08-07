CREATE TABLE album
 (
	id bigserial NOT NULL,
	nome varchar(100) NULL,
	nome_artista varchar(100) NULL,
	imagem varchar(255) NULL,
	unique_id uuid NULL,
	valor float8 NULL,
	id_api_spotify varchar(100) NULL,
	link_spotify varchar(100) NULL,
	CONSTRAINT album_pkey PRIMARY KEY (id)
);

CREATE TABLE album_detalhe
 (
	id bigserial NOT NULL,
    numero int8 NULL,
	nome varchar(100) NULL,
	duracao int8 NULL,
	preview varchar(100) NULL,
	album_id int8 NOT NULL,
	CONSTRAINT album_detalhe_pkey PRIMARY KEY (id)
);


CREATE TABLE album_venda (
	id bigserial NOT NULL,
	valor_cashback float8  NULL,
	valor_venda float8 NULL,
	album_id int8 NOT NULL,
	venda_id int8 NOT NULL,
	CONSTRAINT album_venda_pkey PRIMARY KEY (id)
);

CREATE TABLE cashback (
	id bigserial NOT NULL,
	cashback float8 NULL,
	dia int4 NULL,
	mes int4 NULL,
	CONSTRAINT cashback_venda_pkey PRIMARY KEY (id)
);

CREATE TABLE venda (
	id bigserial NOT NULL,
	data_venda timestamp NULL,
	valor_cashback float8 NULL,
	valor_venda float8 NULL,
	CONSTRAINT venda_pkey PRIMARY KEY (id)
);