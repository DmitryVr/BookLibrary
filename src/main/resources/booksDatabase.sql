-- Table: authors
CREATE TABLE BookLibrary.authors (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)CHARACTER SET utf8;

-- Table: genres
CREATE TABLE BookLibrary.genres (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)CHARACTER SET utf8;

-- Table: books
CREATE TABLE BookLibrary.books (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  author_id INT NOT NULL,
  genre_id INT NOT NULL,

  FOREIGN KEY (author_id) REFERENCES BookLibrary.authors (id),
  FOREIGN KEY (genre_id) REFERENCES BookLibrary.genres (id)
)CHARACTER SET utf8;

-- Insert data
INSERT INTO BookLibrary.authors VALUES (1, 'Пелевин Виктор');
INSERT INTO BookLibrary.authors VALUES (2, 'Акунин Борис');
INSERT INTO BookLibrary.authors VALUES (3, 'Герберт Фрэнк');
INSERT INTO BookLibrary.authors VALUES (4, 'Стругацкие Аркадий и Борис');
INSERT INTO BookLibrary.authors VALUES (5, 'Фаулз Джон');


INSERT INTO BookLibrary.genres VALUES (1, 'Фантастика');
INSERT INTO BookLibrary.genres VALUES (2, 'Детектив');
INSERT INTO BookLibrary.genres VALUES (3, 'Роман');


INSERT INTO BookLibrary.books VALUES (1, 'Любовь к трем цукербринам', 1, 1);
INSERT INTO BookLibrary.books VALUES (2, 'S.N.U.F.F.', 1, 1);
INSERT INTO BookLibrary.books VALUES (3, 'Чапаев и Пустота', 1, 1);
INSERT INTO BookLibrary.books VALUES (4, 'Особые поручения', 2, 2);
INSERT INTO BookLibrary.books VALUES (5, 'Дюна', 3, 1);
INSERT INTO BookLibrary.books VALUES (6, 'Трудно быть богом', 4, 1);
INSERT INTO BookLibrary.books VALUES (7, 'Коллекционер', 5, 3);