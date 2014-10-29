-- You can use this file to load seed data into the database using SQL statements
insert into was_role(name) values ('ADMIN')
insert into was_role(name) values ('USER')
insert into was_role(name) values ('COMPANY')

insert into was_user(email, password) values ('admin@th-wildau.de', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8')
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'admin@th-wildau.de'), (select id from was_role where name = 'ADMIN'))

insert into was_user(email, password) values ('company@th-wildau.de', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8')
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'company@th-wildau.de'), (select id from was_role where name = 'COMPANY'))

insert into was_user(email, password) values ('user@th-wildau.de', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8')
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'user@th-wildau.de'), (select id from was_role where name = 'USER'))

insert into was_user(email, password) values ('john@th-wildau.de', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8')
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'ADMIN'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'COMPANY'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'USER'))
