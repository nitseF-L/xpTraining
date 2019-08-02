CREATE TABLE GAME_RESULTS(
    game_Result_Id int not null primary key,
    outcome varchar(20) not null,
    player1Name varchar(255) not null,
    player1Id varchar(255) not null,
    player2Name varchar(255) not null,
    player2Id varchar(255) not null
);