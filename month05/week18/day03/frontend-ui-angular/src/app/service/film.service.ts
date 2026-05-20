import { HttpClient, HttpParams } from "@angular/common/http";
import { inject, Inject,Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PageResponse } from "../model/page";
import { Film } from "../model/film";

@Injectable({
    providedIn:'root'
})
export class FilmService{
    private http = inject(HttpClient);
    private apiUrl = 'http://localhost:8080/api/films';

    getFilms(search: string, page: number, size:number, sortBy: string):Observable<PageResponse<Film>>{
        let params = new HttpParams()
        .set('page',page.toString())
        .set('size',size.toString())
        .set('sort',sortBy);

        if(search){
            params= params.set('search',search);

        }
        return this.http.get<PageResponse<Film>>(this.apiUrl,{params});
    }
}