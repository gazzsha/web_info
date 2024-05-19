CREATE
    DATABASE web_info ENCODING 'UTF8';

CREATE
    USER student WITH PASSWORD 'student';

GRANT CONNECT ON DATABASE web_info TO student;

GRANT pg_read_all_data TO student;

GRANT pg_write_all_data TO student;


DROP TABLE IF EXISTS Friends;
DROP TABLE IF EXISTS peers;
DROP TABLE IF EXISTS task;

DROP TABLE IF EXISTS checks;

DROP TABLE IF EXISTS Recommendations;
DROP TABLE IF EXISTS TransferredPoints;

DROP TABLE IF EXISTS TimeTracking;

DROP TABLE IF EXISTS XP;

DROP TABLE IF EXISTS Verter;

DROP TABLE IF EXISTS P2P;


CREATE TYPE status AS ENUM ('Start','Success','Failure');


CREATE TABLE IF NOT EXISTS Peers
(
    Nickname VARCHAR(255) NOT NULL PRIMARY KEY,
    Birthday DATE         NOT NULL
);

CREATE TABLE IF NOT EXISTS TASK
(
    Title      VARCHAR(255) PRIMARY KEY,
    ParentTask VARCHAR(255) DEFAULT NULL,
    MaxXP      NUMERIC NOT NULL,
    CONSTRAINT fk_task_title FOREIGN KEY (ParentTask) REFERENCES Task (Title),
    CONSTRAINT fk_task_check_title CHECK (Title != ParentTask)
);


CREATE TABLE IF NOT EXISTS Checks
(
    ID   SERIAL PRIMARY KEY,
    Peer VARCHAR(255) NOT NULL,
    Task VARCHAR(255) NOT NULL,
    Date DATE         NOT NULL,
    CONSTRAINT fk_checks_peer FOREIGN KEY (Peer) REFERENCES Peers (Nickname),
    CONSTRAINT fk_checks_task FOREIGN KEY (Task) REFERENCES Task (title)
);
CREATE TABLE IF NOT EXISTS Friends
(
    "ID"  SERIAL PRIMARY KEY,
    Peer1 VARCHAR(255) NOT NULL,
    Peer2 VARCHAR(255) NOT NULL,
    CONSTRAINT fk_friend_1 FOREIGN KEY (Peer1) REFERENCES Peers (Nickname),
    CONSTRAINT fk_friend_2 FOREIGN KEY (Peer2) REFERENCES Peers (Nickname),
    CONSTRAINT unique_check_friend CHECK (Peer1 != Peer2)
);

CREATE TABLE IF NOT EXISTS Recommendations
(
    ID              SERIAL PRIMARY KEY,
    Peer            VARCHAR(255) NOT NULL,
    RecommendedPeer VARCHAR(255) NOT NULL,
    CONSTRAINT fk_recommend_peer_1 FOREIGN KEY (Peer) REFERENCES Peers (Nickname),
    CONSTRAINT fk_recommend_peer_2 FOREIGN KEY (RecommendedPeer) REFERENCES Peers (Nickname),
    CONSTRAINT unique_check_recommend_peers CHECK (Peer != RecommendedPeer)
);

CREATE TABLE IF NOT EXISTS TransferredPoints
(
    ID           SERIAL PRIMARY KEY,
    CheckingPeer VARCHAR(255) NOT NULL,
    CheckedPeer  VARCHAR(255) NOT NULL,
    PointAmount  INT,
    CONSTRAINT fk_transfer_peer_1 FOREIGN KEY (CheckingPeer) REFERENCES Peers (Nickname),
    CONSTRAINT fk_transfer_peer_2 FOREIGN KEY (CheckedPeer) REFERENCES Peers (Nickname),
    CONSTRAINT unique_check_transfer_peers CHECK (CheckingPeer != CheckedPeer)
);

CREATE TABLE IF NOT EXISTS TimeTracking
(
    ID     SERIAL PRIMARY KEY,
    Peer   VARCHAR(255)           NOT NULL,
    "Date" Date                   NOT NULL,
    "Time" TIME WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIME,
    State  int                    NOT NULL,
    CONSTRAINT range_check_state CHECK (State IN (1, 2)),
    CONSTRAINT fk_time_tracking_peer FOREIGN KEY (Peer) REFERENCES Peers (Nickname)
);

CREATE TABLE IF NOT EXISTS XP
(
    ID       SERIAL PRIMARY KEY,
    "Check"  INT     NOT NULL,
    XPAmount NUMERIC NOT NULL,
    CONSTRAINT fk_xp_check FOREIGN KEY ("Check") REFERENCES Checks (ID)
);

CREATE TABLE IF NOT EXISTS Verter
(
    ID      SERIAL PRIMARY KEY,
    "Check" INT    NOT NULL,
    "State" Status NOT NULL,
    "Time"  TIME   NOT NULL,
    CONSTRAINT fk_verter_check FOREIGN KEY ("Check") REFERENCES Checks (ID)
);


CREATE TABLE IF NOT EXISTS P2P
(
    ID           SERIAL PRIMARY KEY,
    "Check"      INT          NOT NULL,
    CheckingPeer VARCHAR(255) NOT NULL,
    "State"      Status       NOT NULL,
    "Time"       TIME         NOT NULL,
    CONSTRAINT fk_p2p_check FOREIGN KEY ("Check") REFERENCES Checks (ID),
    CONSTRAINT fk_p2p_checkingpeer FOREIGN KEY (CheckingPeer) REFERENCES Peers (nickname)
);



CREATE OR REPLACE PROCEDURE import_table(
    name_table VARCHAR(64),
    path_table varchar(255),
    delim varchar(1)
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    EXECUTE FORMAT(
            'COPY %1$s FROM %2$L WITH DELIMITER ''%3$s'' CSV HEADER',
            name_table,
            path_table,
            delim
            );
END;
$$;


CREATE OR REPLACE PROCEDURE export_table(
    name_table VARCHAR(64),
    path_table varchar(255),
    delim varchar(1)
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    EXECUTE FORMAT(
            'COPY %1$s TO %2$L WITH DELIMITER ''%3$s'' CSV HEADER',
            name_table,
            path_table,
            delim
            );
END;
$$;


show data_directory;


CALL import_table('Peers', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_peers.csv', ',');
CALL import_table('Recommendations', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_recommended.csv', ',');
CALL import_table('Friends', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_friends.csv', ',');
CALL import_table('TimeTracking', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_timetrack.csv', ',');
CALL import_table('Task', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_task.csv', ',');
CALL import_table('Checks', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_checks.csv', ',');
CALL import_table('P2P', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_p2p.csv', ',');
CALL import_table('TransferredPoints', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_point_tras.csv', ',');
CALL import_table('Verter', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_verter.csv', ',');
CALL import_table('XP', 'D:/school_21_projects/Java_Learn/SpringIdea/web_info/src/main/resources/data_xml/data_xp.csv', ',');


select * from TimeTracking;

SELECT timetracking."Date" from timetracking


select * from friends GROUP BY peer1;
