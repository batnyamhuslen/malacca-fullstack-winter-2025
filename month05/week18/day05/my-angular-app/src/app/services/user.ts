import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// User-ийн бүтэц (backend-ийн User entity-тэй ижил байх)
export interface User {
  id: number;
  name: string;
  email: string;
}

@Injectable({
  providedIn: 'root'  // Бүх газраас ашиглах боломжтой
})
export class UserService {

  // Backend-ийн URL
  private apiUrl = 'http://localhost:8080/api/users';

  // HttpClient-г constructor-оор inject хийнэ
  constructor(private http: HttpClient) { }

  // Бүх хэрэглэгчийг авах
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  // Шинэ хэрэглэгч үүсгэх
  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user);
  }
}