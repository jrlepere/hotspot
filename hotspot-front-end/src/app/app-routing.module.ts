import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MethodCallLogComponent } from './method-call-log/method-call-log.component';
import { MethodCallCountComponent } from './method-call-count/method-call-count.component';

const routes: Routes = [
    { path: 'log', component: MethodCallLogComponent },
    { path: 'call-count', component: MethodCallCountComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
