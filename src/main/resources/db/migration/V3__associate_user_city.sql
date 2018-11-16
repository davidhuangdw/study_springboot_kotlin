ALTER TABLE users
  ADD city_id INT;
ALTER TABLE users
  ADD FOREIGN KEY (city_id) REFERENCES cities(id);