CREATE TABLE if not exists account (
  id SERIAL NOT NULL,
  name varchar(30) NOT NULL UNIQUE,
  password varchar(16) NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY (id)
);