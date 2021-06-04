CREATE TABLE thisinh( 
	ID_TS int NOT NULL AUTO_INCREMENT, 
	hoten varchar(45) NOT NULL, 
	ngaysinh datetime NOT NULL, 
	noisinh varchar(45) NOT NULL, 
	HKTT varchar(45) NOT NULL, 
	khuvuc varchar(45) NOT NULL,  
	namTN year not null, 
	heTH char not null, 
	DCBT varchar(45) NULL,
	PRIMARY KEY(ID_TS),
	unique index ID_TS_UNIQUE (ID_TS asc) visible );
    
CREATE TABLE phieuduthi( 
	ID_PDT int NOT NULL AUTO_INCREMENT, 
	ID_TS int NOT NULL ,
	matruong char NOT NULL, 
	khoi char NOT NULL, 
	manganh char NOT NULL, 
	DKthi char NOT NULL,  
	maDT char not null, 
    CONSTRAINT ID_thisinh FOREIGN KEY (ID_TS) REFERENCES thisinh(ID_TS),
	PRIMARY KEY(ID_PDT),
	unique index IDPDT_UNIQUE (ID_PDT asc) visible );
    
CREATE TABLE phieubaothi( 
	ID_PBT int NOT NULL AUTO_INCREMENT, 
	ID_TS int NOT NULL, 
	DDthi varchar(45) NOT NULL, 
	phongthi int NOT NULL, 
	ngaythi datetime NOT NULL, 
	lephi int NOT NULL,  
	PRIMARY KEY(ID_PBT),
    CONSTRAINT ID_ts FOREIGN KEY (ID_TS) REFERENCES thisinh(ID_TS),
	unique index IDPBT_UNIQUE (ID_PBT asc) visible );
    
CREATE TABLE phieubaodiem( 
	ID_PBD int NOT NULL AUTO_INCREMENT, 
	ID_TS int NOT NULL, 
	diem1 float NOT NULL, 
	diem2 float NOT NULL, 
	diem3 float NOT NULL, 
	PRIMARY KEY(ID_PBD),
    CONSTRAINT ID_ths FOREIGN KEY (ID_TS) REFERENCES thisinh(ID_TS),
	unique index IDPBD_UNIQUE (ID_PBD asc) visible );
    
CREATE TABLE chamdiem( 
	maphach int NOT NULL AUTO_INCREMENT, 
	diem float NOT NULL, 
	PRIMARY KEY(maphach),
	unique index maphach_UNIQUE (maphach asc) visible );
    
CREATE TABLE ganphach( 
	maphach int NOT NULL AUTO_INCREMENT, 
	ID_TS int NOT NULL,
    baithi char not null,
	PRIMARY KEY(maphach),
    CONSTRAINT mp FOREIGN KEY (maphach) REFERENCES chamdiem(maphach),
    CONSTRAINT ID_thsi FOREIGN KEY (ID_TS) REFERENCES thisinh(ID_TS),
	unique index maphach_UNIQUE (maphach asc) visible );
    