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
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("12349","AA-123",true,"John","Smith");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("32459","AB-234",true,"Mark","Silverman");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("94679","DU-333",true,"Lucile","West");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("45329","CC-984",true,"Sarah","Sommers");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("98649","EN-123",true,"Peter","Grant");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("93329","LD-984",false,"Lara","Brown");
insert into professors (national_id,employee_id,is_active,first_name,last_name) values ("92349","VY-123",false,"Mathew","White");

/* POPULATE TABLE STUDENTS*/
insert into students (first_name,last_name,national_id,student_id) values ("Thomas","Black","123456","st-22");
insert into students (first_name,last_name,national_id,student_id) values ("Mara","Downing","234567","st-15");
insert into students (first_name,last_name,national_id,student_id) values ("Laura","Clearwater","345678","st-17");

/* POPULATE TABLE USERS */
insert into users (username,password,enabled) values ("admin","$2a$10$BTRIg0JYuttP3pe1B.2g9OdTq4jGA1CUsEjoUY4Ij73HllHgkRKOG",true);
insert into users (username,password,enabled) values ("123456","$2a$10$9u/NLLCOfG6uGHTG/AwhuumNzk3V3EHAouJGe2JG/w7VemXRPbF.u",true);
insert into users (username,password,enabled) values ("234567","$2a$10$pq1lUL.GsMEij3dlgCdBKO0MQA/oUk58f1IJ7f10TJ9QrK2Fg4G9W",true);
insert into users (username,password,enabled) values ("345678","$2a$10$z253b1fwx2HTWDCe.3O9s.qtHJDF/UntiyE3COFmabtggSsuqNE5a",true);

/* POPULATE TABLE AUTHORITIES */
insert into authorities (user_id,authority) values ("1","ROLE_ADMIN");
insert into authorities (user_id,authority) values ("2","ROLE_STUDENT");
insert into authorities (user_id,authority) values ("3","ROLE_STUDENT");
insert into authorities (user_id,authority) values ("4","ROLE_STUDENT");