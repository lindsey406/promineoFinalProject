use donation_tracker;
insert into projects(project_name) values("Bear Paw Nature Trail");
insert into projects(project_name) values("Devlin Trail");
insert into projects(project_name) values("Lieberg Trail");
insert into projects(project_name) values("Disc Golf");

insert into donors(donor_name, contact_first, contact_last, email) values ("Lindsey's Business", "Lindsey", "Bennett", "lindsb@gmail.com");
insert into donors(donor_name, contact_first, contact_last, email) values ("MGM", "Michael", "G", "mgm@gmail.com");
insert into donors(donor_name, contact_first, contact_last, email) values ("Bob's Greenhouse", "Bob", "Smith", "bobs@gmail.com");
insert into donors(donor_name, contact_first, contact_last, email) values ("Enell", "R", "Braaten", "enell@gmail.com");

insert into donations(amount, received_date, donor_id, notes) values(750, "2022-10-14", 4, "reimbursement for tools");
insert into donations(amount, received_date, donor_id, notes) values (1000, "2022-01-02", 1, "pint night");
insert into donations(amount, received_date, donor_id, notes) values (50, "2021-04-05", 2, "birthday fundraiser");
insert into donations(amount, received_date, donor_id, notes) values (200, "2022-04-05", 3, "donation at folf tourney");

insert into donor_project(donor_id, project_id) values (3, 4);
insert into donor_project(donor_id, project_id) values (3, 2);
insert into donor_project(donor_id, project_id) values (2, 1);
insert into donor_project(donor_id, project_id) values (4, 3);
insert into donor_project(donor_id, project_id) values (3, 1);
insert into donor_project(donor_id, project_id) values (4, 4);
insert into donor_project(donor_id, project_id) values (1, 3);