import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameComponent } from './game.component';
import { MaterialModule } from '../material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { StubRpsGateway } from './stub.game.gateway';
import { RpsGateway } from './game.gateway';

describe('GameComponent', () => {
  let component: GameComponent;
  let fixture: ComponentFixture<GameComponent>;
  let stubRpsGateway: StubRpsGateway;
  let htmlTestBed: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameComponent ],
      imports: [
        MaterialModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: RpsGateway, useValue: stubRpsGateway }
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
    const element: HTMLInputElement = htmlTestBed.querySelector(`input[id=${id}]`);
    element.value = passedValue;
    element.dispatchEvent(new Event('input'));
  }

  function triggerSelect(id: string, passedValue: string) {
    const element: HTMLInputElement = htmlTestBed.querySelector(`select[id=${id}]`);
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

  it('should process a ranked game through the gateway', () => {
    // arrange
    // fill in the values for players one and two
    triggerSelect('player1Name', 'Jane Doe');
    triggerSelect('player2Name', 'John Doe');
    triggerInput('player1Id', 'AA01');
    triggerInput('player2Id', 'AA02');
    triggerSelect('player1Throw', 'ROCK');
    triggerSelect('player2Throw', 'PAPER');

    // act
    // click the submit button
    fixture.nativeElement.querySelector('#submit').click();

    // assert
    // expect the (stub) gateway is called with the correct values
    expect(stubRpsGateway.submitCalledWith).toEqual();

  });
});
