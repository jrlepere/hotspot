import { Component, OnInit, Input } from '@angular/core';
import { HotspotService } from '../hotspot.service';

@Component({
    selector: 'app-project-id',
    templateUrl: './project-id.component.html',
    styleUrls: ['./project-id.component.css']
})
export class ProjectIdComponent implements OnInit {

    @Input() projectId: string;
    
    constructor(private hotspotService: HotspotService) { }

    ngOnInit() {
    }

    setProjectId() {
        this.hotspotService.setProjectId(this.projectId);
    }

}
