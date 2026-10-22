/*ins_seitoTbl.c*/
/*No.26 Tomoki Hanada*/
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

	if( (fpout=fopen("ins_seitoTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--seito-tensu.txt\n");
		exit(1);
	}

	srand(time(NULL));

	while( !feof(fpin) ){
		fscanf(fpin,"%d,%d,%d,%[^,],%s ",&gcode,&cls,&no,name,sei);
		fprintf(fpout,"INSERT INTO seitoTbl(g_code,cls_code,no,g_name,sei,club_code,bikou) VALUES(%d,%d,%d,'%s','%s','C0%02d');\n",gcode,cls,no,name,sei,GetRnd(1,31));
	}
	fclose(fpin);
	fclose(fpout);
}

int GetRnd(int min,int max){
	return min + (int)(rand()*(max-min+1.0)/(1.0+RAND_MAX));
}

