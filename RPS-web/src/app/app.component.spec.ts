import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { StubRpsGateway } from './stub.rps.gateway';
import { RpsGateway } from './rps.gateway';


describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;
  let component: AppComponent;
  let componentEl: any;
  let stubRpsGateway: StubRpsGateway;

  const triggerInput = (id: string, value: string) => {
    const el: HTMLInputElement = componentEl.querySelector(`input[id=${id}]`);
    el.value = value;
    el.dispatchEvent(new Event('input'));
  };

  const triggerSelect = (id: string, value: string) => {
    const el: HTMLInputElement = componentEl.querySelector(`select[id=${id}]`);
    el.value = value;
    el.dispatchEvent(new Event('change'));
  };

  beforeEach(async(() => {
    stubRpsGateway = new StubRpsGateway();

    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [
        AppComponent
      ],
      providers: [
        { provide: RpsGateway, useValue: stubRpsGateway }
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.debugElement.componentInstance;
    fixture.detectChanges();
    componentEl = fixture.debugElement.nativeElement;
  });

  describe('When the component loads', () => {
    it('should create the app', () => {
      expect(component).toBeTruthy();
    });

    it(`should have as title 'Rock, Paper, Scissors'`, () => {
      expect(component.title).toEqual('Rock, Paper, Scissors');
    });

    it('should render title in a h1 tag ', () => {
      expect(componentEl.querySelector('h1').textContent).toContain('Welcome to Rock, Paper, Scissors!');
    });

    it('should send practice game request to gateway', () => {
      spyOn(component, 'playPracticeGame').and.callThrough();
      triggerSelect('player2Throw', 'PAPER');
      triggerInput('player1Name', 'Jane');
      triggerSelect('player1Throw', 'ROCK');
      triggerSelect('player2Throw', 'PAPER');
      expect(componentEl.querySelector('#gameResult').textContent).toBe('');

      const button = componentEl.querySelector('button[id=practiceGame]');
      button.click();
      expect(component.playPracticeGame).toHaveBeenCalled();

      fixture.whenStable().then(() => {
        console.log('In Stable');
        fixture.detectChanges();
        expect(stubRpsGateway.savePlayPracticeGameCalledWith.player1Throw).toBe('ROCK');
        expect(stubRpsGateway.savePlayPracticeGameCalledWith.player2Throw).toBe('PAPER');
        expect(componentEl.querySelector('#gameResult').textContent).toBe('Player 1 Wins');
      });
    });

    it('should send game request to gateway', () => {
      spyOn(component, 'playGame').and.callThrough();
      triggerSelect('player1Throw', 'ROCK');
      triggerSelect('player2Throw', 'PAPER');
      triggerInput('player1Name', 'Jane');
      triggerInput('player2Name', 'John');
      triggerInput('player1Id', 'A001');
      triggerInput('player2Id', 'A002');
      expect(componentEl.querySelector('#gameResult').textContent).toBe('');

      const button = componentEl.querySelector('button[id=playGame]');
      button.click();
      expect(component.playGame).toHaveBeenCalled();

      fixture.whenStable().then(() => {
        console.log('In Stable');
        fixture.detectChanges();
        expect(componentEl.querySelector('#gameResult').textContent).toBe('Player 1 Wins');
      });
    });
  });
});
