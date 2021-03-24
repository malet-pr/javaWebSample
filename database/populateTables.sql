use registration_webapp;

insert into classes (code,subject_id,professor_id,time,day,max_capacity)
values 
	("AA-111-01", 1, 10, "9-11 AM", "Mon-Thu", 25),
	("AB-121-02", 2, 12, "1-3 PM", "Mon-Wed-Thu", 50),
	("BB-102-03", 3, 12, "9-11 AM", "Tue-Fri-Sat", 50),
	("BD-101-01", 4, 9, "3-5 PM", "Tue-Fri", 15),
	("CA-100-02", 5, 1, "11-1 AM/PM", "Wed-Sat", 15);

insert into subjects (name,description)
values 
	("ECONOMY-101", "description 1"),
	("SOCIOLOGY-101", "description 2"),
	("MATHEMATICS-101", "description 3"),
	("PHYSICS-101", "description 4"),
	("COMP-SCIENCE-101", "description 5");

select * from classes;
select * from subjects;