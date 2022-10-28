toc.dat                                                                                             0000600 0004000 0002000 00000013150 14326767143 0014454 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       /    ;            	    z            market-autumn    14.5    14.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    17853    market-autumn    DATABASE     l   CREATE DATABASE "market-autumn" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "market-autumn";
                postgres    false         �            1259    17861 	   customers    TABLE     e   CREATE TABLE public.customers (
    id integer NOT NULL,
    name character varying(150) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false         �            1259    17860    Costumers_id_seq    SEQUENCE     �   ALTER TABLE public.customers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Costumers_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212         �            1259    17866    customers_products    TABLE     n   CREATE TABLE public.customers_products (
    customer_id integer NOT NULL,
    product_id integer NOT NULL
);
 &   DROP TABLE public.customers_products;
       public         heap    postgres    false         �            1259    17855    products    TABLE     �   CREATE TABLE public.products (
    id integer NOT NULL,
    title character varying(150) NOT NULL,
    price integer NOT NULL
);
    DROP TABLE public.products;
       public         heap    postgres    false         �            1259    17854    products_id_seq    SEQUENCE     �   ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210         �          0    17861 	   customers 
   TABLE DATA           -   COPY public.customers (id, name) FROM stdin;
    public          postgres    false    212       3325.dat �          0    17866    customers_products 
   TABLE DATA           E   COPY public.customers_products (customer_id, product_id) FROM stdin;
    public          postgres    false    213       3326.dat �          0    17855    products 
   TABLE DATA           4   COPY public.products (id, title, price) FROM stdin;
    public          postgres    false    210       3323.dat            0    0    Costumers_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."Costumers_id_seq"', 3, true);
          public          postgres    false    211                    0    0    products_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.products_id_seq', 8, true);
          public          postgres    false    209         h           2606    17865    customers Customers_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT "Customers_pkey" PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.customers DROP CONSTRAINT "Customers_pkey";
       public            postgres    false    212         j           2606    17870 *   customers_products customers_products_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT customers_products_pkey PRIMARY KEY (customer_id, product_id);
 T   ALTER TABLE ONLY public.customers_products DROP CONSTRAINT customers_products_pkey;
       public            postgres    false    213    213         f           2606    17859    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    210         k           1259    17876    fki_costumer_fkey    INDEX     W   CREATE INDEX fki_costumer_fkey ON public.customers_products USING btree (customer_id);
 %   DROP INDEX public.fki_costumer_fkey;
       public            postgres    false    213         l           1259    17882    fki_fki_product_fkey    INDEX     Y   CREATE INDEX fki_fki_product_fkey ON public.customers_products USING btree (product_id);
 (   DROP INDEX public.fki_fki_product_fkey;
       public            postgres    false    213         m           2606    17871 $   customers_products fki_costumer_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_costumer_fkey FOREIGN KEY (customer_id) REFERENCES public.customers(id) NOT VALID;
 N   ALTER TABLE ONLY public.customers_products DROP CONSTRAINT fki_costumer_fkey;
       public          postgres    false    212    213    3176         n           2606    17877 #   customers_products fki_product_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_product_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) NOT VALID;
 M   ALTER TABLE ONLY public.customers_products DROP CONSTRAINT fki_product_fkey;
       public          postgres    false    213    3174    210                                                                                                                                                                                                                                                                                                                                                                                                                                3325.dat                                                                                            0000600 0004000 0002000 00000000033 14326767143 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	John
2	Kevin
3	Mike
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     3326.dat                                                                                            0000600 0004000 0002000 00000000051 14326767143 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1
1	4
3	3
3	2
3	8
3	7
2	7
2	6
3	5
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       3323.dat                                                                                            0000600 0004000 0002000 00000000144 14326767143 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        3	Orange	100
5	Tea	50
6	Spaghetti	70
7	Chips	100
8	Juice	120
1	Bread	50
2	Milk	80
4	Cheese	250
\.


                                                                                                                                                                                                                                                                                                                                                                                                                            restore.sql                                                                                         0000600 0004000 0002000 00000011732 14326767143 0015405 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

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

DROP DATABASE "market-autumn";
--
-- Name: market-autumn; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "market-autumn" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "market-autumn" OWNER TO postgres;

\connect -reuse-previous=on "dbname='market-autumn'"

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

--
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    id integer NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- Name: Costumers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.customers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Costumers_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: customers_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers_products (
    customer_id integer NOT NULL,
    product_id integer NOT NULL
);


ALTER TABLE public.customers_products OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    title character varying(150) NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customers (id, name) FROM stdin;
\.
COPY public.customers (id, name) FROM '$$PATH$$/3325.dat';

--
-- Data for Name: customers_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customers_products (customer_id, product_id) FROM stdin;
\.
COPY public.customers_products (customer_id, product_id) FROM '$$PATH$$/3326.dat';

--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, title, price) FROM stdin;
\.
COPY public.products (id, title, price) FROM '$$PATH$$/3323.dat';

--
-- Name: Costumers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Costumers_id_seq"', 3, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 8, true);


--
-- Name: customers Customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT "Customers_pkey" PRIMARY KEY (id);


--
-- Name: customers_products customers_products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT customers_products_pkey PRIMARY KEY (customer_id, product_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: fki_costumer_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_costumer_fkey ON public.customers_products USING btree (customer_id);


--
-- Name: fki_fki_product_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fki_product_fkey ON public.customers_products USING btree (product_id);


--
-- Name: customers_products fki_costumer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_costumer_fkey FOREIGN KEY (customer_id) REFERENCES public.customers(id) NOT VALID;


--
-- Name: customers_products fki_product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers_products
    ADD CONSTRAINT fki_product_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      