-- liquibase formatted sql

-- changeset jinothomas:1	
CREATE TABLE IF NOT EXISTS USLS_USERS
(
	USER_ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 99999999999 CACHE 1 ),
	USER_NAME CHARACTER VARYING NOT NULL,
	EMAIL CHARACTER VARYING NOT NULL,
	DEPARTMENT CHARACTER VARYING NOT NULL ,
	MOBILE_NUMBER CHARACTER VARYING,
	STATUS CHARACTER VARYING,
	CREATED_DATE TIMESTAMP WITHOUT TIME ZONE,
	LAST_UPDATED_DATE TIMESTAMP WITHOUT TIME ZONE
);