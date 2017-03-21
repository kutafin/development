CREATE TABLE shorturl(
  idUrl INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  url VARCHAR(255) NOT NULL,
  shortUrl VARCHAR(45) NOT NULL,
  description VARCHAR(255),
  views INT,
  id INT,
  idTag INT
);

CREATE TABLE roles(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE tags(
  idTag INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tagname VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles(
  user_id INT NOT NUll,
  role_id INT NOT NULL,
  INDEX user_roles(role_id ASC),
  UNIQUE INDEX user_roles(user_id ASC, role_id ASC),
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(role_id) REFERENCES roles(id)
);

INSERT INTO users VALUES (1, 'webadmin', '$2a$11$owR7RKuWOXtVzBFEMtjWeuvMHKElTaZFt.X6iISliglHLFsEMnXre');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);




