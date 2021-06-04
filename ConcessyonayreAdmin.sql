/*CUSTOMER*/
INSERT INTO `concessyonarye`.`customer` (`id`, `address`, `bankaccount`, `dni`, `fullname`, `tlf`) 
VALUES ('4', 'xxxxx', 'xx00000000', 'x00000000', 'xxxx xxxx', '000000000');

INSERT INTO `concessyonarye`.`user` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('4', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'yiyi', '4');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('4', 'CUSTOM');

/*ADMIN*/
INSERT INTO `concessyonarye`.`customer` (`id`) 
VALUES ('1');

INSERT INTO `concessyonarye`.`user` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('1', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'admin', '1');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('1', 'ADMIN');

/*SELLER*/
INSERT INTO `concessyonarye`.`customer` (`id`) 
VALUES ('3');

INSERT INTO `concessyonarye`.`user` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('3', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'seller', '3');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('3', 'SELLER');

/*MECHANIC*/
INSERT INTO `concessyonarye`.`customer` (`id`) 
VALUES ('2');

INSERT INTO `concessyonarye`.`user` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('2', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'mechanic', '2');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('2', 'MECHANIC');

/*Categories*/
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('1', 'URBANO', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('2', 'SUBCOMPACTO', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('3', 'HATCHBACK', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('4', 'FAMILIAR', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('5', 'SEDÁN', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('6', 'BERLINA', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('7', 'COUPÉ', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('8', 'MONOVOLUMEN', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('9', 'MUSCLECAR', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`category` (`id`, `categoryName`, `startDate`)
VALUES ('10', 'PICKUP', '2021-01-01 00:00:00');

/*Brands*/
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`) 
VALUES ('1', 'TOYOTA', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('2', 'RENAULT', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('3', 'FORD', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('4', 'SEAT', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('5', 'HYUNDAI', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('6', 'PEUGEOT', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('7', 'OPEL', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('8', 'NISSAN', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('9', 'BMW', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('10', 'AUDI', '2021-01-01 00:00:00');
INSERT INTO `concessyonarye`.`brand` (`id`, `brandName`, `startDate`)
VALUES ('11', 'KIA', '2021-01-01 00:00:00');

/*Models*/
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('1', 'AYGO', '2021-01-01 00:00:00', '1', '1');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('2', 'CAPTUR', '2021-01-01 00:00:00', '2', '2');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('3', 'FOCUS', '2021-01-01 00:00:00', '3', '3');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('4', 'RIO', '2021-01-01 00:00:00', '11', '2');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('5', 'ASTRA', '2021-01-01 00:00:00', '7', '3');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('6', 'LEÓN ST', '2021-01-01 00:00:00', '4', '4');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('7', 'A3', '2021-01-01 00:00:00', '10', '5');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('8', 'A8L', '2021-01-01 00:00:00', '10', '6');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('9', 'SERIE 2', '2021-01-01 00:00:00', '9', '7');
INSERT INTO `concessyonarye`.`model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('10', 'MUSTANG', '2021-01-01 00:00:00', '3', '9');

/*Vehicles*/
INSERT INTO `concessyonarye`.`vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('1', '120000', '1', '2', '5');
INSERT INTO `concessyonarye`.`vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('2', '245000', '2', '4', '4');
INSERT INTO `concessyonarye`.`vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('3', '640000', '3', '4', '2');
INSERT INTO `concessyonarye`.`vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('4', '890000', '4', '5', '6');
INSERT INTO `concessyonarye`.`vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('5', '60000', '5', '6', '8');

/*Promotion*/
INSERT INTO `concessyonarye`.`promotion` (`id`, `discountPercent`, `promoname`, `startDate`) 
VALUES ('1', '25', 'YILOOL', '2021-01-01 00:00:00');
