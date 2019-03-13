CREATE TABLE GAME_RESULTS(
    game_Result_Id int not null primary key,
    outcome varchar2(20) not null,
    player1Name varchar2(255) not null,
    player1Id varchar2(255) not null,
    player2Name varchar2(255) not null,
    player2Id varchar2(255) not null
);