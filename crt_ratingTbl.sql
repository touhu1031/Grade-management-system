/*20261008*/
/*NISHIUMI COMPANY*/
/*N.SERA*/
/*CRT_RATINGTBL.SQL*/
CREATE TABLE ratingTbl(
		g_code INT REFERENCES seitoTbl(g_code),
		k_code CHAR(3) REFERENCES kamokuTbl(k_code),
		t_code CHAR(3) REFERENCES jikiTbl(t_code),
		rating INT,
		PRIMARY KEY(g_code, k_code, t_code)
);
