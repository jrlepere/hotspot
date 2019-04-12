import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MethodCallLogComponent } from './method-call-log/method-call-log.component';

const routes: Routes = [
    { path: 'log', component: MethodCallLogComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
