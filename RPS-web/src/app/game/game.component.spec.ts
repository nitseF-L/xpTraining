import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameComponent } from './game.component';
import { MaterialModule } from '../material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { StubGameGateway } from './stub.game.gateway';
import { GameGateway } from './game.gateway';
import { FormsModule } from '@angular/forms';

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

  function triggerSelect(id: string, passedValue: string) {
    const element: HTMLInputElement = fixture.nativeElement.querySelector(`#${id}`);
    element.value = passedValue;
    element.dispatchEvent(new Event('change'));
  }

  function triggerInput(id: string, passedValue: string) {
    const element: HTMLInputElement = fixture.nativeElement.querySelector(`#${id}`);
    element.value = passedValue;
    element.dispatchEvent(new Event('input'));
  }

  it('should toggle between ranked and practice game', () => {
    expect(component.isPracticeGame).toBe(false);

    expect(fixture.nativeElement.querySelector('#player1Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Id')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Id')).toBeTruthy();

    // const toggle = fixture.nativeElement.querySelector('#gameModeToggle');
    // toggle.click();
    // fixture.detectChanges();

    component.flipToggle();
    fixture.detectChanges();

    expect(component.isPracticeGame).toBe(true);
    expect(fixture.nativeElement.querySelector('#player1Name')).toBeNull();
    expect(fixture.nativeElement.querySelector('#player1Id')).toBeNull();
    expect(fixture.nativeElement.querySelector('#player1Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Name')).toBeNull();
    expect(fixture.nativeElement.querySelector('#player2Id')).toBeNull();
    expect(fixture.nativeElement.querySelector('#player2Throw')).toBeTruthy();
  });

  it('should process a ranked game through the gateway',  async(() => {
    component.isPracticeGame = false;
    fixture.detectChanges();
    triggerSelect('player1Throw', 'PAPER');
    triggerInput('player1Name', 'Player 1');
    triggerInput('player1Id', '12345');

    triggerSelect('player2Throw', 'PAPER');
    triggerInput('player2Name', 'Player 2');
    triggerInput('player2Id', '67890');

    const submit = fixture.nativeElement.querySelector('#submit-ranked');
    submit.click();

    fixture.whenStable().then(() => {
      fixture.detectChanges();
      expect(stubRpsGateway.playGameCalledWith.player1Throw).toBe('PAPER');
      expect(stubRpsGateway.playGameCalledWith.player1.name).toBe('Player 1');
      expect(stubRpsGateway.playGameCalledWith.player1.id).toBe('12345');

      expect(stubRpsGateway.playGameCalledWith.player2Throw).toBe('PAPER');
      expect(stubRpsGateway.playGameCalledWith.player2.name).toBe('Player 2');
      expect(stubRpsGateway.playGameCalledWith.player2.id).toBe('67890');
    });
  }));

  it('should process a practice game through the gateway', async(() => {
    component.isPracticeGame = true;
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
  }));
});
