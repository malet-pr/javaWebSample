/* POPULATE TABLE CLASSES*/
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("AA-111-01", 2, 2, "9-11 AM", "Mon-Thu", 25);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("AB-121-02", 3, 3, "1-3 PM", "Mon-Wed-Thu", 50);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("BB-102-03", 4, 4, "9-11 AM", "Tue-Fri-Sat", 50);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("BD-101-01", 5, 5, "3-5 PM", "Tue-Fri", 15);
insert into classes (code,subject_id,professor_id,time,day,max_capacity) values ("CA-100-02", 6, 6, "11-1 AM/PM", "Wed-Sat", 15);

/* POPULATE TABLE SUBJECTS */
insert into subjects (name,description) values ("TBA", "not available");
insert into subjects (name,description) values ("ECONOMY-101", "description 1");
insert into subjects (name,description) values ("SOCIOLOGY-101", "description 2");
insert into subjects (name,description) values ("MATHEMATICS-101", "description 3");
insert into subjects (name,description) values ("PHYSICS-101", "description 4");
insert into subjects (name,description) values ("COMP-SCIENCE-101", "description 5");

/* POPULATE TABLE PROFESSORS*/
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("-","-",true,"","TBA");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("1234","AA-123-B",true,"John","Smith");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("3245","AB-234-J",true,"Mark","Silverman");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("9467","DU-333-L",true,"Lucile","West");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("4532","CC-984-C",true,"Sarah","Sommers");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("9864","EN-123-D",true,"Peter","Grant");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("9332","LD-984-N",false,"Lara","Brown");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("9234","VY-123-U",false,"Mathew","White");


/* POPULATE TABLE STUDENTS*/
insert into students (first_name,last_name) values ("Thomas","Black");
insert into students (first_name,last_name) values ("Mara","Downing");

