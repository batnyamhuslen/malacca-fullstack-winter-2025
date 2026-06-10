import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BehaviorSubject, Observable, Subject, combineLatest } from 'rxjs';
import { debounceTime, tap, switchMap, startWith, distinctUntilChanged } from 'rxjs/operators';
import { FilmService } from '../../services/film.service';
import { Page } from '../../models/page';
import { Film } from '../../models/film';
@Component({
  selector: 'app-film-dashboard',
  templateUrl: './film-dashboard.html',
  styleUrls: ['./film-dashboard.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class FilmDashboard implements OnInit {
  private filmService = inject(FilmService);

  filmsPage$!: Observable<Page<Film>>;
  isLoading = false;

  private page$ = new BehaviorSubject<number>(0);
  private size$ = new BehaviorSubject<number>(10);
  private search$ = new BehaviorSubject<string>("");


  ngOnInit(): void {
    this.filmsPage$ = combineLatest([
      this.page$,
      this.size$,
      this.search$.pipe(
        debounceTime(1000),
        distinctUntilChanged()
      ),
    ]).pipe(
      tap(() => this.isLoading = true),
      switchMap(([page,size,search]) =>
        this.filmService.getFilms(page,size,search)
      ),
      tap(() => this.isLoading = false)
    );
  }

  onSearchChange(value: string): void {
    this.search$.next(value);
    this.page$.next(0);
  }

  onPageChange(page: number): void {
    this.page$.next(page);
  }
}


