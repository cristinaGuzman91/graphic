#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <mysql/mysql.h>

int main(int argc, char *argv[]) {
	MYSQL *conn;
	char *server = argv[1];
	char *user = argv[2];
	char *password = argv[3];
	char *database = "mysql";

	char *query;
	char *q1 = "INSERT INTO sensorlist (slId, slName1, slName2, slName3, slInsertTimestamp, slActualTimestamp, slGMTOffset, slActualValue, slActualStatus) VALUES (%d, 'FOO', 'BAR', '123', FROM_UNIXTIME(%d), FROM_UNIXTIME(%d), 7, %d, 1);";

	int slid = atoi(argv[4]);
	int tout = 2;
	int val = 500;
	time_t now;

	conn = mysql_init(NULL);

	if (!mysql_real_connect(conn, server,
		user, password, database, 0, NULL, 0)) {
		fprintf(stderr, "%s\n", mysql_error(conn));
		exit(1);
	}

	while(1) {
		if((query = malloc(strlen(q1) + 64)) != NULL) {
			query[0] = '\0';
			now = time(&now);
			sprintf(query, q1, slid, now, now, val + rand() % 100);
			mysql_query(conn, query);
//			printf("%s\n", query);
//			printf("%d\n", strlen(q1));
			free(query);
			sleep(tout);
		} else {
			printf("Query / malloc error\n");
			exit(1);
		}
	}
	mysql_close(conn);
	return 0;
}