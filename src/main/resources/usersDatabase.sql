-- CREATE DATABASE BookLibrary CHARACTER SET utf8;

-- Table: users
CREATE TABLE BookLibrary.users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

-- Table: roles
CREATE TABLE BookLibrary.roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE BookLibrary.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES BookLibrary.users (id),
  FOREIGN KEY (role_id) REFERENCES BookLibrary.roles (id),

  UNIQUE (user_id, role_id)
);

-- Insert data
INSERT INTO BookLibrary.users VALUES (1, 'user1', '1234');
INSERT INTO BookLibrary.users VALUES (2, 'user2', '2345');
INSERT INTO BookLibrary.users VALUES (3, 'admin1', '3456');
INSERT INTO BookLibrary.users VALUES (4, 'admin2', '4567');

INSERT INTO BookLibrary.roles VALUES (1, 'ROLE_USER');
INSERT INTO BookLibrary.roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO BookLibrary.user_roles VALUES (1, 1);
INSERT INTO BookLibrary.user_roles VALUES (2, 1);
INSERT INTO BookLibrary.user_roles VALUES (3, 2);
INSERT INTO BookLibrary.user_roles VALUES (4, 2);
INSERT INTO BookLibrary.user_roles VALUES (3, 1);
INSERT INTO BookLibrary.user_roles VALUES (4, 1);