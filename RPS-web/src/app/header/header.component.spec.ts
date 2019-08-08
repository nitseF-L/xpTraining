import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HeaderComponent } from './header.component';
import { MaterialModule } from 'src/material.module';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderComponent ],
      imports: [
        MaterialModule
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should toggle showSideNav when clicked on the hamburger icon', () => {
    expect(component.showSideNav).toEqual(false);
    const hamburger = fixture.nativeElement.querySelector('#hamburger-stack');
    hamburger.click();
    fixture.detectChanges();
    expect(component.showSideNav).toEqual(true);
    // expect(fixture.debugElement.nativeElement.querySelector('#sidebar').textContent).toContain('Play Game');
  });
});
