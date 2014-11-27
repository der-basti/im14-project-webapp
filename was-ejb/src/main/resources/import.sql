-- You can use this file to load seed data into the database using SQL statements
insert into was_role(name) values ('ADMIN')
insert into was_role(name) values ('USER')
insert into was_role(name) values ('COMPANY')

-- general password is 'passwd123'
insert into was_address(street, streetNumber, plz, city) values ('asd1','1','12345','Berlin')
insert into was_user(email, password, address_id) values ('admin@th-wildau.de', 'dUmSCo+MXew/Hc23pet4QOoeUvLuQP5wttH7N2rtOo0=', (select id from was_address where street like 'asd1'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'admin@th-wildau.de'), (select id from was_role where name = 'ADMIN'))

insert into was_address(street, streetNumber, plz, city) values ('asd2','1','12345','Berlin')
insert into was_user(email, password) values ('company@th-wildau.de', 'dUmSCo+MXew/Hc23pet4QOoeUvLuQP5wttH7N2rtOo0=', (select id from was_address where street like 'asd2'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'company@th-wildau.de'), (select id from was_role where name = 'COMPANY'))

insert into was_address(street, streetNumber, plz, city) values ('asd3','1','12345','Berlin')
insert into was_user(email, password) values ('user@th-wildau.de', 'dUmSCo+MXew/Hc23pet4QOoeUvLuQP5wttH7N2rtOo0=', (select id from was_address where street like 'asd3'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'user@th-wildau.de'), (select id from was_role where name = 'USER'))

insert into was_address(street, streetNumber, plz, city) values ('Friedrichstr.','1','12345','Berlin')
insert into was_user(email, password, address_id) values ('john@th-wildau.de', 'dUmSCo+MXew/Hc23pet4QOoeUvLuQP5wttH7N2rtOo0=', , (select id from was_address where street like 'Friedrichstr.'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'ADMIN'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'COMPANY'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'USER'))



insert into was_article(user_id, createDate, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'Beispiel Artikel von john...')
