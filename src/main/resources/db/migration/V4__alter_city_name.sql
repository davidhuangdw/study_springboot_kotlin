ALTER TABLE cities
  ALTER COLUMN name VARCHAR NOT NULL;

ALTER TABLE cities
  ADD CONSTRAINT uc_name UNIQUE (name);

CREATE UNIQUE INDEX name_index ON cities (name);