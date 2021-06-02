--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

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

--
-- Name: postgres; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA postgres;


ALTER SCHEMA postgres OWNER TO postgres;

--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- Name: data_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.data_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.data_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: data; Type: TABLE; Schema: postgres; Owner: postgres
--

CREATE TABLE postgres.data (
    id integer DEFAULT nextval('public.data_seq'::regclass) NOT NULL,
    id_message integer NOT NULL,
    "time" date NOT NULL,
    queue_name character varying(255) NOT NULL,
    body_message character varying(255)
);


ALTER TABLE postgres.data OWNER TO postgres;

--
-- Name: data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.data (
    id integer DEFAULT nextval('public.data_seq'::regclass) NOT NULL,
    id_message integer NOT NULL,
    "time" date NOT NULL,
    queue_name character varying(255) NOT NULL,
    body_message character varying(255)
);


ALTER TABLE public.data OWNER TO postgres;

--
-- Data for Name: data; Type: TABLE DATA; Schema: postgres; Owner: postgres
--

COPY postgres.data (id, id_message, "time", queue_name, body_message) FROM stdin;
\.


--
-- Data for Name: data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.data (id, id_message, "time", queue_name, body_message) FROM stdin;
1	12	2021-05-27	1212121	121212121
10	6	2021-05-27	queue-2	0
12	6	2021-05-27	queue-1	wqfqwf
13	6	2021-05-27	queue-1	wqfqwf
16	11	2021-05-27	queue-1	wqfqwf
14	11	2021-05-27	queue-1	wqfqwf
15	11	2021-05-27	queue-1	wqfqwf
11	11	2021-05-27	queue-1	wqfqwf
17	11	2021-05-27	queue-1	wqfqwf
18	11	2021-05-27	queue-1	wqfqwf
19	11	2021-05-27	queue-1	wqfqwf
20	7	2021-05-27	queue-1	qweqweqweq
21	7	2021-05-27	queue-1	qweqweqweq
22	66	2021-05-27	queue-1	6666wf
23	67	2021-05-27	queue-2	1i7
24	87	2021-05-27	queue-2	1i7
25	77	2021-05-27	queue-2	1i7
26	67	2021-05-27	queue-2	1i7
30	67	2021-05-27	queue-2	1i7
28	676	2021-05-27	queue-1	6666wf
27	67	2021-05-27	queue-1	1i7
29	67	2021-05-27	queue-1	1i7
\.

--
-- Name: data_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.data_seq', 31, true);




