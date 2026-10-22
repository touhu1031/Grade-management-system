/*crt_taiouTbl.sql*/
/*No.26 Tomoki Hanada*/
create table taiouTbl(
	g_code int references seitoTbl(g_code),
	year int,
	kinshin int,
	ryugaku int,
	ryunen char(4),
	primary key(g_code,year)
);
