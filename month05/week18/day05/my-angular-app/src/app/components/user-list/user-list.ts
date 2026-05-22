import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService, User } from '../../services/user';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],     // *ngIf, *ngFor ашиглахын тулд хэрэгтэй
  templateUrl: './user-list.html',
  styleUrls: ['./user-list.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];        // Хэрэглэгчдийн жагсаалт
  loading = true;            // Ачааллаж байгаа эсэх
  errorMessage = '';         // Алдааны мессеж

  constructor(private userService: UserService, private cdr: ChangeDetectorRef) { }

  // Component ачаалагдахад автоматаар дуудагдана
  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.loading = true;
    this.errorMessage = '';

    this.userService.getUsers().subscribe({
      next: (data) => {
        // Хариу амжилттай ирсэн
        this.users = data;
        this.loading = false;
        this.cdr.detectChanges();
       
      },
      error: (err) => {
        // Алдаа гарсан
        this.errorMessage = 'Backend-тэй холбогдоход алдаа: ' + err.message;
        this.loading = false;
        this.cdr.detectChanges();
        console.error('Error:', err);
      }
    });
  }
  
}