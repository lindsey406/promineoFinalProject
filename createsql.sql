drop database donation_tracker;
create database IF NOT EXISTS donation_tracker;
use donation_tracker;

drop table if exists donation_project;
drop table if exists donations;
drop table if exists projects;
drop table if exists donors;

create table donors (
donor_id int not null auto_increment,
donor_name varchar(50) not null,  
contact_first varchar(30) not null,
contact_last varchar(30) not null,
email varchar(50) not null,
primary key(donor_id),
unique(donor_name)
);

create table projects (
project_id int not null auto_increment,
project_name varchar(50) not null,
primary key(project_id),
unique(project_name)
);

create table donations (
id int not null auto_increment,
amount decimal not null,
received_date date not null,
donor_id int not null,
notes varchar(255),
primary key(id),
foreign key(donor_id) references donors(donor_id)
);

CREATE TABLE donor_project (
    donor_id INT NOT NULL,
    project_id INT NOT NULL,
    FOREIGN KEY (donor_id)
        REFERENCES donors (donor_id),
    FOREIGN KEY (project_id)
        REFERENCES projects (project_id),
        primary key (donor_id, project_id)
);
