CREATE TABLE "SYSTEM"."FUNCIONARIO" 
   (	"MATRICULA" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
	"NOME" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"CARGO" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"RUA" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"NUMERO" VARCHAR2(5 BYTE) NOT NULL ENABLE, 
	"BAIRRO" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"CIDADE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"COMPLEMENTO" VARCHAR2(100 BYTE), 
	"ID_TELEFONE" NUMBER(*,0) NOT NULL ENABLE, 
	 CONSTRAINT "FUNCIONARIO_PK" PRIMARY KEY ("MATRICULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 FOREIGN KEY ("ID_TELEFONE")
	  REFERENCES "SYSTEM"."TELEFONE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  CREATE TABLE "SYSTEM"."TELEFONE" 
   (	"ID" NUMBER(*,0) NOT NULL ENABLE, 
	"DDD" VARCHAR2(5 BYTE) NOT NULL ENABLE, 
	"NUMERO" VARCHAR2(15 BYTE) NOT NULL ENABLE, 
	"COLUMN1" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "TELEFONE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  CREATE TABLE "SYSTEM"."USUARIO" 
   (	"CPF" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"NOME" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"SENHA" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	 PRIMARY KEY ("CPF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;



CREATE SEQUENCE S_TELEFONE 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;
