create table CAR (
  id IDENTITY primary key,
  power DOUBLE
);

create table AIRPLANE (
  id IDENTITY primary key,
  manufacturer VARCHAR2(500),
  fuelCapacity INT,
  seats INT
);