CREATE TABLE IF NOT EXISTS account (
  id SERIAL NOT NULL,
  name VARCHAR(30) UNIQUE NOT NULL,
  password VARCHAR(72) NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY (id)
);