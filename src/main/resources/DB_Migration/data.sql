-- Employees Table

insert into employees (id, first_name, last_name, position)
values (1, 'Lise', 'Hevner', 'Dental Hygienist');
insert into employees (id, first_name, last_name, position)
values (2, 'Chancey', 'Ales0', 'Statistician II');
insert into employees (id, first_name, last_name, position)
values (3, 'Early', 'Rey', 'Web Designer II');
insert into employees (id, first_name, last_name, position)
values (4, 'Agnesse', 'Kennerknecht', 'Account Executive');
insert into employees (id, first_name, last_name, position)
values (5, 'Raffaello', 'Walczak', 'General Manager');
insert into employees (id, first_name, last_name, position)
values (6, 'Myrtie', 'Robertazzi', 'Payment Adjustment Coordinator');
insert into employees (id, first_name, last_name, position)
values (7, 'Jocelin', 'Bettaney', 'Programmer IV');
insert into employees (id, first_name, last_name, position)
values (8, 'Anne-corinne', 'Suggitt', 'Information Systems Manager');
insert into employees (id, first_name, last_name, position)
values (9, 'Caroljean', 'Aldgate', 'VP Sales');
insert into employees (id, first_name, last_name, position)
values (10, 'Osbourne', 'Pilgram', 'Geologist IV');

-- Interns Table

insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (1, 'Karmen', 'Hoodspeth', '1997-04-28 04:32:17', 'convallis morbi');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (2, 'Torre', 'Leaburn', '1994-07-10 04:02:33', 'faucibus orci');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (3, 'Christyna', 'Poter', '1991-12-29 00:00:39', 'nullam');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (4, 'Aeriell', 'Alleyne', '1998-08-17 09:10:24', 'donec vitae');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (5, 'Zelda', 'Lamburne', '1989-05-30 05:30:40', 'condimentum neque sapien');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (6, 'Chev', 'Aronin', '1998-10-17 06:42:28', 'felis fusce posuere');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (7, 'Nariko', 'Inchboard', '1994-10-13 17:55:09', 'duis mattis egestas');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (8, 'Lian', 'Kemetz', '1991-03-12 22:38:55', 'ante vel ipsum');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (9, 'Trula', 'Atyeo', '1996-02-08 10:24:55', 'luctus ultricies eu');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (10, 'Aguie', 'Mattielli', '1989-12-04 15:01:44', 'pretium');

-- Role Table

insert into roles (id, role, name)
values (1, 'ADMIN', 'Администратор');
insert into roles (id, role, name)
values (2, 'MANAGER', 'Менеджер');
insert into roles (id, role, name)
values (3, 'MENTOR', 'Ментор');


-- Users table
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (1, 1, 'Adaline', 'Da Costa', 'adacosta0@ihg.com', 'wimcw1k1', false);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (2, 2, 'Spike', 'Hancill', 'shancill1@flickr.com', 'x1EFmrvS9rel', false);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (3, 2, 'Colan', 'Wermerling', 'cwermerling2@istockphoto.com', 'fEc2yoSpRZ', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (4, 2, 'Elvin', 'Grayley', 'egrayley3@omniture.com', '$2a$12$1fza7ARFCnx.DtekHhExVOnZlHO5AIktSwVl6tRXWKqQm7bl2iBVq', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (5, 2, 'Blinnie', 'Gerardot', 'bgerardot4@irs.gov', 'XUKB2b2A7t', false);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (6, 2, 'Robbyn', 'Souster', 'rsouster5@parallels.com', 'eHOBIgdqwFoc', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (7, 3, 'Grant', 'Greenmon', 'ggreenmon6@g.co', 'ibd4CfExNf', false);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (8, 2, 'Anderson', 'Mottram', 'amottram7@feedburner.com', 'manager', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (9, 3, 'Dorie', 'Huckell', 'dhuckell8@infoseek.co.jp', 'mentor', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (10, 1, 'Sonja', 'Harry', 'sharry9@lycos.com', '$2a$12$4OFpKmgQsLDLPexpqzzwX.rlStwviH6TxhmjU8as5cN7xYyxAy2c2', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (11, 1, 'Admin', 'Adminov', 'Admin@admin.com', '$2a$12$pIu9w4w0d0XDL9ZLShbbAOrpfzgrAUEpLMf.GxbNLYzTfn669.1Bm', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (12, 2, 'Manager', 'Managerov', 'Manager@manager.com', '$2a$12$A0SJ.QxAPdg/nmEdAmk4F.Jzoe/ZMoAU3drlLQkH7GwchJIhWC.ka', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (13, 3, 'Mentor', 'Mentorov', 'Mentor@mentorov.com', '$2a$12$8FR0VOgKXevk3D5CCvBs8uYSp6NQ6kI6FW2s5N9dTjAKlfPOMLfY.', true);