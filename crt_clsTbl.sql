/*crt_clsTbl.sql クラステーブル No.10 KOKUBU*/
CREATE TABLE clsTbl(
		cls_code INT(3) PRIMARY KEY,
		cls_lname VARCHAR(60),
		cls_sname CHAR(2),
		tch_code CHAR(4) REFERENCES tchTbl(tch_code),
		cls_y INT(1)CHECK(cls_y >= 1 and cls_y <= 3)
);
