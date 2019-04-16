import { Component, OnInit } from '@angular/core';
import { HotspotService } from '../hotspot.service';
import { Method } from '../method';

@Component({
    selector: 'app-method-call-log',
    templateUrl: './method-call-log.component.html',
    styleUrls: ['./method-call-log.component.css']
})
export class MethodCallLogComponent implements OnInit {

    idMethodMap: Map<string, Method>;
    methodCallLog: string[];
    interval: any;

    constructor(private hotspotService: HotspotService) { }

    ngOnInit() {
        this.refreshData();
        this.interval = setInterval(() => {
            this.refreshData();
        }, 500);
    }

    ngOnDestroy() {
        clearInterval(this.interval);
    }

    refreshData() {
        this.hotspotService.getIdMethodMap()
            .subscribe(map => this.idMethodMap = map);
        this.hotspotService.getMethodCallLog()
            .subscribe(log => this.methodCallLog = log);
    }

}
