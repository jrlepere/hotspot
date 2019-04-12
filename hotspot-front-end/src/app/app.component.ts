import { Component, Input } from '@angular/core';
import { HotspotService } from './hotspot.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'Hotspot';
    @Input() projectId: string;
    isValidProjectId = false;

    constructor(private hotspotService: HotspotService) {}

    loadProjectId() {
        this.hotspotService.setProjectId(this.projectId);
        this.hotspotService.isValidProjectId().subscribe(res => this.isValidProjectId = res);
    }
}
