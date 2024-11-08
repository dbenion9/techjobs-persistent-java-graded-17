SELECT name FROM employer WHERE location = "St. Louis City";

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS job;
SET FOREIGN_KEY_CHECKS = 1;

SELECT DISTINCT skill.name
FROM skill
JOIN job_skill ON skill.id = job_skill.skill_id
ORDER BY skill.name ASC;
