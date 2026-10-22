/*crt_clubTbl.sql 部活テーブル No.10 KOKUBU*/
CREATE TABLE clubTbl(
		club_code CHAR(4) PRIMARY KEY,
		club_name VARCHAR(60),
		club_bunrui CHAR(3) REFRENCES bunruiTbl(bunrui_code),
		tch_code CHAR(4) REFRENCES tchTbl(tch_code)
);
