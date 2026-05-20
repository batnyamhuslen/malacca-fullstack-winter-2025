import { Routes } from '@angular/router';
import { FilmDashboard } from './components/film-dashboard/film-dashboard';

export const routes: Routes = [
    {path: '', redirectTo: 'films', pathMatch: 'full'},
    {path: 'films', component: FilmDashboard }
];
