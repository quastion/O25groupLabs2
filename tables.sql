CREATE TABLE Developer
(
	id_developer         INTEGER NOT NULL ,
	Name                 VARCHAR2(100) NOT NULL 
);
CREATE TABLE Film
(
	id_film              INTEGER NOT NULL ,
	Price_film           INTEGER NULL ,
	Sensibility          INTEGER NULL ,
	Num_frames           INTEGER NULL ,
	Date_starting_snapshot DATE NULL ,
	Date_manifestation   DATE NULL ,
	Place_manifestation  VARCHAR2(100) NULL ,
	Place_storage        VARCHAR2(100) NULL ,
	id_type_of_film      INTEGER NULL 
);
CREATE TABLE Frame
(
	id_frame             INTEGER NOT NULL ,
	Date_frame           DATE NULL ,
	Place_frame          VARCHAR2(100) NULL ,
	Theme                VARCHAR2(100) NULL ,
	id_film              INTEGER NOT NULL 
);
CREATE TABLE Member
(
	id_member            INTEGER NOT NULL ,
	Surname              VARCHAR2(100) NOT NULL ,
	Name                 VARCHAR2(100) NOT NULL ,
	Middle_name          VARCHAR2(100) NULL 
);
CREATE TABLE MemberOfFrame
(
	id_member_of_frame   INTEGER NOT NULL ,
	id_member            INTEGER NOT NULL ,
	id_frame             INTEGER NULL ,
	id_film              INTEGER NULL 
);
CREATE TABLE Paper
(
	id_paper             INTEGER NOT NULL ,
	Type_paper           VARCHAR2(100) NOT NULL 
);
CREATE TABLE Photo
(
	id_photo             INTEGER NOT NULL ,
	Date_printing        DATE NULL ,
	Size_                 INTEGER NULL ,
	Number_               INTEGER NULL ,
	Price_photo          INTEGER NULL ,
	Place_photo          VARCHAR2(100) NULL ,
	id_developer         INTEGER NOT NULL ,
	id_paper             INTEGER NOT NULL ,
	id_frame             INTEGER NOT NULL ,
	id_film              INTEGER NOT NULL 
);

CREATE TABLE TypeOfFilm
(
	id_type_of_film      INTEGER NOT NULL ,
	Type_film            VARCHAR2(100) NULL 
);

//======================================================== Добавление новых таблиц, все что связано с юзером

CREATE TABLE userRating(
  id_user Integer NOT NULL,
  ID_FILM Integer NOT NULL,
  rating Integer
);

CREATE INDEX IX_Relationship1 ON userRating (id_user);

CREATE TABLE UserTable(
  id_user Integer NOT NULL,
  lgn VARCHAR2(100 ) NOT NULL,
  psw VARCHAR2(100 ) NOT NULL,
  accss VARCHAR2(20 ) NOT NULL
);

ALTER TABLE UserTable ADD CONSTRAINT Key2 PRIMARY KEY (id_user);

ALTER TABLE userRating ADD CONSTRAINT Relationship1 FOREIGN KEY (id_user) REFERENCES UserTable (id_user) ON DELETE CASCADE;

ALTER TABLE userRating ADD CONSTRAINT Relationship2 FOREIGN KEY (ID_FILM) REFERENCES FILM (ID_FILM) ON DELETE CASCADE;
//===========================================================

CREATE UNIQUE INDEX XPKDeveloper ON Developer
(id_developer   ASC);

ALTER TABLE Developer
	ADD CONSTRAINT  XPKDeveloper PRIMARY KEY (id_developer);

CREATE UNIQUE INDEX XPKFilm ON Film
(id_film   ASC);

ALTER TABLE Film
	ADD CONSTRAINT  XPKFilm PRIMARY KEY (id_film);

CREATE UNIQUE INDEX XPKFrame ON Frame
(id_frame   ASC,id_film   ASC);

ALTER TABLE Frame
	ADD CONSTRAINT  XPKFrame PRIMARY KEY (id_frame,id_film);

CREATE UNIQUE INDEX XPKMember ON Member
(id_member   ASC);

ALTER TABLE Member
	ADD CONSTRAINT  XPKMember PRIMARY KEY (id_member);

CREATE UNIQUE INDEX XPKMemberOfFrame ON MemberOfFrame
(id_member_of_frame   ASC);

ALTER TABLE MemberOfFrame
	ADD CONSTRAINT  XPKMemberOfFrame PRIMARY KEY (id_member_of_frame);

CREATE UNIQUE INDEX XPKPaper ON Paper
(id_paper   ASC);

ALTER TABLE Paper
	ADD CONSTRAINT  XPKPaper PRIMARY KEY (id_paper);

CREATE UNIQUE INDEX XPKPhoto ON Photo
(id_photo   ASC);

ALTER TABLE Photo
	ADD CONSTRAINT  XPKPhoto PRIMARY KEY (id_photo);

CREATE UNIQUE INDEX XPKTypeOfFilm ON TypeOfFilm
(id_type_of_film   ASC);

ALTER TABLE TypeOfFilm
	ADD CONSTRAINT  XPKTypeOfFilm PRIMARY KEY (id_type_of_film);

ALTER TABLE Film
	ADD (CONSTRAINT R_3 FOREIGN KEY (id_type_of_film) REFERENCES TypeOfFilm (id_type_of_film) ON DELETE SET NULL);

ALTER TABLE Frame
	ADD (CONSTRAINT R_4 FOREIGN KEY (id_film) REFERENCES Film (id_film));

ALTER TABLE MemberOfFrame
	ADD (CONSTRAINT R_5 FOREIGN KEY (id_member) REFERENCES Member (id_member));

ALTER TABLE MemberOfFrame
	ADD (CONSTRAINT R_6 FOREIGN KEY (id_frame, id_film) REFERENCES Frame (id_frame, id_film) ON DELETE SET NULL);

ALTER TABLE Photo
	ADD (CONSTRAINT R_1 FOREIGN KEY (id_developer) REFERENCES Developer (id_developer));

ALTER TABLE Photo
	ADD (CONSTRAINT R_2 FOREIGN KEY (id_paper) REFERENCES Paper (id_paper) ON DELETE SET NULL);

ALTER TABLE Photo
	ADD (CONSTRAINT R_7 FOREIGN KEY (id_frame, id_film) REFERENCES Frame (id_frame, id_film));


-- Каскадное удаление
-- Удаление прежних ограничений FOREIGN KEY
ALTER TABLE Film
	drop CONSTRAINT R_3;

ALTER TABLE Frame
	drop CONSTRAINT R_4;

ALTER TABLE MemberOfFrame
	drop CONSTRAINT R_5;

ALTER TABLE MemberOfFrame
	drop CONSTRAINT R_6;

ALTER TABLE Photo
	drop CONSTRAINT R_1 ;

ALTER TABLE Photo
	drop CONSTRAINT R_2 ;

ALTER TABLE Photo
	drop CONSTRAINT R_7;
-- Добавление новых ограничений со свойством ON DELETE CASCADE
ALTER TABLE Film
	ADD (CONSTRAINT R_3 FOREIGN KEY (id_type_of_film) REFERENCES TypeOfFilm (id_type_of_film) ON DELETE CASCADE);

ALTER TABLE Frame
	ADD (CONSTRAINT R_4 FOREIGN KEY (id_film) REFERENCES Film (id_film) ON DELETE CASCADE);

ALTER TABLE MemberOfFrame
	ADD (CONSTRAINT R_5 FOREIGN KEY (id_member) REFERENCES Member (id_member) ON DELETE CASCADE);

ALTER TABLE MemberOfFrame
	ADD (CONSTRAINT R_6 FOREIGN KEY (id_frame, id_film) REFERENCES Frame (id_frame, id_film) ON DELETE CASCADE);

ALTER TABLE Photo
	ADD (CONSTRAINT R_1 FOREIGN KEY (id_developer) REFERENCES Developer (id_developer) ON DELETE CASCADE);

ALTER TABLE Photo
	ADD (CONSTRAINT R_2 FOREIGN KEY (id_paper) REFERENCES Paper (id_paper) ON DELETE CASCADE);

ALTER TABLE Photo
	ADD (CONSTRAINT R_7 FOREIGN KEY (id_frame, id_film) REFERENCES Frame (id_frame, id_film) ON DELETE CASCADE);

