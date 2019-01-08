import { Component, OnInit } from '@angular/core';
import { HttpClient,  HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CarDto } from '../dto/car.dto';
import { Utils } from '../utils/utils';

@Component({
    selector: 'app-my-cars',
    templateUrl: './my-cars.component.html',
    styleUrls: ['./my-cars.component.css']
})
export class MyCarsComponent implements OnInit {

    private errorMessage = '';
    private cars = [];
    private progress = true;
    private tableMessage = '';

    constructor(private http: HttpClient) { }

    ngOnInit() {
        this.getCars();
    }

    private getCars(): void {
        this.errorMessage = '';
        this.cars = [];
        this.setProgress(true);
        this.http.get<CarDto[]>(Utils.getRestUri() + 'list-cars')
                .subscribe(
                        res   => { this.setProgress(false); this.cars = res; },
                        error => { this.setProgress(false); this.errorMessage = Utils.getError(error); }
                );
    }

    private setProgress(progress: boolean): void {
        this.progress = progress;
        if (progress) {
            this.tableMessage = 'Loading...';
        } else {
            this.tableMessage = 'No cars';
        }
    }

    private deleteCar(carId: number): void {
        if (window.confirm('Delete car with ID ' + carId + '?')) {
            this.http.delete(Utils.getRestUri() + 'car/' + carId)
                    .subscribe(
                            res => this.getCars(),
                            error => this.errorMessage = Utils.getError(error)
                    );
        }
    }

}
