create table languages (
    id bigint not null primary key auto_increment,
    welcomeMessage varchar(100) not null,
    code varchar(3)
);
insert into languages (welcomeMessage, code) values ('Hi', 'en');
insert into languages (welcomeMessage, code) values ('Siema', 'pl');
insert into languages (welcomeMessage, code) values ('Tag', 'de');