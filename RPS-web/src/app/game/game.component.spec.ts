import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameComponent } from './game.component';
import { MaterialModule } from '../material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { StubGameGateway } from './stub.game.gateway';
import { GameGateway, PlayGameRequest } from './game.gateway';
import { FormsModule } from '@angular/forms';
import { HttpGameGateway } from './http.game.gateway';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { PlayPracticeGameRequest } from 'src/app-deprecated/rps.gateway';
import { Player } from 'src/app-deprecated/game';

describe('GameComponent', () => {
  let component: GameComponent;
  let fixture: ComponentFixture<GameComponent>;
  let stubRpsGateway: StubGameGateway;
  let htmlTestBed: any;

  beforeEach(async(() => {
    stubRpsGateway = new StubGameGateway();

    TestBed.configureTestingModule({
      declarations: [ GameComponent ],
      imports: [
        MaterialModule,
        BrowserAnimationsModule,
        FormsModule
      ],
      providers: [
        HttpHandler,
        HttpClient,
        HttpGameGateway,
        { provide: GameGateway, useValue: stubRpsGateway }
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameComponent);
    component = fixture.componentInstance;
    htmlTestBed = fixture.debugElement.nativeElement;
    fixture.detectChanges();
  });

  function triggerInput(id: string, passedValue: string)  {
    const element: HTMLInputElement = /*htmlTestBed.querySelector(`input[id=${id}]`);*/ fixture.nativeElement.querySelector(`#${id}`);
    element.value = passedValue;
    element.dispatchEvent(new Event('input'));
  }

  function triggerSelect(id: string, passedValue: string) {
    const element: HTMLInputElement = /*htmlTestBed.querySelector(`select[id=${id}]`);*/ fixture.nativeElement.querySelector(`#${id}`);
    element.value = passedValue;
    element.dispatchEvent(new Event('change'));
  }

  it('should toggle between ranked and practice game', () => {
    expect(component.isPracticeGame).toBe(false);

    expect(fixture.nativeElement.querySelector('#player1Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Id')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Id')).toBeTruthy();

    const toggle = fixture.nativeElement.querySelector('#gameToggle');
    toggle.click();

    expect(component.isPracticeGame).toBe(true);
    expect(fixture.nativeElement.querySelector('#player1Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Name')).toBeFalsy();
    expect(fixture.nativeElement.querySelector('#player2Name')).toBeFalsy();
    expect(fixture.nativeElement.querySelector('#player1Id')).toBeFalsy();
    expect(fixture.nativeElement.querySelector('#player2Id')).toBeFalsy();
  });

  xit('should process a ranked game through the gateway', () => {
    triggerSelect('player1Name', 'Jane Doe');
    triggerSelect('player2Name', 'John Doe');
    triggerInput('player1Id', 'AA01');
    triggerInput('player2Id', 'AA02');
    triggerSelect('player1Throw', 'PAPER');
    triggerSelect('player2Throw', 'ROCK');

    fixture.nativeElement.querySelector('#submit-ranked').click();

    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const player1 = new Player(component.player1Name, component.player1Id);
      const player2 = new Player(component.player2Name, component.player2Id);
      stubRpsGateway.playGame(new PlayGameRequest(player1, player2, component.player1Throw, component.player2Throw)).subscribe(result => {
        fixture.detectChanges();
        expect(component.mostRecentOutcome).toBe('P1_WINS');
      });
    });
  });

  fit('should process a practice game through the gateway', () => {

    // const toggle = fixture.nativeElement.querySelector('#gameToggle');
    // toggle.click();
    component.isPracticeGame = true;
    //expect(component.isPracticeGame).toBeFalsy();
    fixture.detectChanges();
    triggerSelect('player1Throw', 'SCISSORS');
    triggerSelect('player2Throw', 'ROCK');

    const submit = fixture.nativeElement.querySelector('#submit-practice');

    submit.click();

    fixture.whenStable().then(() => {
      fixture.detectChanges();
      expect(stubRpsGateway.playPracticeGameCalledWith.player1Throw).toBe('SCISSORS');
      expect(stubRpsGateway.playPracticeGameCalledWith.player2Throw).toBe('ROCK');
    });
  });
});
