import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { StubRpsGateway } from './stub.rps.gateway';
import { RpsGateway } from './rps.gateway';
import { FormsModule } from '@angular/forms';


describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;
  let component: AppComponent;
  let componentEl: any;
  let stubRpsGateway: StubRpsGateway;

  beforeEach(async(() => {

    stubRpsGateway = new StubRpsGateway();

    TestBed.configureTestingModule({
      imports: [ FormsModule ],
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

    it('should send pratice game request to gateway', () => {
      const compiled = fixture.debugElement.nativeElement;

      const p2Input: HTMLInputElement = compiled.querySelector('select[id=player2Throw]');
      p2Input.value = 'PAPER';
      p2Input.dispatchEvent( new Event('change'));

      const p1Name: HTMLInputElement = compiled.querySelector('input[id=player1Name]');
      p1Name.value = 'Jane';
      p1Name.dispatchEvent( new Event('input'));

      const p1Input: HTMLInputElement = compiled.querySelector('select[id=player1Throw]');
      p1Input.value = 'ROCK';
      p1Input.dispatchEvent( new Event('change'));

      const p3Input: HTMLInputElement = compiled.querySelector('select[id=player2Throw]');
      p3Input.value = 'PAPER';
      p3Input.dispatchEvent( new Event('change'));

      const button = compiled.querySelector('button[id=praticeGame]');
      button.click();
      fixture.detectChanges();

      fixture.whenStable().then( () => {
        console.log( 'In Stable');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.player1Throw).toBe('ROCK');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.player2Throw).toBe('PAPER');
      });
      expect(compiled.querySelector('h1').textContent).toContain('Welcome to Rock, Paper, Scissors!');
    });

    it('should send game request to gateway', () => {
      const compiled = fixture.debugElement.nativeElement;
      const p1Input: HTMLInputElement = compiled.querySelector('select[id=player1Throw]');
      p1Input.value = 'ROCK';
      p1Input.dispatchEvent( new Event('change'));

      const p2Input: HTMLInputElement = compiled.querySelector('select[id=player2Throw]');
      p2Input.value = 'PAPER';
      p2Input.dispatchEvent( new Event('change'));

      const p1Name: HTMLInputElement = compiled.querySelector('input[id=player1Name]');
      p1Name.value = 'Jane';
      p1Name.dispatchEvent( new Event('input'));

      const p2Name: HTMLInputElement = compiled.querySelector('input[id=player2Name]');
      p2Name.value = 'John';
      p2Name.dispatchEvent( new Event('input'));

      const p1Id: HTMLInputElement = compiled.querySelector('input[id=player1Id]');
      p1Id.value = 'A001';
      p1Id.dispatchEvent( new Event('input'));

      const p2Id: HTMLInputElement = compiled.querySelector('input[id=player2Id]');
      p2Id.value = 'A002';
      p2Id.dispatchEvent( new Event('input'));

      const button = compiled.querySelector('button[id=praticeGame]');
      button.click();
      fixture.detectChanges();

      fixture.whenStable().then( () => {
        console.log( 'In Stable');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.player1Throw).toBe('ROCK');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.player2Throw).toBe('PAPER');
      });
      expect(compiled.querySelector('h1').textContent).toContain('Welcome to Rock, Paper, Scissors!');
    });

  });
});
