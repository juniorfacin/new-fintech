CREATE TABLE t_bank_account (
                                id_bank_account NUMBER(5) NOT NULL,
                                id_user NUMBER(5) NOT NULL,
                                nr_bank NUMBER(5) NOT NULL,
                                nr_agency VARCHAR2(255) NOT NULL,
                                nr_account VARCHAR2(255) NOT NULL,
                                nr_account_digit VARCHAR2(5) NOT NULL
);

ALTER TABLE t_bank_account
    ADD CONSTRAINT t_bank_account_pk
        PRIMARY KEY ( id_bank_account );

CREATE TABLE t_expense_category (
                                    id_expense_category NUMBER(5) NOT NULL,
                                    ds_expense_categor VARCHAR2(255) NOT NULL
);

ALTER TABLE t_expense_category
    ADD CONSTRAINT t_expense_category_pk
        PRIMARY KEY ( id_expense_category );

CREATE TABLE t_investment_category (
                                       id_investment_category NUMBER(5) NOT NULL,
                                       ds_investment_category VARCHAR2(255) NOT NULL
);

ALTER TABLE t_investment_category
    ADD CONSTRAINT t_investment_category_pk
        PRIMARY KEY ( id_investment_category );

CREATE TABLE t_revenue_category (
                                    id_revenue_category NUMBER(5) NOT NULL,
                                    ds_revenue_category VARCHAR2(255) NOT NULL
);

ALTER TABLE t_revenue_category
    ADD CONSTRAINT t_revenue_category_pk PRIMARY KEY ( id_revenue_category );


CREATE TABLE t_expense (
                           id_transaction NUMBER(5) NOT NULL,
                           id_expense_category NUMBER(5) NOT NULL,
                           vl_expense_value NUMBER NOT NULL,
                           ds_expense_note VARCHAR2(255),
                           id_user NUMBER NOT NULL
);

ALTER TABLE t_expense
    ADD CONSTRAINT t_expense_pk
        PRIMARY KEY ( id_transaction );

CREATE TABLE t_investment (
                              id_transaction NUMBER(5) NOT NULL,
                              vl_invested NUMBER(9,2) NOT NULL,
                              ds_investment VARCHAR2(255),
                              id_investment_category NUMBER(5) NOT NULL,
                              id_user NUMBER(5) NOT NULL
);

CREATE UNIQUE INDEX t_investment_idx ON t_investment ( id_transaction ASC );

ALTER TABLE t_investment ADD CONSTRAINT t_investment_pk
    PRIMARY KEY ( id_transaction );

CREATE TABLE t_revenue_origin (
                                  id_revenue_origin NUMBER(5) NOT NULL,
                                  ds_revenue_origin VARCHAR2(255) NOT NULL
);

ALTER TABLE t_revenue_origin
    ADD CONSTRAINT t_revenue_origin_pk
        PRIMARY KEY ( id_revenue_origin );

CREATE TABLE t_revenue (
                           id_transaction NUMBER(5) NOT NULL,
                           id_revenue_category NUMBER(5) NOT NULL,
                           id_revenue_origin NUMBER(5) NOT NULL,
                           vl_revenue NUMBER(9,2) NOT NULL,
                           ds_revenue VARCHAR2(255),
                           id_user NUMBER(5) NOT NULL
);

ALTER TABLE t_revenue ADD CONSTRAINT t_revenue_pk PRIMARY KEY ( id_transaction );

CREATE TABLE t_transaction (
                               id_transaction NUMBER(5) NOT NULL,
                               id_user NUMBER(5) NOT NULL,
                               dt_transaction DATE NOT NULL
);

ALTER TABLE t_transaction
    ADD CONSTRAINT t_transaction_pk
        PRIMARY KEY ( id_transaction );

CREATE TABLE t_user (
                        id_user NUMBER(5) NOT NULL,
                        nm_user VARCHAR2(255) NOT NULL,
                        tx_email VARCHAR2(255) NOT NULL,
                        nr_cpf NUMBER(11) NOT NULL,
                        tx_password VARCHAR2(255) NOT NULL,
                        dt_creation DATE NOT NULL,
                        vl_balance NUMBER(9,2) NOT NULL
);

ALTER TABLE t_user ADD CONSTRAINT t_user_pk PRIMARY KEY ( id_user );

-- CHAVES ESTRANGEIRAS
ALTER TABLE t_bank_account
    ADD CONSTRAINT fk_user_bank_account FOREIGN KEY ( id_user )
        REFERENCES t_user ( id_user );

ALTER TABLE t_revenue
    ADD CONSTRAINT fk_revenue_category FOREIGN KEY ( id_revenue_category )
        REFERENCES t_revenue_category ( id_revenue_category);

ALTER TABLE t_expense
    ADD CONSTRAINT fk_expense_category FOREIGN KEY ( id_expense_category )
        REFERENCES t_expense_category ( id_expense_category );

/*

ALTER TABLE t_revenue
    ADD CONSTRAINT fk_revenue_origin FOREIGN KEY ( id_revenue_origin )
    REFERENCES t_revenue_origin ( id_revenue_origin );
*/

ALTER TABLE t_revenue
    ADD CONSTRAINT fk_transaction_revenue FOREIGN KEY (id_transaction)
        REFERENCES t_transaction (id_transaction);

ALTER TABLE t_expense
    ADD CONSTRAINT fk_transaction_expense FOREIGN KEY ( id_transaction )
        REFERENCES t_transaction ( id_transaction );

ALTER TABLE t_investment
    ADD CONSTRAINT fk_transaction_investment FOREIGN KEY ( id_transaction )
        REFERENCES t_transaction ( id_transaction );

ALTER TABLE t_transaction
    ADD CONSTRAINT fk_user_transaction FOREIGN KEY ( id_user )
        REFERENCES t_user ( id_user );

ALTER TABLE t_investment
    ADD CONSTRAINT fk_investment_category FOREIGN KEY ( id_investment_category )
        REFERENCES t_investment_category ( id_investment_category );