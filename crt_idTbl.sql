/*crt_idTbl.sql*/
/*No.26 Tomoki Hanada*/
create table idTbl(
	usr_id varchar(10) primary key,
	usr_pw varchar(20),
	tch_code char(4) references tchTbl(tch_code),
	k_code int(4)
);

