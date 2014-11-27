select * from dwmusers;

drop table dwmusers cascade;

create table dwmusers(
id bigserial primary key,
username varchar(40) unique,
pseudo varchar(40),
password varchar(60)
)