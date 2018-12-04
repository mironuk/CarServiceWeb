import { Component } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TextWrapper } from './text.wrapper.dto';

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
        this.http.get<TextWrapper>('/rest/show-result').subscribe(res => this.result = res.text);
    }

}
