import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmDashboard } from './film-dashboard';

describe('FilmDashboard', () => {
  let component: FilmDashboard;
  let fixture: ComponentFixture<FilmDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FilmDashboard],
    }).compileComponents();

    fixture = TestBed.createComponent(FilmDashboard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
