import { Component, OnInit } from '@angular/core';
import { HotspotService } from '../hotspot.service';
import { Method } from '../method';

@Component({
    selector: 'app-method-call-counter',
    templateUrl: './method-call-counter.component.html',
    styleUrls: ['./method-call-counter.component.css']
})
export class MethodCallCounterComponent implements OnInit {

    idMethodMap: Map<string, Method>;
    methodCallCounter: Map<string, number>;

    constructor(private hotspotService: HotspotService) { }

    ngOnInit() {
        this.getIdMethodMap();
        this.getMethodCallCounter();
    }

    getIdMethodMap() {
        this.hotspotService.getIdMethodMap()
                .subscribe(map => this.idMethodMap = map);
    }

    getMethodCallCounter() {
        this.hotspotService.getMethodCallCounter()
                .subscribe(counter => this.methodCallCounter = counter);
    }

}
