set schema 'dinewithme';

select * from users;

create table recipes(
recipeid serial primary key,
name varchar(30),
ingredients text,
instructions text
)