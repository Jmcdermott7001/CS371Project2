DROP TABLE IF EXISTS Advertisements;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Moderators;
DROP TABLE IF EXISTS Statuses;
DROP TABLE IF EXISTS Categories;



create table IF NOT EXISTS Users
(User_ID varchar(20),
 UsrFirst_Name varchar(20),
 UsrLast_Name varchar(20),
 constraint pk_users primary key (User_ID)
);
create table IF NOT EXISTS Moderators
(User_ID varchar(20),
 constraint fk_user_id foreign key (User_ID) 
  references Users (User_ID) ON DELETE RESTRICT,
 constraint pk_user_id primary key (User_ID)
);
create table IF NOT EXISTS Statuses
(Status_ID enum ('PN','AC','DI') NOT NULL,
 Status_Name varchar(15),
 constraint pk_statuses primary key (Status_ID)
);
create table IF NOT EXISTS Categories
(Category_ID enum ('CAT','HOU','ELC','CCA') NOT NULL,
 CatName varchar(30),
 constraint pk_cat_id primary key (Category_ID)
);
create table IF NOT EXISTS Advertisements
(Advertisement_ID smallint unsigned not null auto_increment,
 AdvTitle varchar(40),
 AdvDetails varchar (60),
 AdvDateTime DATE NOT NULL,
 Price double (10,2) not null,
 User_ID varchar(20),
 Moderator_ID varchar(20),
 Category_ID varchar(3),
 Status_ID varchar(2),
 constraint fk_user_id foreign key (User_ID) 
  references Users (User_ID) ON DELETE CASCADE,
 constraint fk_moderator_id foreign key (Moderator_ID) 
  references Moderators (User_ID) ON DELETE SET NULL,
 constraint fk_category_id foreign key (Category_ID) 
  references Categories (Category_ID) ON DELETE RESTRICT,	
 constraint fk_status_id foreign key (Status_ID) 
  references Status (Status_ID),
 constraint pk_advertisements primary key (Advertisement_ID)
);


insert into Categories (Category_ID, CatName)
values (1,'Cars and Trucks'),(2,'Housing'),(3,'Electronics'),(4,'Child Care'); 

insert into Statuses (Status_ID, Status_Name)
values (1,'Pending'),(2,'Active'),(3,'Disapproval');

insert into Users (User_ID, UsrFirst_Name, UsrLast_Name)
values ('jsmith','John','Smith'),
('ajackson','Ann','Jackson'),
('rkale','Rania','Kale'),
('Sali','Samir','Ali');

insert into Moderators (User_ID)
values ((select User_ID from Users where UsrLast_Name = 'Smith')),
((select User_ID from Users where UsrLast_Name = 'Jackson'));

insert into Advertisements (Advertisement_ID, AdvTitle, AdvDetails, AdvDateTime, Price, Category_ID, User_ID, Moderator_ID, Status_ID)
values ('1','2010 Sedan Subaru','2010 sedan car in great shape for sale','2017-02-10',6000,
(select Category_ID from Categories where CatName = 'Cars and trucks'),
(select User_ID from Users where UsrLast_Name = 'Kale'),
(select User_ID from Users where UsrLast_Name = 'Smith'),
(select Status_ID from Statuses where Status_Name = 'Active')),
('2','Nice Office Desk','Nice office desk for sale','2017-02-15',50.25,
(select Category_ID from Categories where CatName = 'Housing'),
(select User_ID from Users where UsrLast_Name = 'Kale'),
(select User_ID from Users where UsrLast_Name = 'Smith'),
(select Status_ID from Statuses where Status_Name = 'Active')),
('3','Smart LG TV for $200 ONLY','Smart LG TV 52 inches! Really cheap!','2017-03-15',200,
(select Category_ID from Categories where CatName = 'Electronics'),
(select User_ID from Users where UsrLast_Name = 'Ali'),
(select User_ID from Users where UsrLast_Name = 'Smith'),
(select Status_ID from Statuses where Status_Name = 'Active')),
('4','HD Tablet for $25 only','Amazon Fire Tablet HD','2017-03-20',25,
(select Category_ID from Categories where CatName = 'Electronics'),
(select User_ID from Users where UsrLast_Name = 'Kale'),
null,
(select Status_ID from Statuses where Status_Name = 'Pending')),
('5','Laptop for $100','Amazing HP laptop for $100','2017-03-20',100,
(select Category_ID from Categories where CatName = 'Electronics'),
(select User_ID from Users where UsrLast_Name = 'Kale'),
null,
(select Status_ID from Statuses where Status_Name = 'Pending'));