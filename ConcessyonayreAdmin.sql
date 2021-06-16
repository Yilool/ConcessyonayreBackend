   alter table Model 
       drop 
       foreign key FKs1nbkhrrlf37dgo824p6vd8cq;
    
    alter table Model 
       drop 
       foreign key FKiu7vkhrkogpwhop1n641ldmbx;
    
    alter table Purchase 
       drop 
       foreign key FK15nvfxt1otlr20atpbi9c2uo3;
    
    alter table Purchase 
       drop 
       foreign key FKrnoj84jo9blx12nn23g0fuo4j;
    
    alter table Purchase 
       drop 
       foreign key FK4fsewjf2bnej66rlbkx5m54ai;
    
    alter table Rating 
       drop 
       foreign key FK7tfmfkceajrj12cyrvfvwonr3;
    
    alter table Rating 
       drop 
       foreign key FKtdmhm4behbjyy3utyg9ecurqn;
    
    alter table Rental 
       drop 
       foreign key FK7fd15xuygl8u0ok57877tn001;
    
    alter table Rental 
       drop 
       foreign key FKqny23thgydw3ymr3lxsctbhfj;
    
    alter table Rental 
       drop 
       foreign key FK3nvtot86sfgvx070a45k1ml4p;
    
    alter table User 
       drop 
       foreign key FKm3op26hmmocym6uffpmf59682;
    
    alter table User_roles 
       drop 
       foreign key FKi81fp6mx433heb7dvbxqaqvpv;
    
    alter table Vehicle 
       drop 
       foreign key FK2utprsuhc7wyhwyk4ppsdqjak;
    
    drop table if exists Brand;
    
    drop table if exists Category;
    
    drop table if exists Customer;
    
    drop table if exists Model;
    
    drop table if exists Promotion;
    
    drop table if exists Purchase;
    
    drop table if exists Rating;
    
    drop table if exists Rental;
    
    drop table if exists User;
    
    drop table if exists User_roles;
    
    drop table if exists Vehicle; 
    
    create table Brand (
       id integer not null auto_increment,
        brandName varchar(255),
        finishDate date,
        startDate date,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Category (
       id integer not null auto_increment,
        categoryName varchar(255),
        finishDate date,
        startDate date,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Customer (
       id integer not null auto_increment,
        address varchar(255),
        bankaccount varchar(255),
        dni varchar(255),
        fullname varchar(255),
        tlf varchar(255),
        primary key (id)
    ) engine=InnoDB; 
    
    create table Model (
       id integer not null auto_increment,
        finishDate date,
        modelName varchar(255),
        startDate date,
        brand_id integer not null,
        category_id integer not null,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Promotion (
       id integer not null auto_increment,
        discountPercent integer not null,
        finishDate date,
        promoname varchar(255),
        startDate date,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Purchase (
       id integer not null auto_increment,
        finalPaymentDate date,
        finalPrice double precision not null,
        purchaseDate date,
        customer_id integer not null,
        promotion_id integer not null,
        vehicle_id integer not null,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Rating (
       id integer not null auto_increment,
        comment varchar(255),
        rate integer not null,
        CustomerId integer,
        VehicleId integer,
        primary key (id)
    ) engine=InnoDB; 
    
    create table Rental (
       id integer not null auto_increment,
        finalPrice double precision not null,
        rentalDate date,
        returnDate date,
        customer_id integer not null,
        promotion_id integer not null,
        vehicle_id integer not null,
        primary key (id)
    ) engine=InnoDB; 
    
    create table User (
       id integer not null auto_increment,
        authenticationAttempts integer not null,
        createTime datetime,
        deleteTime datetime,
        lastPasswordChange datetime,
        password varchar(255),
        passwordPolicyExpDate datetime,
        username varchar(255),
        customer_id integer not null,
        primary key (id)
    ) engine=InnoDB; 
    
    create table User_roles (
       User_id integer not null,
        roles varchar(255)
    ) engine=InnoDB; 
    
    create table Vehicle (
       id integer not null auto_increment,
        basePrice double precision not null,
        enrollment varchar(255),
        fuel integer,
        imagen longblob,
        userseats integer not null,
        model_id integer not null,
        primary key (id)
    ) engine=InnoDB; 
    
    alter table Brand 
       add constraint UK_8mw73aryipaafhvqpgt1ioud4 unique (brandName); 
    
    alter table Category 
       add constraint UK_ncao9f1p4pk8d9abqnbyhwo65 unique (categoryName);
    
    alter table Customer 
       add constraint UK_6w7t6dcxxn9lfmlfyh2vv983d unique (bankaccount); 
    
    alter table Customer 
       add constraint UK_lvt35vd1qvq9amhgnq4l3uxww unique (dni); 
    
    alter table Customer 
       add constraint UK_4cnlpfbnwd2yie69ahc3v10ox unique (fullname); 
    
    alter table Customer 
       add constraint UK_sv6adi3fdxsibn65hoslomm14 unique (tlf); 
    
    alter table Model 
       add constraint UK_dxke0648321juy7wfsl0hxk9b unique (modelName); 
    
    alter table Promotion 
       add constraint UK_t94lprhwoskv3wbtgtgfklmib unique (promoname); 
    
    alter table Purchase 
       add constraint UK_nwftn1sjj1474cwwcs6r1nt9l unique (vehicle_id); 
    
    alter table Rental 
       add constraint UK_1a13baroy8lvro6ls2njsgrui unique (vehicle_id); 
    
    alter table User 
       add constraint UK_9e9cc1gv8n2eqpkmmmfwnu8n3 unique (customer_id); 
    
    alter table User 
       add constraint UK_jreodf78a7pl5qidfh43axdfb unique (username); 
    
    alter table Vehicle 
       add constraint UK_6n8ekjxkecq48897jfvgrw1gg unique (enrollment); 
    
    alter table Model 
       add constraint FKs1nbkhrrlf37dgo824p6vd8cq 
       foreign key (brand_id) 
       references Brand (id); 
    
    alter table Model 
       add constraint FKiu7vkhrkogpwhop1n641ldmbx 
       foreign key (category_id) 
       references Category (id); 
    
    alter table Purchase 
       add constraint FK15nvfxt1otlr20atpbi9c2uo3 
       foreign key (customer_id) 
       references Customer (id); 
    
    alter table Purchase 
       add constraint FKrnoj84jo9blx12nn23g0fuo4j 
       foreign key (promotion_id) 
       references Promotion (id);
    
    alter table Purchase 
       add constraint FK4fsewjf2bnej66rlbkx5m54ai 
       foreign key (vehicle_id) 
       references Vehicle (id); 
    
    alter table Rating 
       add constraint FK7tfmfkceajrj12cyrvfvwonr3 
       foreign key (CustomerId) 
       references Customer (id); 
    
    alter table Rating 
       add constraint FKtdmhm4behbjyy3utyg9ecurqn 
       foreign key (VehicleId) 
       references Vehicle (id); 
    
    alter table Rental 
       add constraint FK7fd15xuygl8u0ok57877tn001 
       foreign key (customer_id) 
       references Customer (id); 
    
    alter table Rental 
       add constraint FKqny23thgydw3ymr3lxsctbhfj 
       foreign key (promotion_id) 
       references Promotion (id);
       
    alter table Rental 
       add constraint FK3nvtot86sfgvx070a45k1ml4p 
       foreign key (vehicle_id) 
       references Vehicle (id);                    
    
    alter table User 
       add constraint FKm3op26hmmocym6uffpmf59682 
       foreign key (customer_id) 
       references Customer (id);
    
    alter table User_roles 
       add constraint FKi81fp6mx433heb7dvbxqaqvpv 
       foreign key (User_id) 
       references User (id);
    
    alter table Vehicle 
       add constraint FK2utprsuhc7wyhwyk4ppsdqjak 
       foreign key (model_id) 
       references Model (id);
       
       
       
/*CUSTOMER*/
INSERT INTO `Concessyonarye`.`Customer` (`id`, `address`, `bankaccount`, `dni`, `fullname`, `tlf`) 
VALUES ('4', 'xxxxx', 'xx00000000', 'x00000000', 'xxxx xxxx', '000000000');

INSERT INTO `Concessyonarye`.`User` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('4', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'yiyi', '4');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('4', 'CUSTOM');

/*ADMIN*/
INSERT INTO `Concessyonarye`.`Customer` (`id`) 
VALUES ('1');

INSERT INTO `Concessyonarye`.`User` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('1', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'admin', '1');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('1', 'ADMIN');

/*SELLER*/
INSERT INTO `Concessyonarye`.`Customer` (`id`) 
VALUES ('3');

INSERT INTO `Concessyonarye`.`User` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('3', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'seller', '3');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('3', 'SELLER');

/*MECHANIC*/
INSERT INTO `Concessyonarye`.`Customer` (`id`) 
VALUES ('2');

INSERT INTO `Concessyonarye`.`User` (`id`, `authenticationAttempts`, `createTime`, 
`lastPasswordChange`, `password`, `passwordPolicyExpDate`, `username`, `customer_id`) 
VALUES ('2', '0', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 
'$2a$10$QskCb2yBJSR5Ldhv7nYRbu39.6Gjk3GPd0Jl37zXHver0rzhgRyd6', '2030-01-01 00:00:00', 'mechanic', '2');

INSERT INTO `Concessyonarye`.`User_roles` (`User_id`, `roles`) 
VALUES ('2', 'MECHANIC');

/*Categories*/
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('1', 'URBANO', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('2', 'SUBCOMPACTO', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('3', 'HATCHBACK', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('4', 'FAMILIAR', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('5', 'SEDÁN', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('6', 'BERLINA', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('7', 'COUPÉ', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('8', 'MONOVOLUMEN', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('9', 'MUSCLECAR', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Category` (`id`, `categoryName`, `startDate`)
VALUES ('10', 'PICKUP', '2021-01-01 00:00:00');

/*Brands*/
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`) 
VALUES ('1', 'TOYOTA', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('2', 'RENAULT', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('3', 'FORD', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('4', 'SEAT', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('5', 'HYUNDAI', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('6', 'PEUGEOT', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('7', 'OPEL', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('8', 'NISSAN', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('9', 'BMW', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('10', 'AUDI', '2021-01-01 00:00:00');
INSERT INTO `Concessyonarye`.`Brand` (`id`, `brandName`, `startDate`)
VALUES ('11', 'KIA', '2021-01-01 00:00:00');

/*Models*/
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('1', 'AYGO', '2021-01-01 00:00:00', '1', '1');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('2', 'CAPTUR', '2021-01-01 00:00:00', '2', '2');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('3', 'FOCUS', '2021-01-01 00:00:00', '3', '3');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('4', 'RIO', '2021-01-01 00:00:00', '11', '2');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('5', 'ASTRA', '2021-01-01 00:00:00', '7', '3');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('6', 'LEÓN ST', '2021-01-01 00:00:00', '4', '4');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('7', 'A3', '2021-01-01 00:00:00', '10', '5');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('8', 'A8L', '2021-01-01 00:00:00', '10', '6');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('9', 'SERIE 2', '2021-01-01 00:00:00', '9', '7');
INSERT INTO `Concessyonarye`.`Model` (`id`, `modelName`, `startDate`, `brand_id`, `category_id`) 
VALUES ('10', 'MUSTANG', '2021-01-01 00:00:00', '3', '9');

/*Vehicles: vehicle añadir a mano, problemas de imagen a partir de script y no funciona
INSERT INTO `Concessyonarye`.`Vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('1', '120000', '1', '2', '5');
INSERT INTO `Concessyonarye`.`Vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('2', '245000', '2', '4', '4');
INSERT INTO `Concessyonarye`.`Vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('3', '640000', '3', '4', '2');
INSERT INTO `Concessyonarye`.`Vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('4', '890000', '4', '5', '6');
INSERT INTO `Concessyonarye`.`Vehicle` (`id`, `basePrice`, `fuel`, `userseats`, `model_id`) 
VALUES ('5', '60000', '5', '6', '8');*/

/*Promotion*/
INSERT INTO `Concessyonarye`.`Promotion` (`id`, `discountPercent`, `promoname`, `startDate`) 
VALUES ('1', '25', 'YILOOL', '2021-01-01 00:00:00');
