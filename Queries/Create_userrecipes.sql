set schema 'dinewithme';

create table userrecipes(
id serial primary key,
userid int references users(userid),
recipeid int references recipes(recipeid)sel
)