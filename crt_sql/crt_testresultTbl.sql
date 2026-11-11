/*crt_testresultTbl.sql*/
/*No.26 Tomoki Hanada*/
create table testresultTbl(
	g_code int references seitoTbl(g_code),
	term_code char(3) references termTbl(term_code),
	s_code char(3) references subjectTbl(s_code),
	point int,
	primary key(g_code,term_code,s_code)
);
