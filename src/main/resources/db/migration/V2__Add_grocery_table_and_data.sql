create table grocery (
       id bigint not null primary key auto_increment,
       text varchar(100) not null,
       bought bit,
       created varchar(100) not null
);

insert into grocery (text, bought, created) values ('Tomatoes', 1, 'Aleksandra');
insert into grocery (text, bought, created) values ('Gouda cheese', 0, 'Ilona');