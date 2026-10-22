/*20261008*/
/*NISHIUMI COMPANY*/
/*N.SERA*/
/*crt_ratingTbl.sql*/
CREATE TABLE ratingTbl(
	g_code INT REFERENCES seitoTbl(g_code),
	term_code CHAR(3) REFERENCES termTbl(term_code),
	s_code CHAR(3) REFERENCES subjectTbl(s_code),
	rating INT,
	PRIMARY KEY(g_code, term_code, s_code)
);
