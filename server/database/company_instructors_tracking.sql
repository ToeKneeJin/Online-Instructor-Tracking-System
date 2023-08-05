BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS instructor_subject CASCADE;
DROP TABLE IF EXISTS instructor CASCADE;
DROP TABLE IF EXISTS subjects CASCADE;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

-- instructor table
CREATE TABLE instructor (
    instructor_id SERIAL,
    instructor_name varchar(50) NOT NULL UNIQUE,
    instructor_timezone varchar(5),
    instructor_rating int,
    instructor_description varchar,
    is_chinese_speaking BOOLEAN,
    CONSTRAINT PK_instructor PRIMARY KEY (instructor_id),
    CONSTRAINT CHK_instructor_rating CHECK (instructor_rating >= 0 AND instructor_rating <= 100),
    CONSTRAINT CHK_instructor_timezone CHECK (instructor_timezone IN ('PST', 'EST', 'CST', 'CHN', 'UK', 'EURO', 'OTHER'))
);

-- subject table
CREATE TABLE subjects (
    subject_id SERIAL,
    subject_name varchar(50) NOT NULL UNIQUE,
    subject_details varchar,
    CONSTRAINT PK_subject PRIMARY KEY (subject_id)
);

-- instructor_subject table
CREATE TABLE instructor_subject (
	entry_id SERIAL NOT NULL,
	subject_id INT NOT NULL,
    instructor_id INT NOT NULL,
    comfortability_level INT,
    CONSTRAINT PK_entry PRIMARY KEY (entry_id),
    CONSTRAINT FK_subject_id FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
    CONSTRAINT FK_instructor_id FOREIGN KEY(instructor_id) REFERENCES instructor(instructor_id),
    CONSTRAINT CHK_comfortability_level CHECK (comfortability_level >= 1 AND comfortability_level <= 5)
);


-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************

-- Instructor
INSERT INTO instructor (instructor_name, instructor_timezone, instructor_rating, instructor_description, is_chinese_speaking) VALUES 
    ('Tony Jin', 'PST', 10, 'name is Tony Jin', TRUE),
    ('Julie Chen', 'PST', 90, 'name is Julie Chen', TRUE),
    ('Daniel Candee', 'CST', 50, 'name is Daniel Candee', FALSE),
    ('Cherry Park', 'CHN', 75, 'name is Cherry Park', FALSE);

-- Subjects
INSERT INTO subjects (subject_name, subject_details) VALUES
    ('English', 'is English'),
    ('Math', 'is Math'),
    ('History', 'is History'),
    ('STEM', 'is STEM');

-- Instructor_Subject
INSERT INTO instructor_subject (subject_id, instructor_id, comfortability_level) VALUES 
	(1, 1, 3),
    (2, 1, 1),
    (3, 1, 5),
    (4, 1, 1),
    (1, 2, 3),
    (4, 2, 5),
    (1, 3, 3),
    (3, 3, 5),
    (4, 1, 5),
    (4, 2, 5);


COMMIT TRANSACTION;