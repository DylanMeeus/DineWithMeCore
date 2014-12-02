set schema 'dinewithme';

select * from users;

insert into friends(user1,user2, accepted)
values(1,2,false);

insert into friends(user1,user2, accepted)
values(3,2,false);