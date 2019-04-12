import { Component, OnInit } from '@angular/core';
import { Method } from '../method';
import { HotspotService } from '../hotspot.service';

@Component({
  selector: 'app-method-call-count',
  templateUrl: './method-call-count.component.html',
  styleUrls: ['./method-call-count.component.css']
})
export class MethodCallCountComponent implements OnInit {

    idMethodMap: Map<string, Method>;
    methodCallCounts: Map<string, string>[];
    interval: any;

    constructor(private hotspotService: HotspotService) { }

    ngOnInit() {
        this.refreshData();
        this.interval = setInterval(() => {
            this.refreshData();
        }, 5000);
    }

    ngOnDestroy() {
        clearInterval(this.interval);
    }

    refreshData() {
        this.hotspotService.getIdMethodMap()
            .subscribe(map => this.idMethodMap = map);
        this.hotspotService.getMethodCallCounts()
            .subscribe(counts => this.methodCallCounts = counts);
    }

}
