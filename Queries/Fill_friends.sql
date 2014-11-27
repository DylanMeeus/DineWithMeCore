
-- empty friends
delete from friends;

-- add friends
insert into friends(username1,username2,accepted)
values('Insanity','Hertz',true);

insert into friends(username1,username2,accepted)
values('Insanity','melrk161',false);

insert into friends(username1,username2,accepted)
values('Hertz','melrk161',true);


--select friends
select * from friends;