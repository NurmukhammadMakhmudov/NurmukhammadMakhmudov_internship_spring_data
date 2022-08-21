-- Employees Table

insert into employees (id, first_name, last_name, position)
values (1, 'Lise', 'Hevner', 'Dental Hygienist');
insert into employees (id, first_name, last_name, position)
values (2, 'Chancey', 'Ales0', 'Statistician II');
insert into employees (id, first_name, last_name, position)
values (3, 'Early', 'Rey', 'Web Designer II');


-- Interns Table

insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (4, 'Karmen', 'Hoodspeth', '1997-04-28 04:32:17', 'convallis morbi');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (5, 'Torre', 'Leaburn', '1994-07-10 04:02:33', 'faucibus orci');
insert into interns (id, first_name, last_name, date_of_birth, hobby)
values (6, 'Christyna', 'Poter', '1991-12-29 00:00:39', 'nullam');


-- Role Table

insert into roles (id, role, name)
values (1, 'ADMIN', 'Администратор');
insert into roles (id, role, name)
values (2, 'MANAGER', 'Менеджер');
insert into roles (id, role, name)
values (3, 'MENTOR', 'Ментор');


-- Users table

insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (11, 1, 'Admin', 'Adminov', 'Admin@admin.com', '$2a$12$pIu9w4w0d0XDL9ZLShbbAOrpfzgrAUEpLMf.GxbNLYzTfn669.1Bm', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (12, 2, 'Manager', 'Managerov', 'Manager@manager.com', '$2a$12$A0SJ.QxAPdg/nmEdAmk4F.Jzoe/ZMoAU3drlLQkH7GwchJIhWC.ka', true);
insert into users (id, role_id, first_name, last_name, email, pass_word, isActive)
values (13, 3, 'Mentor', 'Mentorov', 'Mentor@mentorov.com', '$2a$12$8FR0VOgKXevk3D5CCvBs8uYSp6NQ6kI6FW2s5N9dTjAKlfPOMLfY.', true);