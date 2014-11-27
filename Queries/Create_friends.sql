drop table friends;

create table friends
(
id bigserial primary key,
username1 varchar(60) references dwmusers(username),
username2 varchar(60) references dwmusers(username),
accepted boolean
);