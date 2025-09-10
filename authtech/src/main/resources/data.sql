INSERT INTO DEPARTMENTS (uuid, collegeName, name) 
VALUES ('803b022e-c9b0-4ccd-ba6a-97cd1f324032', 'XIE', 'Computer Engineering');

INSERT INTO DEPARTMENTS (uuid, collegeName, name) 
VALUES ('4dba1370-8bc1-4278-ae9c-65f80ffa217b', 'XIE', 'EXTC');

INSERT INTO DEPARTMENTS (uuid, collegeName, name) 
VALUES ('cd3f2127-aeea-47a2-896a-4c992141362e', 'XIE', 'CSE');

INSERT INTO COURSES (id, course_Name, semester, departmentID)
SELECT 
    'adc52836-9ed9-4d0c-bd19-ccad2166878b', 
    'Machine Learning', 
    5, 
    uuid 
FROM DEPARTMENTS 
WHERE name = 'Computer Engineering';

INSERT INTO COURSES (id, course_Name, semester, departmentID)
SELECT 
    'cb3284c0-b3cb-4745-a44c-1a18cf028c30', 
    'COA', 
    5, 
    uuid 
FROM DEPARTMENTS 
WHERE name = 'Computer Engineering';

INSERT INTO COURSES (id, course_Name, semester, departmentID)
SELECT 
    '8841d3a3-084c-4b42-b4c3-1c26f39ca907', 
    'AOA', 
    5, 
    uuid 
FROM DEPARTMENTS 
WHERE name = 'Computer Engineering';

INSERT INTO COURSES (id, course_Name, semester, departmentID)
SELECT 
    '07361037-1822-4bc7-848f-b41be90072b2', 
    'Block Chain', 
    5, 
    uuid 
FROM DEPARTMENTS 
WHERE name = 'CSE';

INSERT INTO DIVISIONS (UUID, NAME, SESSIONID, DEPARTMENTID)
SELECT
    'e8649136-df81-437f-a906-326598a56201',
    'SE - A',
    'NULL',
    UUID
FROM DEPARTMENTS
WHERE NAME = 'Computer Engineering';

INSERT INTO DIVISIONS (UUID, NAME, SESSIONID, DEPARTMENTID)
SELECT
    'f0cecc43-dbe1-458f-9ded-ae6058ce3f5f',
    'SE - B',
    'NULL',
    UUID
FROM DEPARTMENTS
WHERE NAME = 'Computer Engineering';

-- Insert Harsh Maurya
INSERT INTO STUDENTS (
    UUID, 
    NAME, 
    DOB, 
    MAIL, 
    CONTACT_NUMBER, 
    ADDRESS, 
    COLLEGE_NAME, 
    DEPARTMENTID, 
    DIVISIONID
)
VALUES (
    '32d4cc12-b82b-46c8-ae38-ff7b3ccade7b', -- UUID
    'Harsh Maurya',                         -- NAME
    '2002-05-15',                            -- DOB (YYYY-MM-DD)
    'harsh@gmail.com',              -- MAIL
    '9876543210',                            -- CONTACT_NUMBER
    'Mumbai, India',                         -- ADDRESS
    'XIE',                       -- COLLEGE_NAME
    (SELECT UUID FROM DEPARTMENTS WHERE NAME='Computer Engineering'), -- DEPARTMENTID
    (SELECT UUID FROM DIVISIONS WHERE NAME='SE - A')             -- DIVISIONID
);

INSERT INTO STUDENTS (
    UUID, 
    NAME, 
    DOB, 
    MAIL, 
    CONTACT_NUMBER, 
    ADDRESS, 
    COLLEGE_NAME, 
    DEPARTMENTID, 
    DIVISIONID
)
VALUES (
    '29965dac-db52-44e5-87c5-cce7248aa206', -- UUID
    'Jayamati Patel',                        -- NAME
    '2003-08-20',                            -- DOB
    'jayamati.patel@example.com',            -- MAIL
    '9876501234',                            -- CONTACT_NUMBER
    'Mumbai, India',                            -- ADDRESS
    'XIE',                       -- COLLEGE_NAME
    (SELECT UUID FROM DEPARTMENTS WHERE NAME='Computer Engineering'), -- DEPARTMENTID
    (SELECT UUID FROM DIVISIONS WHERE NAME='SE - A')             -- DIVISIONID
);
-- Insert Harsh Narodey
INSERT INTO STUDENTS (
    UUID, 
    NAME, 
    DOB, 
    MAIL, 
    CONTACT_NUMBER, 
    ADDRESS, 
    COLLEGE_NAME, 
    DEPARTMENTID, 
    DIVISIONID
)
VALUES (
    'a1b2c3d4-e5f6-4712-8910-abcdef123456', -- UUID
    'Harsh Narodey',                         -- NAME
    '2002-05-15',                            -- DOB (YYYY-MM-DD)
    'harsh.narodey@example.com',             -- MAIL
    '9876543210',                            -- CONTACT_NUMBER
    'Mumbai, India',                         -- ADDRESS
    'XIE',                                   -- COLLEGE_NAME
    (SELECT UUID FROM DEPARTMENTS WHERE NAME='Computer Engineering'), -- DEPARTMENTID
    (SELECT UUID FROM DIVISIONS WHERE NAME='SE - A')             -- DIVISIONID
);

INSERT INTO STUDENTS (
    UUID, 
    NAME, 
    DOB, 
    MAIL, 
    CONTACT_NUMBER, 
    ADDRESS, 
    COLLEGE_NAME, 
    DEPARTMENTID, 
    DIVISIONID
)
VALUES (
    'f1e2d3c4-b5a6-4721-8910-fedcba654321', -- UUID
    'Shreyas Mirashi',                        -- NAME
    '2003-08-20',                             -- DOB
    'shreyas.mirashi@example.com',            -- MAIL
    '9876501234',                             -- CONTACT_NUMBER
    'Mumbai, India',                          -- ADDRESS
    'XIE',                                    -- COLLEGE_NAME
    (SELECT UUID FROM DEPARTMENTS WHERE NAME='Computer Engineering'), -- DEPARTMENTID
    (SELECT UUID FROM DIVISIONS WHERE NAME='SE - A')             -- DIVISIONID
);


INSERT INTO TEACHERS (
    UUID,
    NAME,
    GENDER,
    MAIL,
    CONTACT_NUMBER,
    ADDRESS,
    COLLEGE_NAME,
    DEPARTMENTID
) VALUES
('a1111111-1111-1111-1111-111111111111', 'Nilambari Nakar', 'FEMALE', 'nilambari.nakar@example.com', '9876543210', 'Mumbai, India', 'XIE', '803b022e-c9b0-4ccd-ba6a-97cd1f324032');

INSERT INTO TEACHERS (
    UUID,
    NAME,
    GENDER,
    MAIL,
    CONTACT_NUMBER,
    ADDRESS,
    COLLEGE_NAME,
    DEPARTMENTID
) VALUES
('b2222222-2222-2222-2222-222222222222', 'Vijay Jumb', 'MALE', 'vijay.jumb@example.com', '9876501234', 'Mumbai, India', 'XIE', '803b022e-c9b0-4ccd-ba6a-97cd1f324032');

INSERT INTO TEACHERS (
    UUID,
    NAME,
    GENDER,
    MAIL,
    CONTACT_NUMBER,
    ADDRESS,
    COLLEGE_NAME,
    DEPARTMENTID
) VALUES
('c3333333-3333-3333-3333-333333333333', 'Sushma Khanvilkar', 'FEMALE', 'sushma.khanvilkar@example.com', '9876512345', 'Mumbai, India', 'XIE', '803b022e-c9b0-4ccd-ba6a-97cd1f324032');

INSERT INTO TEACHERS (
    UUID,
    NAME,
    GENDER,
    MAIL,
    CONTACT_NUMBER,
    ADDRESS,
    COLLEGE_NAME,
    DEPARTMENTID
) VALUES
('d4444444-4444-4444-4444-444444444444', 'Rahul Sharma', 'MALE', 'rahul.sharma@example.com', '9876523456', 'Mumbai, India', 'XIE', '803b022e-c9b0-4ccd-ba6a-97cd1f324032');


Insert Into DIVISION_LIST (DIVISION_LIST  ,COURSE_LIST) values ('e8649136-df81-437f-a906-326598a56201', '8841d3a3-084c-4b42-b4c3-1c26f39ca907');
Insert Into DIVISION_LIST (DIVISION_LIST  ,COURSE_LIST) values ('f0cecc43-dbe1-458f-9ded-ae6058ce3f5f', '8841d3a3-084c-4b42-b4c3-1c26f39ca907');

Insert Into TEACHER_LIST (TEACHER_LIST  ,COURSE_LIST) values ('c3333333-3333-3333-3333-333333333333', '8841d3a3-084c-4b42-b4c3-1c26f39ca907');
Insert Into TEACHER_LIST (TEACHER_LIST  ,COURSE_LIST) values ('b2222222-2222-2222-2222-222222222222', '8841d3a3-084c-4b42-b4c3-1c26f39ca907');

INSERT INTO PASSWORDS (
    UUID,
    AUTHORITY,
    GR_NO,
    MAIL,
    NAME,
    PASSWORD
) VALUES
('32d4cc12-b82b-46c8-ae38-ff7b3ccade7b', 'STUDENT', 1001, 'harsh@gmail.com', 'Harsh Maurya', 'password123'),
('29965dac-db52-44e5-87c5-cce7248aa206', 'STUDENT', 1002, 'jayamati@gmail.com', 'Jayamati Patel', 'password123'),
('a1b2c3d4-e5f6-4712-8910-abcdef123456', 'STUDENT', 1003, 'narodey@gmail.com', 'Harsh Narodey', 'password123'),
('f1e2d3c4-b5a6-4721-8910-fedcba654321', 'STUDENT', 1004, 'shreyas@gmail.com', 'Shreyas Mirashi', 'password123');
