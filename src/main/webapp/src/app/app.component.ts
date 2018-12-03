import { Component } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Text } from './text.dto';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})

export class AppComponent {

    title = 'Application works!';
    result = '';

    constructor(private http: HttpClient) {
    }

    private showResult(): void {
        this.result = 'loading...';
        this.http.get<Text>('/rest/show-result').subscribe(res => this.result = res.text);
    }

}
