import { Routes } from '@angular/router';
import { Home } from './home/home';
import { DownloadPage } from './download-page/download-page';
import { Admin } from './admin/admin';
import { AdminLogin } from './admin-login/admin-login';
export const routes: Routes = [
    {path:'',component:Home},
    {path:'download/:id',component:DownloadPage},
    {path:'admin/panel',component:Admin},
    {path:'admin',component:AdminLogin}
];
