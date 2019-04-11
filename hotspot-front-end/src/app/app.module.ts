import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MethodCallLogComponent } from './method-call-log/method-call-log.component';
import { HttpClientModule } from '@angular/common/http';
import { MethodCallCounterComponent } from './method-call-counter/method-call-counter.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    MethodCallLogComponent,
    MethodCallCounterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
