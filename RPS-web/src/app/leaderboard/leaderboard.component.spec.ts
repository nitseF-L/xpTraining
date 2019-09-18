import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaderboardComponent } from './leaderboard.component';
import { StubGameGateway } from '../game/stub.game.gateway';
import { GameGateway } from '../game/game.gateway';
import { By } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

describe('LeaderboardComponent', () => {
  let component: LeaderboardComponent;
  let fixture: ComponentFixture<LeaderboardComponent>;
  let stubRpsGateway: StubGameGateway;

  beforeEach(async(() => {
    stubRpsGateway = new StubGameGateway();

    TestBed.configureTestingModule({
      declarations: [ LeaderboardComponent ],
      imports: [
        BrowserAnimationsModule,
        FormsModule
      ],
      providers: [
        { provide: GameGateway, useValue: stubRpsGateway }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {

    fixture = TestBed.createComponent(LeaderboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create leaderboard with data', () => {
    expect(component).toBeTruthy();
    let tableRows = fixture.nativeElement.querySelectorAll('tr');
    console.log( 'tableRows: ', tableRows );
    // Data rows
    let row1 = tableRows[1];
    expect(row1.cells[1].innerHTML).toBe('87.2');
    expect(row1.cells[1].style.backgroundColor).toBe('red');
    expect(row1.cells[2].innerHTML).toBe('10');
    expect(row1.cells[3].innerHTML).toBe('10');
    expect(row1.cells[4].innerHTML).toBe('0');
    expect(row1.cells[5].innerHTML).toBe('0');
    expect(row1.cells[6].innerHTML).toBe('80');
    expect(row1.cells[6].style.backgroundColor).toBe('orange');
    expect(row1.cells[7].innerHTML).toBe('13.5');
    expect(row1.cells[7].style.backgroundColor).toBe('blue');
    expect(row1.cells[8].innerHTML).toBe('5.8');
    expect(row1.cells[8].style.backgroundColor).toBe('blue');

    let row2 = tableRows[2];
    expect(row2.cells[1].innerHTML).toBe('73.5');
    expect(row2.cells[1].style.backgroundColor).toBe('orange');
    expect(row2.cells[2].innerHTML).toBe('10');
    expect(row2.cells[3].innerHTML).toBe('6');
    expect(row2.cells[4].innerHTML).toBe('2');
    expect(row2.cells[5].innerHTML).toBe('2');
    expect(row2.cells[6].innerHTML).toBe('50');
    expect(row2.cells[6].style.backgroundColor).toBe('');
    expect(row2.cells[7].innerHTML).toBe('20');
    expect(row2.cells[7].style.backgroundColor).toBe('cyan');
    expect(row2.cells[8].innerHTML).toBe('30');
    expect(row2.cells[8].style.backgroundColor).toBe('cyan');

    let row3 = tableRows[3];
    expect(row3.cells[1].innerHTML).toBe('42.4');
    expect(row3.cells[1].style.backgroundColor).toBe('');
    expect(row3.cells[2].innerHTML).toBe('10');
    expect(row3.cells[3].innerHTML).toBe('2');
    expect(row3.cells[4].innerHTML).toBe('4');
    expect(row3.cells[5].innerHTML).toBe('4');
    expect(row3.cells[6].innerHTML).toBe('20');
    expect(row3.cells[6].style.backgroundColor).toBe('cyan');
    expect(row3.cells[7].innerHTML).toBe('10');
    expect(row3.cells[7].style.backgroundColor).toBe('blue');
    expect(row3.cells[8].innerHTML).toBe('70');
    expect(row3.cells[8].style.backgroundColor).toBe('orange');
    
    stubRpsGateway.playerStats[0].gamesWon = 11;
    const player = fixture.nativeElement.querySelector('button');
    console.log('Button', player);
    player.click();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      let tableRows = fixture.nativeElement.querySelectorAll('tr');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Stats for Player 1');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Winning Percentage: 87.2%');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Rocks Thrown (%): 80%');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Papers Thrown (%): 13.5%');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Scissors Thrown (%): 5.8%');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Lizards Thrown (%): 20.2%');
      expect( fixture.nativeElement.querySelector('#playerStats').innerHTML ).toContain( 'Spocks Thrown (%): 9.2%');



      let row1 = tableRows[1];
      expect(row1.cells[0].innerHTML).toBe('Player 2');
      expect(row1.cells[1].innerHTML).toBe('WON');
      expect(row1.cells[2].innerHTML).toBe('ROCK');
      expect(row1.cells[3].innerHTML).toBe('SCISSORS');

      let tableColor = fixture.debugElement.queryAll(By.css('tr'));

      expect(tableColor[1].nativeElement.cells[1].style.backgroundColor).toBe('rgb(124, 252, 0)');
      expect(tableColor[2].nativeElement.cells[1].style.backgroundColor).toBe('rgb(255, 0, 0)');
      expect(tableColor[3].nativeElement.cells[1].style.backgroundColor).toBe('rgb(0, 255, 255)');
      // expect(tableColor[2].style.backgroundColor).toBe('#ff0000');

    });
  });

  it('should refresh leaderboard with data', () => {
    expect(component).toBeTruthy();
    let tableRows = fixture.nativeElement.querySelectorAll('tr');
    console.log( 'tableRows: ', tableRows );
    // Data rows
    let row1 = tableRows[1];
    expect(row1.cells[1].innerHTML).toBe('87.2');
    expect(row1.cells[2].innerHTML).toBe('10');
    expect(row1.cells[3].innerHTML).toBe('10');
    expect(row1.cells[4].innerHTML).toBe('0');

    stubRpsGateway.playerStats[0].gamesWon = 11;
    stubRpsGateway.playerStats[0].winPercentage = 95;
    stubRpsGateway.playerStats[0].rockPercent = 80;
    const refresh = fixture.nativeElement.querySelector('button.refresh');
    console.log('Button', refresh);
    refresh.click();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      let tableRows = fixture.nativeElement.querySelectorAll('tr');
      let row1 = tableRows[1];
      expect(row1.cells[1].innerHTML).toBe('95');
      expect(row1.cells[3].innerHTML).toBe('11');
      expect(row1.cells[6].innerHTML).toBe('80');
    });
  });

});
