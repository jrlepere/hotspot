import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MethodCallLogComponent } from './method-call-log/method-call-log.component';
import { MethodCallCounterComponent } from './method-call-counter/method-call-counter.component';


const routes: Routes = [
    { path: '', redirectTo: '/log', pathMatch: 'full' },
    { path: 'log', component: MethodCallLogComponent },
    { path: 'count', component: MethodCallCounterComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
