#include<stdio.h>
#include<stdlib.h>

int main(void){

	char icode[5],iname[61];
	FILE *fpin,*fpout;

	if( (fpin=fopen("boardTbl.txt","r")) == NULL ){
		printf("ファイルが見つかりません。--clubTbl.txt\n");
		exit(1);
	}

	if( (fpout=fopen("ins_boardTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--ins_clubTbl.sql\n");
		exit(1);
	}
	
	while( !feof(fpin) ){
		fscanf(fpin," %[^,],%s ",iname,icode);
		fprintf(fpout,"INSERT INTO boardTbl(i_name,i_code)");
		fprintf(fpout,"VALUES(%s,%s);\n",iname,icode);
	}
	fclose(fpin);
	fclose(fpout);

	return 0;
}
