use registration_webapp;
INSERT INTO rooms
VALUES 
   (10,100,0,1),
   (12,100,0,1),
   (9,50,1,1),
   (7,70,1,0),
   (1,30,1,1);
SELECT * FROM rooms;
INSERT INTO subjects (subject_id,name)
VALUES 
   ("S-123-AB","Economics 101"),
   ("S-111-AB","Physics 101"),
   ("S-012-CB","Mathematics 101"),
   ("S-188-CB","Sociology 101"),
   ("S-001-DX","History 101");
SELECT * FROM subjects;
INSERT INTO classes
VALUES 
   ("A-111-01","S-123-AB",10,1,2,0),
   ("A-121-02","S-111-AB",12,2,2,0),
   ("B-101-01","S-012-CB",9,2,3,0),
   ("B-102-03","S-188-CB",12,1,3,0),
   ("C-100-02","S-001-DX",1,1,1,1);
SELECT * FROM classes;


