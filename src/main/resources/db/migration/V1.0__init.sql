CREATE TABLE Cliente (
  id      SERIAL PRIMARY KEY,
  nombres  VARCHAR(255) NOT NULL,
  apellidos  VARCHAR(255) NOT NULL, 
 nacimiento timestamp default NULL, 
 edad 	  int
);
