﻿CREATE SEQUENCE seqForTable 
INCREMENT BY 1 
START WITH 1000 
MAXVALUE 10000 
MINVALUE 1000 
CACHE 20;

CREATE OR REPLACE TRIGGER TRIG_DEVELOPER  
   BEFORE INSERT ON "USER_NETCRACKER"."DEVELOPER" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_DEVELOPER" IS NULL THEN 
         SELECT SEQFORTABLES.nextval INTO :NEW."ID_DEVELOPER" FROM dual; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_FILM  
   BEFORE INSERT ON "USER_NETCRACKER"."FILM" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_FILM" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_FILM" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_FRAME  
   BEFORE INSERT ON "USER_NETCRACKER"."FRAME" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_FRAME" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_FRAME" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_MEMBER  
   BEFORE INSERT ON "USER_NETCRACKER"."MEMBER" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_MEMBER" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_MEMBER" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_MEMBER_OF_FRAME  
   BEFORE INSERT ON "USER_NETCRACKER"."MEMBEROFFRAME" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_MEMBER_OF_FRAME" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_MEMBER_OF_FRAME" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_PAPER  
   BEFORE INSERT ON "USER_NETCRACKER"."PAPER" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_PAPER" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_PAPER" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_PHOTO  
   BEFORE INSERT ON "USER_NETCRACKER"."PHOTO" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_PHOTO" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_PHOTO" FROM DUAL; 
      END IF; 
   END IF; 
END;

CREATE OR REPLACE TRIGGER TRIG_TYPE_OF_FILM  
   BEFORE INSERT ON "USER_NETCRACKER"."TYPEOFFILM" 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW."ID_TYPE_OF_FILM" IS NULL THEN 
         SELECT SEQFORTABLES.NEXTVAL INTO :NEW."ID_TYPE_OF_FILM" FROM DUAL; 
      END IF; 
   END IF; 
END;

//===========================================================Для юзера
CREATE OR REPLACE TRIGGER TRIG_USERTABLE  
   BEFORE INSERT ON USER_NETCRACKER.USERTABLE 
   FOR EACH ROW 
BEGIN  
   IF INSERTING THEN 
      IF :NEW.ID_USER IS NULL THEN 
         SELECT SEQFORTABLES.nextval INTO :NEW.ID_USER FROM dual; 
      END IF; 
   END IF; 
END;
//======================================================================