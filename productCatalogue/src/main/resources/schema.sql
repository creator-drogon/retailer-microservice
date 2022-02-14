  DROP TABLE IF EXISTS product;

  CREATE TABLE product (

  productId LONG NOT NULL AUTO_INCREMENT,

  productName VARCHAR(100),

  productDescription VARCHAR(100),

  productPrice double

  );