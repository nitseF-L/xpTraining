import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameComponent } from './game.component';

describe('GameComponent', () => {
  let component: GameComponent;
  let fixture: ComponentFixture<GameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should render the UI', () => {
    // expect(component.isPracticeGame).toBe(false);
    expect(fixture.nativeElement.querySelector('#player1Throw')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Throw')).toBeTruthy();

    expect(fixture.nativeElement.querySelector('#player1Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Name')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player1Id')).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#player2Id')).toBeTruthy();


  });
});
