-- Apagar constraints de chaves estrangeiras
ALTER TABLE t_bank_account DROP CONSTRAINT fk_user_bank_account;
ALTER TABLE t_expense DROP CONSTRAINT fk_expense_category;
ALTER TABLE t_expense DROP CONSTRAINT fk_transaction_expense;
ALTER TABLE t_investment DROP CONSTRAINT fk_investment_category;
ALTER TABLE t_investment DROP CONSTRAINT fk_transaction_investment;
ALTER TABLE t_revenue DROP CONSTRAINT fk_revenue_category;
ALTER TABLE t_revenue DROP CONSTRAINT fk_transaction_revenue;
ALTER TABLE t_transaction DROP CONSTRAINT fk_user_transaction;

-- Apagar tabelas
DROP TABLE t_bank_account CASCADE CONSTRAINTS;
DROP TABLE t_expense CASCADE CONSTRAINTS;
DROP TABLE t_expense_category CASCADE CONSTRAINTS;
DROP TABLE t_investment CASCADE CONSTRAINTS;
DROP TABLE t_investment_category CASCADE CONSTRAINTS;
DROP TABLE t_revenue CASCADE CONSTRAINTS;
DROP TABLE t_revenue_category CASCADE CONSTRAINTS;
DROP TABLE t_revenue_origin CASCADE CONSTRAINTS;
DROP TABLE t_transaction CASCADE CONSTRAINTS;
DROP TABLE t_user CASCADE CONSTRAINTS;

CREATE TABLE t_user
(
    id_user     NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    nm_user     VARCHAR2(255),
    tx_email    VARCHAR2(255),
    nr_cpf      VARCHAR2(11),
    tx_password VARCHAR2(255),
    dt_creation DATE,
    CONSTRAINT t_user_pk PRIMARY KEY (id_user)
);

CREATE TABLE t_bank_account
(
    id_bank_account  NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_user          NUMBER(5),
    nm_bank          VARCHAR2(255),
    nr_bank          NUMBER(5),
    nr_agency        VARCHAR2(255),
    nr_account       VARCHAR2(255),
    nr_account_digit VARCHAR2(255),
    CONSTRAINT t_bank_account_pk PRIMARY KEY (id_bank_account)
);

ALTER TABLE t_bank_account
    ADD CONSTRAINT fk_user_bank_account FOREIGN KEY (id_user)
        REFERENCES t_user (id_user);

CREATE TABLE t_expense_category
(
    id_expense_category NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    ds_expense_category VARCHAR2(255),
    CONSTRAINT t_expense_category_pk PRIMARY KEY (id_expense_category)
);

CREATE TABLE t_investment_category
(
    id_investment_category NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    ds_investment_category VARCHAR2(255),
    CONSTRAINT t_investment_category_pk PRIMARY KEY (id_investment_category)
);

CREATE TABLE t_revenue_category
(
    id_revenue_category NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    ds_revenue_category VARCHAR2(255),
    CONSTRAINT t_revenue_category_pk PRIMARY KEY (id_revenue_category)
);

CREATE TABLE t_transaction
(
    id_transaction NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_user        NUMBER(5),
    dt_transaction DATE,
    CONSTRAINT t_transaction_pk PRIMARY KEY (id_transaction),
    CONSTRAINT fk_user_transaction FOREIGN KEY (id_user)
        REFERENCES t_user (id_user)
);

CREATE TABLE t_expense
(
    id_transaction      NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_expense_category NUMBER(5),
    vl_expense_value    NUMBER(9, 2),
    ds_expense_note     VARCHAR2(255),
    id_user             NUMBER(5),
    CONSTRAINT t_expense_pk PRIMARY KEY (id_transaction),
    CONSTRAINT fk_expense_category FOREIGN KEY (id_expense_category)
        REFERENCES t_expense_category (id_expense_category),
    CONSTRAINT fk_transaction_expense FOREIGN KEY (id_transaction)
        REFERENCES t_transaction (id_transaction)
);

CREATE TABLE t_investment
(
    id_transaction         NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    vl_invested            NUMBER(9, 2),
    ds_investment          VARCHAR2(255),
    id_investment_category NUMBER(5),
    id_user                NUMBER(5),
    CONSTRAINT t_investment_pk PRIMARY KEY (id_transaction),
    CONSTRAINT fk_investment_category FOREIGN KEY (id_investment_category)
        REFERENCES t_investment_category (id_investment_category),
    CONSTRAINT fk_transaction_investment FOREIGN KEY (id_transaction)
        REFERENCES t_transaction (id_transaction)
);

CREATE TABLE t_revenue_origin
(
    id_revenue_origin NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    ds_revenue_origin VARCHAR2(255),
    CONSTRAINT t_revenue_origin_pk PRIMARY KEY (id_revenue_origin)
);

CREATE TABLE t_revenue
(
    id_transaction      NUMBER(5) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_revenue_category NUMBER(5),
    id_revenue_origin   NUMBER(5),
    vl_revenue          NUMBER(9, 2),
    ds_revenue          VARCHAR2(255),
    id_user             NUMBER(5),
    CONSTRAINT t_revenue_pk PRIMARY KEY (id_transaction),
    CONSTRAINT fk_revenue_category FOREIGN KEY (id_revenue_category)
        REFERENCES t_revenue_category (id_revenue_category),
    CONSTRAINT fk_transaction_revenue FOREIGN KEY (id_transaction)
        REFERENCES t_transaction (id_transaction)
);