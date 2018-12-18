import { Component, OnInit } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { CarDto } from '../dto/car.dto';
import { Utils } from '../utils/utils';

@Component({
    selector: 'app-view-car',
    templateUrl: './view-car.component.html',
    styleUrls: ['./view-car.component.css']
})
export class ViewCarComponent implements OnInit {

    private errorMessage = '';
    private carId = undefined;
    private car: CarDto;

    constructor(private http: HttpClient, private route: ActivatedRoute) { }

    ngOnInit() {

        this.route.params.subscribe(params => {
            console.log(params.id);
            if (params.id) {
                this.carId = params.id;
                this.load(params.id)
            }
        });

        this.car = {
            carId: undefined,
            userId: 1,
            nickname: undefined,
            vin: undefined,
            licensePlate: undefined,
            make: undefined,
            model: undefined,
            year: undefined,
            color: undefined,
            description: undefined
        }
    }

    private load(carId: number): void {
        this.http.get<CarDto>(Utils.getRestUri() + 'car/' + carId)
                .subscribe(
                        res => this.car = res,
                        error => this.errorMessage = Utils.getError(error)
                );
    }

}
