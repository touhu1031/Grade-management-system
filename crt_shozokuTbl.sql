/*crt_shozokuTbl
  No.19 Futa Nakano*/

create table shozokuTbl(
		g_code int(8)  references seitoTbl(g_code),
		year int(4),
		term_code char(3) references termTbl(term_code),
		i_code char(4) references boardTbl(i_code),
		primary key (g_code,year)
);

