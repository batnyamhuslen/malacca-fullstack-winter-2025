import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  standalone: true,
  imports: [],
  templateUrl: './hello.html',
  styleUrl: './hello.css'
})
export class HelloComponent {
  title = 'Hello, Angular!';

  getMessage(): string {
    return this.title.toUpperCase();
  }
}


