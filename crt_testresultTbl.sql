/*crt_testresultTbl.sql*/
/*No.26 Tomoki Hanada*/
create table testresultTbl(
	g_code int(8) references seitoTbl(g_code),
	term_code char(3) references termTbl(term_code),
	s_code char(3) refences subjectTbl(s_code),
	point int(3),
	primary key(g_code,term_code,s_code)
);
