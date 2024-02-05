-- Create the database and table
CREATE DATABASE IF NOT EXISTS MaxSubarraySumDB;
USE MaxSubarraySumDB;

CREATE TABLE IF NOT EXISTS MaxSubarraySum (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    InputArray TEXT,
    MaxContiguousSum INT
);
