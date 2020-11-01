/*CREATE TABLE user_entity  (
     id           UUID         NOT NULL,
     email        VARCHAR(100) NOT NULL,
     username     VARCHAR(100) NOT NULL,
     phone_number VARCHAR(100) NOT NULL,
     blocked      BOOLEAN      NOT NULL,

     CONSTRAINT pk_user_entity PRIMARY KEY (id),
     CONSTRAINT unique_user_entity_username UNIQUE (username),
     CONSTRAINT unique_user_entity_phone_number UNIQUE (phone_number),
     CONSTRAINT unique_user_entity_email UNIQUE (email)
  );*/