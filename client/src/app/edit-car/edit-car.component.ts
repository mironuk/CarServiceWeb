import { Component, OnInit } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { CarDto } from '../dto/car.dto';
import { Utils } from '../utils/utils';

@Component({
    selector: 'app-edit-car',
    templateUrl: './edit-car.component.html',
    styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent implements OnInit {

    private errorMessage = '';
    private yearErrorMessage = '';

    private carId = undefined;
    private car: CarDto;

    private makeError = false;
    private modelError = false;
    private yearError = false;

    constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {

        this.route.params.subscribe(params => {
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

    private save(): void {
        if (this.isDtoValid()) {
            this.http.post<CarDto>(Utils.getRestUri() + 'save-car', this.car)
                    .subscribe(
                            res => this.router.navigate(['/my-cars']),
                            error => this.errorMessage = Utils.getError(error)
                    );
        }
    }

    private isDtoValid(): boolean {
        this.makeError = false;
        this.modelError = false;
        this.yearError = false;
        let valid = true;
        if (!this.isStringValid(this.car.make)) {
            this.makeError = true;
            valid = false;
        }
        if (!this.isStringValid(this.car.model)) {
            this.modelError = true;
            valid = false;
        }
        if (!this.isYearValid(this.car.year)) {
            this.yearError = true;
            valid = false;
        }
        return valid;
    }

    private isStringValid(str: string): boolean {
        return str != null && str.trim() != '';
    }

    private isYearValid(yearStr: string): boolean {
        this.yearErrorMessage = '';
        let isValid = true;
        let currentYear = new Date().getFullYear();
        let minYear = 1950;
        let maxYear = currentYear;
        if (yearStr != null && yearStr.trim() != '') {
            let year = Number(yearStr.trim());
            isValid = (!yearStr) || (!isNaN(year) && year >= minYear && year <= maxYear);
        }
        if (!isValid) {
            this.yearErrorMessage = 'The year must be a valid number between ' + minYear + ' and ' + maxYear;
        }
        return isValid;
    }

}
