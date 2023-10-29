DROP TABLE Menu;

CREATE TABLE Menu(	
	mname		VARCHAR(20)		PRIMARY KEY	NOT NULL,
	mct			VARCHAR(20)		NOT NULL,
	mprice		BIGINT			NOT NULL

);

SELECT * from Menu;

INSERT INTO Menu(mname, mct, mprice) values ('짜장면', '중식', '4000');
INSERT INTO Menu(mname, mct, mprice) values ('짬뽕', '중식', '5000');
INSERT INTO Menu(mname, mct, mprice) values ('볶음밥', '중식', '5000');
INSERT INTO Menu(mname, mct, mprice) values ('탕수육', '중식', '10000');
INSERT INTO Menu(mname, mct, mprice) values ('김치찌개', '한식', '6000');
INSERT INTO Menu(mname, mct, mprice) values ('된장찌개', '한식', '6000');
INSERT INTO Menu(mname, mct, mprice) values ('제육볶음', '한식', '7000');
INSERT INTO Menu(mname, mct, mprice) values ('비빔밥', '한식', '7000');
INSERT INTO Menu(mname, mct, mprice) values ('돈까스', '일식', '6000');
INSERT INTO Menu(mname, mct, mprice) values ('치즈돈까스', '일식', '7000');
INSERT INTO Menu(mname, mct, mprice) values ('고구마치즈돈까스', '일식', '8000');
INSERT INTO Menu(mname, mct, mprice) values ('우동', '일식', '4000');
INSERT INTO Menu(mname, mct, mprice) values ('라면', '분식', '3000');
INSERT INTO Menu(mname, mct, mprice) values ('떡라면', '분식', '3500');
INSERT INTO Menu(mname, mct, mprice) values ('떡볶이', '분식', '3500');
INSERT INTO Menu(mname, mct, mprice) values ('라볶이', '분식', '3500');
INSERT INTO Menu(mname, mct, mprice) values ('참치찌개', '한식', '6000');



DROP TABLE Sale;

CREATE TABLE Sale(
	sid			BIGINT		PRIMARY KEY AUTO_INCREMENT,
	menuId		VARCHAR(20)		NOT NULL,
	
	onum		VARCHAR(20) NOT NULL,
	quantity	INT			NOT NULL,
	salePrice	BIGINT		NOT NULL,
	orderDate	TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Cart_menuId_FK FOREIGN KEY (menuId) REFERENCES Menu(mname)
)AUTO_INCREMENT = 1001;


SELECT * FROM Sale;

INSERT INTO Sale(menuId, quantity, salePrice) VALUES ('짜장면', 10, 50000.0);






CREATE TABLE Admin(
	id		VARCHAR(20)		NOT NULL,
	pw		VARCHAR(20)		NOT NULL
)

SELECT * FROM Admin;
INSERT INTO Admin(id, pw) values ('admin', '1234');





drop TABLE Cart;
drop TABLE Sale;
drop TABLE Menu;