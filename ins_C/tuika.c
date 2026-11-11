#include <stdio.h>
#include <string.h>

int main() {
    // 読み込み元ファイルと書き込み先ファイルを開く
    FILE *fp_in = fopen("seitoTbl.txt", "r");
    FILE *fp_out = fopen("shozokuTbl.txt", "w");
    
    if (fp_in == NULL || fp_out == NULL) {
        printf("ファイルを開けませんでした。\n");
        return 1;
    }

    char line[256];
    // 1行ずつ読み込む
    while (fgets(line, sizeof(line), fp_in) != NULL) {
        // 最初のカンマの位置を探す
        char *comma = strchr(line, ',');
        if (comma != NULL) {
            *comma = '\0'; // カンマの位置で文字列を終了させる
        }
        
        // 抽出した文字列（ID）を別ファイルに書き出す
        fprintf(fp_out, "%s\n", line);
    }

    // ファイルを閉じる
    fclose(fp_in);
    fclose(fp_out);

    printf("出力が完了しました。\n");
    return 0;
}
