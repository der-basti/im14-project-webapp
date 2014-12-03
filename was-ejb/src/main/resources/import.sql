-- You can use this file to load seed data into the database using SQL statements
insert into was_role(name) values ('USER')
insert into was_role(name) values ('COMPANY')

-- general password is 'passwd123'

insert into was_address(title, firstName, lastName, street, streetNumber, plz, city) values ('Dr.', 'Klaus', 'Peter','asd2','1','12345','Berlin')
insert into was_user(email, password, passwordSalt, address_id) values ('company@th-wildau.de', 'fsbv1UooTJ3hPChjo5HgY9T5caG6TG4xY7Qb10k2T8E=', '7MkZdGswgzvk1cDocG4v', (select id from was_address where street like 'asd2'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'company@th-wildau.de'), (select id from was_role where name = 'COMPANY'))

insert into was_address(title, firstName, lastName, street, streetNumber, plz, city) values ('Dr.', 'Paul', 'Jansen','asd3','1','12345','Berlin')
insert into was_user(email, password, passwordSalt, address_id) values ('user@th-wildau.de', 'fsbv1UooTJ3hPChjo5HgY9T5caG6TG4xY7Qb10k2T8E=', '7MkZdGswgzvk1cDocG4v', (select id from was_address where street like 'asd3'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'user@th-wildau.de'), (select id from was_role where name = 'USER'))

insert into was_address(firstName, lastName, street, streetNumber, plz, city) values ('Fred', 'Norben','Friedrichstr','1','12345','Berlin')
insert into was_user(email, password, passwordSalt, address_id) values ('john@th-wildau.de', 'fsbv1UooTJ3hPChjo5HgY9T5caG6TG4xY7Qb10k2T8E=', '7MkZdGswgzvk1cDocG4v', (select id from was_address where street like 'Friedrichstr'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'COMPANY'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'john@th-wildau.de'), (select id from was_role where name = 'USER'))

insert into was_address(firstName, lastName, street, streetNumber, plz, city) values ('Sebastian', 'Foo', 'Hochschulring','1','12345','Berlin')
insert into was_user(email, activiationKey, password, passwordSalt, address_id) values ('foo@der-basti.com', 'wB8iVQS6LqphUY1soeAE3b3HkOzyMrd', 'fsbv1UooTJ3hPChjo5HgY9T5caG6TG4xY7Qb10k2T8E=', '7MkZdGswgzvk1cDocG4v', (select id from was_address where street like 'Hochschulring'))
insert into users_roles(users_id, roles_id) values ((select id from was_user where email = 'foo@der-basti.com'), (select id from was_role where name = 'USER'))

insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'company@th-wildau.de'), CURRENT_TIMESTAMP(), 'Stellenausschreibung Softwareentwickler', 'Beispiel Artikel 1 von company')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'company@th-wildau.de'), CURRENT_TIMESTAMP(), 'Wir suchen Sie', 'Beispiel Artikel 2 von company')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'user@th-wildau.de'), CURRENT_TIMESTAMP(), 'Mein CV', 'Artikel 1 von user')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'user@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Artikel 2 von user')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'user@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Artikel 3 von user')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'user@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Artikel 4 von user')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'Das bin ich', '1 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'Das kann ich', '2 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '3 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '4 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Reinlich wo bezahlen schlafer ja du schaffte so halbwegs. Du wo wind arme nein aber rief ubel he wo. Seid gebe zu ja tate orte alle. Sie indes war einem nun ihn alten. Haben laune feuer he du wills. Je du schones dunklen mehrere lebhaft stimmts so. Gerbers da taghell offnung namlich da. Haar tat ehre dich habt dort man dus see.')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Bat ist landsleute hin nachmittag vorpfeifen. Pa es klopfte an flecken wu tadelte. Darauf dus neckte hin als gebaut lag. Kindliche weiterhin mannsbild ob zu windstill. Herr gast sei gut ists. Hufschmied bat ehe wei scherzwort drechslers grundstuck wohlgefuhl man aufgespart. Gehe se luke ruth weil en ei wege. Schen kennt nobel sie gut wie und schau dafur.')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Wohnzimmer so regungslos nettigkeit aufzulosen wu. Ubelnehmen bis kartoffeln stockwerke das des dazwischen gro aufgespart. Gegen haute ihr kommt vor euern. Ich hinter schwer bundel sog dir linken. Doch ja eile so warf du haar kein wenn zu. Du ja schlanken te weiterhin zerfasert besserung la ausblasen geheimnis.')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Stuckchen nichtstun lieblinge ausblasen te em in spazieren. Alt ein leuchtturm lehrlingen eigentlich mir knabenhaft hut. Herrn junge jahre wovon bei ist unten. Sto hinuber und preisen brachte. Wei see knarre lehren denken. Herrje gehabt wir nimmer bei. Art bescheiden sie bodenlosen flusterton betrachtet wei. Loben damit keins ku wette trost ri se da. Bei tut hin essen jetzt stube wer. Wie luke ehe bist hort.')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'Fraget nun tat ruhten sah stehen bandes. Wangen hellen der ton loffel kannte ihn grauen handen was. Fur herum flo viere tat ernst eia. Mischen gefreut la horchte zwingen solchen zu stopfen. Um ochsen seiest fruhen sprach soviel mussen am fu. Blatt ton ihn weich sei stube immer ihren.')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '9 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '10 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '11 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '12 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '13 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', '14 von john')
insert into was_article(user_id, createDate, title, content) values ((select id from was_user where email = 'company@th-wildau.de'), CURRENT_TIMESTAMP(), 'asd', 'foo bar company')

insert into was_comment(user_id, createDate, article_id, content) values ((select id from was_user where email = 'john@th-wildau.de'), CURRENT_TIMESTAMP(), 1, 'My frist comment')
insert into was_comment(user_id, createDate, article_id, content) values ((select id from was_user where email = 'user@th-wildau.de'), CURRENT_TIMESTAMP(), 1, 'My second comment')
insert into was_comment(user_id, createDate, article_id, content) values ((select id from was_user where email = 'company@th-wildau.de'), CURRENT_TIMESTAMP(), 2, 'Another comment')
