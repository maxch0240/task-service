--liquibase formatted sql
--changeSet dev_0001:001-01

INSERT INTO users (full_name, email)
values ('Maksim', 'maxch.0240@gmail.com');