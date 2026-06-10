import { Routes } from '@angular/router';
import { FilmDashboard } from './components/film-dashboard/film-dashboard';

export const routes: Routes = [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: FilmDashboard},
];
