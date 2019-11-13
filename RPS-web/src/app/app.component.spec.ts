import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AppComponent } from './app.component';


describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('should show options when you click the hamburger', () => {
    const beforeClick = component.sidebarOpen;
    const hamburger = fixture.nativeElement.querySelector('#hamburger-stack');
    hamburger.click();
    const afterClick = component.sidebarOpen;
    expect(beforeClick).not.toEqual(afterClick);

    expect(fixture.nativeElement.querySelector('#sidebar').textContent()).toContain('Play Game');

  });

});
