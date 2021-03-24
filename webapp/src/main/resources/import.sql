/* POPULATE TABLE CLASSES*/
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("AA-111-01", 1, 1, "9-11 AM", "Mon-Thu", 25);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("AB-121-02", 2, 2, "1-3 PM", "Mon-Wed-Thu", 50);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("BB-102-03", 3, 3, "9-11 AM", "Tue-Fri-Sat", 50);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("BD-101-01", 4, 4, "3-5 PM", "Tue-Fri", 15);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("CA-100-02", 5, 5, "11-1 AM/PM", "Wed-Sat", 15);

/* POPULATE TABLE SUBJECTS */
insert into subjects (name,description) values ("ECONOMY-101", "description 1");
insert into subjects (name,description) values ("SOCIOLOGY-101", "description 2");
insert into subjects (name,description) values ("MATHEMATICS-101", "description 3");
insert into subjects (name,description) values ("PHYSICS-101", "description 4");
insert into subjects (name,description) values ("COMP-SCIENCE-101", "description 5");

/* POPULATE TABLE PROFESSORS*/
insert into professors (first_name,last_name,national_id,employee_id) values ("John","Smith","1234","AA-123-B");
insert into professors (first_name,last_name,national_id,employee_id) values ("Mark","Silver","3245","AB-234-J");
insert into professors (first_name,last_name,national_id,employee_id) values ("Lucy","West","9467","DU-333-L");
insert into professors (first_name,last_name,national_id,employee_id) values ("Sarah","Sommer","4532","CC-984-C");
insert into professors (first_name,last_name,national_id,employee_id) values ("Peter","Grant","9864","EN-123-D");

/* POPULATE TABLE STUDENTS*/


