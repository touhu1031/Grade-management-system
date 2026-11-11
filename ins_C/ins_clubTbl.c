/*2026.10.29*/
/*ins_clubTbl*/
/*J3 26 Tomoki Hanada*/
#include<stdio.h>
#include<stdlib.h>

int main(void){

	char clubcode[5],clubname[61],clubbunrui[4],clubtch[5];
	FILE *fpin,*fpout;

	if( (fpin=fopen("clubTbl.txt","r")) == NULL ){
		printf("ファイルが見つかりません。--clubTbl.txt\n");
		exit(1);
	}

	if( (fpout=fopen("ins_clubTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--ins_clubTbl.sql\n");
		exit(1);
	}
	
	while( !feof(fpin) ){
		fscanf(fpin," %[^,],%[^,],%[^,],%s ",clubcode,clubname,clubbunrui,clubtch);
		fprintf(fpout,"INSERT INTO clubTbl(club_code,club_name,club_bunrui,tch_code) VALUES('%s','%s','%s','%s');\n",clubcode,clubname,clubbunrui,clubtch);
	}
	fclose(fpin);
	fclose(fpout);

	return 0;
}

