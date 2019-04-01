-- Database: postgres

-- DROP DATABASE postgres;

CREATE DATABASE postgres
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
    IS 'default administrative connection database';


-- Table: public.persons

-- DROP TABLE public.persons;

CREATE TABLE public.persons
(
    id integer NOT NULL DEFAULT nextval('persons_id_seq'::regclass),
    firstname character varying COLLATE pg_catalog."default",
    gender character varying COLLATE pg_catalog."default",
    lastname character varying COLLATE pg_catalog."default",
    birthdate date,
    CONSTRAINT persons_pk PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.persons
    OWNER to postgres;

