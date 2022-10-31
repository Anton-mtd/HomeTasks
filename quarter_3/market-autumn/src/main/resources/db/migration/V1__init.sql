SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;



CREATE TABLE public.customers (
                                  id integer NOT NULL,
                                  name character varying(150) NOT NULL
);
ALTER TABLE public.customers OWNER TO postgres;
ALTER TABLE public.customers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Costumers_id_seq"
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );



CREATE TABLE public.customers_products (
                                           customer_id integer NOT NULL,
                                           product_id integer NOT NULL
);
ALTER TABLE public.customers_products OWNER TO postgres;



CREATE TABLE public.products (
                                 id integer NOT NULL,
                                 title character varying(150) NOT NULL,
                                 price integer NOT NULL
);
ALTER TABLE public.products OWNER TO postgres;
ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


ALTER TABLE ONLY public.customers
    ADD CONSTRAINT "Customers_pkey" PRIMARY KEY (id);

ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT customers_products_pkey PRIMARY KEY (customer_id, product_id);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


CREATE INDEX fki_costumer_fkey ON public.customers_products USING btree (customer_id);
CREATE INDEX fki_fki_product_fkey ON public.customers_products USING btree (product_id);
ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_costumer_fkey FOREIGN KEY (customer_id) REFERENCES public.customers(id) NOT VALID;
ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_product_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) NOT VALID;




