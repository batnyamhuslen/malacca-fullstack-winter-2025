import { CommonModule } from '@angular/common';
import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FilmService } from '../../service/film.service';
import { Film } from '../../model/film';
import { debounceTime, distinctUntilChanged, Subject, Subscription } from 'rxjs';

@Component({
  selector: 'app-film-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './film-dashboard.html',
  styleUrl: './film-dashboard.css',
})
export class FilmDashboard implements OnInit, OnDestroy {
  private filmService = inject(FilmService);
  // interface state variables
  films: Film[] = [];
  searchTerm: string = '';
  currentPage: number = 0;
  pageSize: number = 10;
  sortBy: string = 'title,asc';
  totalElements: number = 0;
  totalPages: number = 0;

  private searchSubject = new Subject<string>();
  private searchSubscription!: Subscription;
  
  ngOnInit(): void {
    this.loadFilms();

    this.searchSubscription = this.searchSubject.pipe(
      debounceTime(400),
      distinctUntilChanged()
    ).subscribe(value => {
      this.searchTerm = value;
      this.currentPage = 0;
      this.loadFilms();
    });
  }

  loadFilms(): void {
    this.filmService.getFilms(this.searchTerm, this.currentPage, this.pageSize, this.sortBy)
      .subscribe({
        next: (response: { content: Film[]; totalElements: number; totalPages: number; }) => {
          this.films = response.content;
          this.totalElements = response.totalElements;
          this.totalPages = response.totalPages;
        }
      })
  }

  onSearch(event: Event): void {
    const value = (event.target as HTMLInputElement).value;
    this.searchSubject.next(value);
  }

  onSortChange(event: Event): void {
    this.sortBy = (event.target as HTMLSelectElement).value;
    this.loadFilms();
  }

  changePage(newPage: number): void {
    if(newPage>=0 && newPage < this.totalPages){
      this.currentPage = newPage;
      this.loadFilms();
    }
  }

  ngOnDestroy(): void {
    if (this.searchSubscription){
      this.searchSubscription.unsubscribe();
    }
  }
  
}