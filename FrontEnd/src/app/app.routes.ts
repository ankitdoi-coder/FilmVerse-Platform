import { Routes } from '@angular/router';
import { Home } from './home/home';
import { DownloadPage } from './download-page/download-page';
export const routes: Routes = [
    {path:'',component:Home},
    {path:'download',component:DownloadPage}
];
