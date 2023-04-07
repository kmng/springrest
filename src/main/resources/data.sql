-- Seed data for Poll entity
INSERT INTO poll (question) VALUES ('What is your favorite programming language?');
INSERT INTO poll (question) VALUES ('What is your favorite framework?');

-- Seed data for Option entity
INSERT INTO option (text, poll_id) VALUES ('Java', 1);
INSERT INTO option (text, poll_id) VALUES ('Python', 1);
INSERT INTO option (text, poll_id) VALUES ('JavaScript', 1);
INSERT INTO option (text, poll_id) VALUES ('Spring Boot', 2);
INSERT INTO option (text, poll_id) VALUES ('Ruby on Rails', 2);
