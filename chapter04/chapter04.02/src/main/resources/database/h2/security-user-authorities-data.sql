-- ref. Appendix A of Spring Security manual

-- chapter04.01
-- Defining user authorities

INSERT INTO authorities(username,authority) VALUES ('user1@example.com','ROLE_USER');
INSERT INTO authorities(username,authority) VALUES ('admin1@example.com','ROLE_ADMIN');
INSERT INTO authorities(username,authority) VALUES ('admin1@example.com','ROLE_USER');
INSERT INTO authorities(username,authority) VALUES ('user2@example.com','ROLE_USER');

-- User is disabled
INSERT INTO authorities(username,authority) VALUES ('disabled1@example.com','ROLE_USER');

-- The End...
