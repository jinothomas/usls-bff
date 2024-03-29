-- liquibase formatted sql

-- changeset jinothomas:3	
CREATE TABLE USLS_PERMISSIONS
(
	ID SERIAL PRIMARY KEY,
	NAME CHARACTER VARYING NOT NULL,
	TYPE CHARACTER VARYING NOT NULL,
	ROLE_ID BIGINT NOT NULL,
	DESCRIPTION CHARACTER VARYING NOT NULL,
	CREATED_BY CHARACTER VARYING,
	LAST_MODIFIED_BY CHARACTER VARYING,
	CREATED_DATE TIMESTAMP WITHOUT TIME ZONE,
	LAST_MODIFIED_DATE TIMESTAMP WITHOUT TIME ZONE,
	CONSTRAINT FK_ROLE FOREIGN KEY(ROLE_ID) REFERENCES USLS_ROLES(ID)
);