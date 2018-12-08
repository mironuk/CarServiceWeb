import { Component, OnInit } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TextWrapper } from '../dto/text.wrapper.dto';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    result = '';

    constructor(private http: HttpClient) {
    }

    ngOnInit() {
    }

    private showResult(): void {
        this.result = 'loading...';
        this.http.get<TextWrapper>('http://localhost:8080/rest/show-result')
                .subscribe(
                        res => this.result = res.text,
                        error => this.result = error.message
                );
    }

}
