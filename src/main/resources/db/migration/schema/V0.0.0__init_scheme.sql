


CREATE TABLE IF NOT EXISTS brand (
                                       ID SERIAL PRIMARY KEY NOT NULL,
                                       NAME VARCHAR(500) NOT NULL
    );



CREATE TABLE IF NOT EXISTS product (
                                     ID SERIAL PRIMARY KEY NOT NULL,
                                     NAME VARCHAR(500) NOT NULL
    );


CREATE TABLE IF NOT EXISTS currency (
                                    CODE VARCHAR(500) PRIMARY KEY NOT NULL,
                                     SYMBOL VARCHAR(500) NOT NULL,
                                     DECIMALS INT NOT NULL
    );


CREATE TABLE IF NOT EXISTS T_RATES (
                                       ID SERIAL PRIMARY KEY NOT NULL,
                                       BRAND_ID INT NOT NULL,
                                       PRODUCT_ID INT NOT NULL,
                                       START_DATE DATE NOT NULL,
                                       END_DATE DATE NOT NULL,
                                       PRICE INT NOT NULL,
                                       CURRENCY_CODE VARCHAR(3) NOT NULL
    );

CREATE INDEX rates_brand_id_index ON T_RATES USING btree (brand_id);
CREATE INDEX rates_product_id_index ON T_RATES USING btree (product_id);
CREATE INDEX rates_currency_code_index ON T_RATES USING btree (currency_code);

