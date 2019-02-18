import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { By } from '@angular/platform-browser';
import { ComponentTestHelper } from './component-test-helper';
import { StubRpsGateway } from './stub.rps.gateway';
import { RpsGateway } from './rps.gateway';
import { FormsModule } from '@angular/forms';


describe('AppComponent', () => {

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


  describe('When the component loads', () => {
    
    it('should create the app', () => {
      const fixture = TestBed.createComponent(AppComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app).toBeTruthy();
    });

    it(`should have as title 'Rock, Paper, Scissors'`, () => {
      const fixture = TestBed.createComponent(AppComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app.title).toEqual('Rock, Paper, Scissors');
    });

    it('should render title in a h1 tag ', () => {
      const fixture = TestBed.createComponent(AppComponent);
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelector('h1').textContent).toContain('Welcome to Rock, Paper, Scissors!');
    });

    it('should send game request to gateway', () => {
      const fixture = TestBed.createComponent(AppComponent);
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      const p1Input: HTMLInputElement = compiled.querySelector('select[id=player1Throw]');
      p1Input.value = 'ROCK';
      p1Input.dispatchEvent( new Event('change'));
      
      const p2Input: HTMLInputElement = compiled.querySelector('select[id=player2Throw]');
      p2Input.value = 'PAPER';
      p2Input.dispatchEvent( new Event('change'));
      
      let button = compiled.querySelector('button');
      button.click();
      fixture.detectChanges();
    
      fixture.whenStable().then( () => {
        console.log( 'In Stable');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.p1Throw).toBe('ROCK');
        expect(stubRpsGateway.savePlayPraticeGameCalledWith.p2Throw).toBe('PAPER');
      });
      //field.dispatchEvent( new Event( 'input'));
      expect(compiled.querySelector('h1').textContent).toContain('Welcome to Rock, Paper, Scissors!');
    });

  });
});
