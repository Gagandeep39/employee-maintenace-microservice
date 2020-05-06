-- DUMMY data for Department - dept_id, dept_name
INSERT INTO department_table (dept_id, dept_name) VALUES (100000, 'HR');
INSERT INTO department_table (dept_id, dept_name) VALUES (100001, 'Operations');
INSERT INTO department_table (dept_id, dept_name) VALUES (100002, 'Marketing');
INSERT INTO department_table (dept_id, dept_name) VALUES (100003, 'Development');
INSERT INTO department_table (dept_id, dept_name) VALUES (100004, 'Testing');
INSERT INTO department_table (dept_id, dept_name) VALUES (100005, 'Training and Development');
INSERT INTO department_table (dept_id, dept_name) VALUES (100006, 'Recreation');
INSERT INTO department_table (dept_id, dept_name) VALUES (100007, 'Taxation');
-- UPDATE dept_id_sequence SET next_val = 100008;
ALTER sequence dept_id_sequence restart with 100008;

-- 	GRADE_DESC, GRADE_MAX_SAL, GRADE_MIN_SAL, grade_desc
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M1', 25000, 100000, 'Trainee');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M2', 100001, 250000, 'Junior Employee');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M3', 250001, 500000, 'Senior Employee');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M4', 500000, 1000000, 'Team Leader');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M5', 1000001, 2000000, 'Department Head');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M6', 2000001, 3000000, 'Vice Presidents');
-- INSERT INTO grade_table (grade_code, grade_max_sal, grade_min_sal, grade_desc) VALUES ('M7', 3000001, 4000000, 'Board Members');
-- UPDATE grade_code_sequence SET next_val = 100008;
-- ALTER sequence grade_code_sequence restart with 100008;

-- User master table
INSERT INTO user_master (user_id, password, role, username) VALUES (100001,'123456','ROLE_ADMIN','gagan');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100001,'1999-05-14','2020-05-06','Developer','test@mail.com',
'Gagandeep','M','Singh',100002,'8419969059',100003);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100001,'Adams Drive','Houston','77002','Texas');

INSERT INTO user_master (user_id, password, role, username) VALUES (100002,'123456','ROLE_MANAGER','pranav');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100002,'1998-03-31','2020-05-06','Developer','pranav@mail.com',
'Pranav','M','Karmarkar',100002,'9763916892',100004);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100002,'Illinois Avenue','Tigard','97223','Oregon');

INSERT INTO user_master (user_id, password, role, username) VALUES (100003,'123456','ROLE_USER','axl');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100003,'1986-07-17','2011-06-06','Trainee','axl@mail.com',
'Axl','M','Roy',100002,'7555238332',100005);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100003,'Hog Camp Road','La Grange','60525','Illinois');


INSERT INTO user_master (user_id, password, role, username) VALUES (100004,'123456','ROLE_USER','jazmine');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100004,'1993-11-10','2011-01-15','Tester','jazmine@mail.com',
'Jazmine','F','Mcconnell',100002,'7555296682',100006);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100004,'Union Street','Seattle','98106','Washington');


INSERT INTO user_master (user_id, password, role, username) VALUES (100005,'123456','ROLE_USER','samah');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100005,'2000-07-17','2019-12-06','Developer','samah@mail.com',
'Samah','F','Forrest',100002,'9255511013',100005);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100005,'Pine Street','Portland','97205','Pennsylvania');


INSERT INTO user_master (user_id, password, role, username) VALUES (100006,'123456','ROLE_MANAGER','ethel');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100006,'1966-03-03','1996-11-24','Manager','ethel@mail.com',
'Ethel','M','Bonner',100002,'8555984269',100002);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100006,'Stonepot Road','Newark','07102','New Jersey');


INSERT INTO user_master (user_id, password, role, username) VALUES (100007,'123456','ROLE_USER','klaudia');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100007,'1981-05-28','2006-09-10','Manager','klaudia@mail.com',
'Klaudia','F','Dunn',100006,'8555282780',100006);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100007,'Coffman Alley','Elizabethtown','42701','Kentucky');


INSERT INTO user_master (user_id, password, role, username) VALUES (100008,'123456','ROLE_USER','cem');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100008,'1991-08-30','2018-12-31','Trainee','cem@mail.com',
'Cem','M','Riggs',100006,'7555361368',100006);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100008,'West Fork Drive','CLEVELAND','44113','Ohio');


INSERT INTO user_master (user_id, password, role, username) VALUES (100009,'123456','ROLE_USER','hareem');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100009,'1968-10-30','1984-11-26','Assistant','hareem@mail.com',
'Hareem','M','Dunkley',100002,'7555590931',100005);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100009,'Thompson Drive','Oakland','94612','California');


INSERT INTO user_master (user_id, password, role, username) VALUES (100010,'123456','ROLE_MANAGER','anna');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100010,'1999-01-24','2019-02-07','Tester','anna@mail.com',
'Anna','F','Williams',100006,'8555929298',100007);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100010,'Polk Street','Tucson','85710','Arizona');


INSERT INTO user_master (user_id, password, role, username) VALUES (100011,'123456','ROLE_USER','elinor');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100011,'1972-01-21','1998-07-25','Assistant','elinor@mail.com',
'Elinor','M','Murillo',100010,'8555004999',100001);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100011,'Vernon Street','Carlsbad','92008','California');


INSERT INTO user_master (user_id, password, role, username) VALUES (100012,'123456','ROLE_USER','syzmon');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100012,'1992-09-04','2016-08-15','Assistant','syzmon@mail.com',
'Szymon','M','Blake',100010,'7555691056',100001);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100012,'Carson Street','Danville','40422','Kentucky');


INSERT INTO user_master (user_id, password, role, username) VALUES (100013,'123456','ROLE_USER','luca');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100013,'1981-11-03','2007-04-09','Trainee','luca@mail.com',
'Luca','F','Hogan',100006,'7555260794',100002);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100013,'Turkey Pen Lane','Montgomery','36117','Alabama');


INSERT INTO user_master (user_id, password, role, username) VALUES (100014,'123456','ROLE_MANAGER','ellesse');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100014,'1992-05-04','2013-11-22','Manager','ellesse@mail.com',
'Ellesse','F','Mckay',100006,'7555097247',100001);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100014,'New Creek Road','Fort Wayne','46802','Indiana');


INSERT INTO user_master (user_id, password, role, username) VALUES (100015,'123456','ROLE_ADMIN','cai');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100015,'2001-09-27','2019-12-08','Tester','cai@mail.com',
'Cai','F','Nelson',100014,'9955526265',100005);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100015,'Vineyard Drive','Cleveland','44115','Ohio');


INSERT INTO user_master (user_id, password, role, username) VALUES (100016,'123456','ROLE_USER','maxwell');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100016,'1994-04-28','2013-02-17','Assistant','maxwell@mail.com',
'Maxwell','M','Pope',100014,'9755583023',100001);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100016,'Small Street','TERRELL','75161','Texas');


INSERT INTO user_master (user_id, password, role, username) VALUES (100017,'123456','ROLE_USER','natalya');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100017,'1977-01-22','2009-01-09','Trainee','natalya@mail.com',
'Natalya','F','Holt',100010,'9055521516',100002);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100017,'Cunningham Court','Farmington Hills','48335','Michigan');


INSERT INTO user_master (user_id, password, role, username) VALUES (100018,'123456','ROLE_MANAGER','arlo');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100018,'1985-02-14','2011-09-11','Manager','arlo@mail.com',
'Arlo','M','Rodriguez',100006,'8555967267',100005);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100018,'Clarence Court','Fayetteville','28301','North Carolina');


INSERT INTO user_master (user_id, password, role, username) VALUES (100019,'123456','ROLE_USER','hector');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100019,'1993-02-16','2019-03-14','Tester','hector@mail.com',
'Hector','M','Roberson',100019,'8555915540',100004);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100019,'Hide A Way Road','Santa Clara','95050','California');


INSERT INTO user_master (user_id, password, role, username) VALUES (100020,'123456','ROLE_USER','nial');
INSERT INTO emp_details (emp_id, date_of_birth, date_of_joining, designation, email, first_name, gender,
last_name, manager_id, phoneno, dept_id) VALUES (100020,'1998-04-08','2018-08-04','DataScientist','nial@mail.com',
'Nial','M','Sloan',100020,'7555850539',100001);
INSERT INTO address (emp_id, area, city, pincode, state) VALUES (100020,'Chatham Way','Hagerstown','21740','Maryland');


-- UPDATE user_id_sequence SET next_val = 100021;
ALTER sequence user_id_sequence restart with 100021;
