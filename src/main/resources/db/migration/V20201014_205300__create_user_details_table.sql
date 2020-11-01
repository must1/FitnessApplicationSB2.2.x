CREATE TABLE user_details (
    id            UUID           NOT NULL,
    password      VARCHAR(100)   NOT NULL,
    username      VARCHAR(100)   NOT NULL,

    CONSTRAINT pk_user_details PRIMARY KEY (id),
    CONSTRAINT unique_user_details_username UNIQUE (username)
);

CREATE TABLE permission (
  user_id                  UUID            NOT NULL,
  permission_name          VARCHAR(100)    NOT NULL,

  CONSTRAINT unique_user_id_name UNIQUE (user_id, permission_name),
  CONSTRAINT fk_permission_id_user_details_id FOREIGN KEY (user_id) REFERENCES user_details(id)
);