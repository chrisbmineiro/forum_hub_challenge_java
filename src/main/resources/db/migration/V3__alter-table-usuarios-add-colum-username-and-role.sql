ALTER TABLE usuarios ADD COLUMN username VARCHAR(100) NOT NULL UNIQUE AFTER id, ADD COLUMN role ENUM('ADMIN', 'USER') NOT NULL DEFAULT 'USER'