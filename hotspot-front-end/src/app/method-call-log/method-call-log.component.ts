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

    constructor(private hotspotService: HotspotService) { }

    ngOnInit() {
        this.getIdMethodMap();
        this.getMethodCallLog();
    }

    getIdMethodMap(): void {
        this.hotspotService.getIdMethodMap()
                .subscribe(map => this.idMethodMap = map);
    }

    getMethodCallLog(): void {
        this.hotspotService.getMethodCallLog()
                .subscribe(log => this.methodCallLog = log);
    }

}
