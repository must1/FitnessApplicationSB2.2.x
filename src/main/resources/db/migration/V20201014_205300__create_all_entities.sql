CREATE TABLE product_entity  (
     id                             UUID                NOT NULL,
     type                           VARCHAR(100)        NOT NULL,
     name                           VARCHAR(100)        NOT NULL,
     kcal_number_per100g              DOUBLE PRECISION    NOT NULL,
     fat_number_per100g               DOUBLE PRECISION    NOT NULL,
     protein_number_per100g           DOUBLE PRECISION    NOT NULL,
     carbohydrates_number_per100g     DOUBLE PRECISION    NOT NULL,

     CONSTRAINT pk_product_entity PRIMARY KEY (id)
  );

CREATE TABLE user_message_entity  (
     id                 UUID            NOT NULL,
     user_id             UUID            NOT NULL,
     message            VARCHAR(250)    NOT NULL,
     is_acknowledged     BOOLEAN         NOT NULL,
     creation_time       DATE            NOT NULL,

     CONSTRAINT pk_user_message_entity PRIMARY KEY (id)
  );

CREATE TABLE user_entity  (
     id                 UUID            NOT NULL,
     first_name          VARCHAR(100)    NOT NULL,
     last_name           VARCHAR(100)    NOT NULL,
     username           VARCHAR(100)    NOT NULL,
     password           VARCHAR(100)    NOT NULL,
     email              VARCHAR(100)    NOT NULL,
     body_part_type       VARCHAR(100)    NOT NULL,
     phone_number        VARCHAR(100)    NOT NULL,

     CONSTRAINT pk_user_entity PRIMARY KEY (id)
  );

CREATE TABLE user_product_entity  (
     id                          UUID               NOT NULL,
     name                           VARCHAR(100)        NOT NULL,
     user_id                      UUID               NOT NULL,
     gram                        DOUBLE PRECISION   NOT NULL,
     fat_number                   DOUBLE PRECISION   NOT NULL,
     protein_number               DOUBLE PRECISION   NOT NULL,
     carbohydrates_number         DOUBLE PRECISION   NOT NULL,
     kcal_number                  DOUBLE PRECISION   NOT NULL,
     date_of_eaten_product          DATE               NOT NULL,

     CONSTRAINT pk_user_product_entity PRIMARY KEY (id)
  );

CREATE TABLE exercise_entity  (
     id                              UUID            NOT NULL,
     name                            VARCHAR(100)    NOT NULL,
     body_part_type                    VARCHAR(100)    NOT NULL,
     exercise_description             VARCHAR(100)    NOT NULL,

     CONSTRAINT pk_exercise_entity PRIMARY KEY (id)
  );

CREATE TABLE permission (
  user_id                  UUID            NOT NULL,
  permission_name          VARCHAR(100)    NOT NULL,

  CONSTRAINT unique_user_id_name UNIQUE (user_id, permission_name),
  CONSTRAINT fk_permission_id_user_details_id FOREIGN KEY (user_id) REFERENCES user_entity(id)
);