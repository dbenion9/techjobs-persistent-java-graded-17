--Part 1
-- Part 1: Listing columns in the job table
-- id INT
-- employer VARCHAR(255)
-- name VARCHAR(255)
-- skills VARCHAR(255)


--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";
--Part 3
DROP TABLE job;
--Part 4
SELECT DISTINCT skill.name
FROM skill
JOIN job_skill ON skill.id = job_skill.skill_id
ORDER BY skill.name ASC;



