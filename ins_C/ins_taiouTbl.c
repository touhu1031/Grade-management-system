/*ins_seitoTbl.c*/
/*No.19 Futa Nakano
 ins_taiouTbl.c*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int GetRnd(int,int);

int main(void){

	int gcode,cls,no,club;
	char name[61],sei[4];
	FILE *fpin,*fpout;

	if( (fpin=fopen("seitoTbl.txt","r")) == NULL ){
		printf("ファイルが見つかりません。--seitojyoho.txt\n");
		exit(1);
	}

	if( (fpout=fopen("ins_taiouTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--seito-tensu.txt\n");
		exit(1);
	}

	srand(time(NULL));

	while( !feof(fpin) ){
		fscanf(fpin,"%d,%d,%d,%[^,],%s ",&gcode,&cls,&no,name,sei);
		fprintf(fpout,"INSERT INTO TaiouTbl(g_code,year) VALUES(%d,2026);\n",gcode);
	}
	fclose(fpin);
	fclose(fpout);
}

