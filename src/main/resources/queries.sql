-- Query to list employers in St. Louis City
SELECT name FROM employer WHERE LOWER(location) = 'st. louis city';

-- Query to drop the job table
DROP TABLE job;
