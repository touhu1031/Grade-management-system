#include<stdio.h>
#include<stdlib.h>

int main(void){
	char g_code[16];     
	char term_code[8];
	char s_code[8];
	char rating[8];
	char buf[128];     
	FILE *fpin,*fpout;

	if((fpin=fopen("ratingTbl.txt","r")) == NULL){
		printf("ファイルが見つかりません。--ratingTbl.txt\n"); // 
		exit(1);
	}
	if((fpout =fopen("ins_ratingTbl.sql","w")) == NULL){
		fclose(fpin);
		printf("ファイルが見つかりません--ins_ratingTbl.sql\n");
		exit(1);
	}

	while(fgets(buf, sizeof(buf), fpin) != NULL){
		
		if (sscanf(buf, "%[^,],%[^,],%[^,],%[^,\n]", g_code, term_code, s_code, rating) == 4) {
			
			fprintf(fpout, "INSERT INTO ratingTbl(g_code,kubun_code,s_code,rating) ");
			fprintf(fpout, "VALUES(%s,'%s','%s',%s);\n", g_code, term_code, s_code, rating);
		}
	}

	fclose(fpin);
	fclose(fpout);
	return 0;
}
