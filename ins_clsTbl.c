/*ins_cls.Tbl*/
/*No,26 Tomoki Hanada*/
#include<stdio.h>
#include<stdlib.h>

int main(void){

	int clscode,y;
	char clsname[61],clstch[5];
	FILE *fpin,*fpout;

	if( (fpin=fopen("clsTbl.txt","r")) == NULL ){
		printf("ファイルが見つかりません。--clsTbl.txt\n");
		exit(1);
	}

	if( (fpout=fopen("ins_clsTbl.sql","w")) == NULL ){
		fclose(fpin);
		printf("ファイルが見つかりません。--ins_clsTbl.sql\n");
		exit(1);
	}
	
	while( !feof(fpin) ){
		fscanf(fpin,"%d,%[^,],%[^,],%d ",&clscode,clsname,clstch,&y);
		fprintf(fpout,"INSERT INTO clsTbl(cls_code,cls_Iname,cls_sname,tch_code,cls_y) VALUES(%d,'%s','%s','%s,'%d);\n",clscode,clsname,clstch,y);
	}
	fclose(fpin);
	fclose(fpout);

	return 0;
}

