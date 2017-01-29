drop table if exists books;
CREATE TABLE books (
  id         INTEGER IDENTITY PRIMARY KEY,
  author VARCHAR(60),
  title  VARCHAR(200),
  isbn VARCHAR (20)
);