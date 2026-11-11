/*ins_seitoTbl.c*/
/*No.26 Tomoki Hanada*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int GetRnd(int,int);

int main(void){

	int gcode,year,i,a;
	FILE *fpin,*fpout;

	if( (fpin=fopen("shozokuTbl.txt","r")) == NULL ){
		printf("ファイルが見つかりません。--seitojyoho.txt\n");
		exit(1);
	}

	if( (fpout=fopen("ins_shozokuTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--seito-tensu.txt\n");
		exit(1);
	}

	srand(time(NULL));
	i = 1 ;
	while( !feof(fpin) ){
		fscanf(fpin,"%d ",&gcode);
		if(i>=1 && i<=241)
			year = 2026;
		else if(i<=281)
			year = 2025;
		else
			year = 2024;
		for(a=1;a<=4;a++){
			fprintf(fpout,"INSERT INTO shozokuTbl(g_code,year,term_code,i_code)"); 
			fprintf(fpout," VALUES(%d,%4d,'G0%d','I00%d');\n",gcode,year,a,GetRnd(0,7));
		}
		i += 1;
	}
	fclose(fpin);
	fclose(fpout);
}

int GetRnd(int min,int max){
	return min + (int)(rand()*(max-min+1.0)/(1.0+RAND_MAX));
}

