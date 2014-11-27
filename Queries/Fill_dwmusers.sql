-- clear table
delete from dwmusers *;


-- fill table
insert into dwmusers(username,pseudo,password)
values('Insanity','Dylan','test');

insert into dwmusers(username,pseudo,password)
values('melrk161','Melissa','test');

insert into dwmusers(username,pseudo,password)
values('Hertz','Sean','test');

-- select
select * from dwmusers;