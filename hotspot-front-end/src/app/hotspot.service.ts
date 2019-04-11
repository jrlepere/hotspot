import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { MethodCall } from './method-call';

@Injectable({
  providedIn: 'root'
})
export class HotspotService {

  constructor() { }

  getMethodCalls(): Observable<MethodCall[]> {
    return null;
  }

}
