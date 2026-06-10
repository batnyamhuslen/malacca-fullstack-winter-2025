import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../models/page';
import { Film } from '../models/film';

@Injectable({
  providedIn: 'root',
})
export class FilmService {
  // getFilms(search: string, page: number, arg2: number): any {
  //   throw new Error('Method not implemented.');
  // }
  private apiUrl = 'http://localhost:8080/api/films'

  private http = inject(HttpClient);

  getFilms(page:number,size:number,search:string): Observable<Page<Film>>{
    const params = new HttpParams()
    .set('page', page.toString())
    .set('size', size.toString())
    .set('search', search)

    return this.http.get<Page<Film>>(this.apiUrl,{params});
  }
}
