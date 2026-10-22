/*crt_taiouTbl.sql*/
/*No.26 Tomoki Hanada*/
create table taiouTbl(
	g_code int(8) references seitoTbl(g_code),
	year int(4) primary key,
	kinshin int (3),
	ryugaku int(3),
	ryunen char(4),
	primary key(g_code)
);
