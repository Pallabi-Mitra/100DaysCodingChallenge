# Write your MySQL query statement below

SELECT user_id, name,mail
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$';
/*
Why Use * and $?
* (Asterisk) is used to allow for any number of valid characters (letters, digits, underscores, periods, dashes) in the prefix part of the email. Without the asterisk, the regex would only match an email with exactly one character after the initial letter, which is not the desired behavior.

$ (Dollar sign) ensures that the string ends exactly at @leetcode.com. This prevents matching strings that might contain @leetcode.com as a substring but have additional characters after it.*/