import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarComponent } from './sidebar.component';
import { CUSTOM_ELEMENTS_SCHEMA, DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { MaterialModule } from '../material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('SidebarComponent', () => {
  let component: SidebarComponent;
  let fixture: ComponentFixture<SidebarComponent>;
  let hamburgerEl: DebugElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarComponent ],
      imports: [ 
        MaterialModule,
        BrowserAnimationsModule
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarComponent);
    component = fixture.componentInstance;
    hamburgerEl = fixture.debugElement.query(By.css('#hamburger-stack'));
    fixture.detectChanges();
  });

  it('should show options when you click the hamburger', () => {
    expect(component.sidebarOpen).toEqual(false);
    const hamburger = fixture.nativeElement.querySelector('#hamburger-stack');
    hamburger.click();
    fixture.detectChanges();
    expect(component.sidebarOpen).toEqual(true);
    expect(fixture.nativeElement.querySelector('#sidebar').textContent).toContain('Play Game');
  });
});
