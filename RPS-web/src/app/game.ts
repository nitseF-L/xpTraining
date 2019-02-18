

export interface Game {
    p1Throw: Throw;
    p2Throw: Throw;
    outcome: OutCome;
}

export enum Throw {
    Rock = 'ROCK',
    Paper = 'PAPER',
    Scissors = 'SCISSORS'
}

export const throwLocalization = {
    [Throw.Rock]: 'Rock',
    [Throw.Paper]: 'Paper',
    [Throw.Scissors]: 'Scissors'
}

export enum OutCome {
    P1Wins = 'P1_WINS',
    P2Wins = 'P2_WINS',
    Tie = 'TIE'
}

export const outcomeLocatization = {
    [OutCome.P1Wins]: 'Player 1 Wins',
    [OutCome.P2Wins]: 'Player 2 Wins',
    [OutCome.Tie]: 'Tie'
}