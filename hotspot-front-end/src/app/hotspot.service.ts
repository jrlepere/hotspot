import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { Method } from './method';


@Injectable({
    providedIn: 'root'
})
export class HotspotService {

    private rootUrl = 'http://localhost:8080';

    constructor(private httpClient: HttpClient) { }

    getMethodCallLog(): Observable<string[]> {
        const url = `${this.rootUrl}/method-call-log`;
        return this.httpClient.get<string[]>(url)
                .pipe(
                    tap(_ => this.log('fetched method call log')),
                    catchError(this.handleError<string[]>('getMethodCallLog()'))
                );
    }

    getIdMethodMap(): Observable<Map<string, Method>> {
        const url = `${this.rootUrl}/id-method-map`;
        return this.httpClient.get<Map<string, Method>>(url)
                .pipe(
                    tap(_ => this.log('fetched id method map')),
                    catchError(this.handleError<Map<string, Method>>('getIdMethodMap()'))
                );
    }

    getMethodCallCounter(): Observable<Map<string, number>> {
        const url = `${this.rootUrl}/method-call-counter`;
        return this.httpClient.get<Map<string, number>>(url)
                .pipe(
                    tap(_ => this.log('fetched method call counter')),
                    catchError(this.handleError<Map<string, number>>('getMethodCallCounter()'))
                );
    }

    private log(message: string) {
        console.log(message);
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            this.log(`${operation} failed: ${error.message}`);
            return of(result as T);
        };
    }

}
