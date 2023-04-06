create table languages (
    id bigint not null primary key auto_increment,
    welcomeMessage varchar(100) not null,
    code varchar(3)
);