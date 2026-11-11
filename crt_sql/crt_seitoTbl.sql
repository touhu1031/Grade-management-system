/*crt_seitoTbl.sql
  No.19 Futa Nakano*/

create table seitoTbl (
	g_code int primary key,
	cls_code int references clsTbl(cls_code),
	no int,
	g_name varchar(60),
	sei char(3),
	club_code char(4) references clubtbl(club_code),
	bikou varchar(60)
);
