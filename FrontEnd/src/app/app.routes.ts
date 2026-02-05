import { Routes } from '@angular/router';
import { Home } from './home/home';
import { DownloadPage } from './download-page/download-page';
import { Admin } from './admin/admin';
import { AdminLogin } from './admin-login/admin-login';
import { AuthGuard } from './Guards/auth.guard';

export const routes: Routes = [
    { path: '', component: Home },
    { path: 'download/:id', component: DownloadPage },
    { path: 'admin-login', component: AdminLogin },
    { path: 'admin', component: Admin, canActivate: [AuthGuard] },
    { path: '**', redirectTo: '' }
];
