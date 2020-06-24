insert into user
values('Miller', 'TRMILLR', 'SG');
insert into user
values('Tessa', 'TRTSSA', 'SG');
insert into user
values('Dosson', 'TRDSSN', 'HK');
insert into user
values('Ricky', 'TRRCKY', 'SG');
insert into user
values('Aaron', 'TRARON', 'SG');
insert into user
values('Bob', 'TRBOB', 'HK');
insert into teamhierarchy
values('Miller', null);
insert into teamhierarchy
values('Tessa', 'Miller');
insert into teamhierarchy
values('Dosson', 'Miller');
insert into teamhierarchy
values('Ricky', 'Tessa');
insert into teamhierarchy
values('Aaron', 'Tessa');
insert into teamhierarchy
values('Bob', 'Dosson');
