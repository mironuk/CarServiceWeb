import { HttpErrorResponse } from '@angular/common/http';

export class Utils {

    // TODO: make config parameter
    public static getRestProtocol(): string {
        return 'http';
    }

    // TODO: make config parameter
    public static getRestHost(): string {
        return window.location.hostname;
    }

    // TODO: make config parameter
    public static getRestPort(): string {
        return '8080';
    }

    // TODO: make config parameter
    public static getRestUriPart(): string {
        return 'rest';
    }

    public static getRestUri(): string {
        return this.getRestProtocol() + '://' + this.getRestHost() + ':' + this.getRestPort() + '/' + this.getRestUriPart() + '/';
    }

    public static getError(error: HttpErrorResponse): string {
        console.error('ERROR: ' + JSON.stringify(error, null, "  "));
        if (error.status == 0) {
            return 'Service unavailable';
        } else {
            if (error.error instanceof ErrorEvent) {
                // A client-side or network error occurred. Handle it accordingly.
                return 'An error occurred: ' + error.error.message;
            } else {
                // The backend returned an unsuccessful response code.
                // The response body may contain clues as to what went wrong,
                return '' + error.status
                        + (error.error.error ? ' / ' + error.error.error : '')
                        + (error.error.message ? ' / ' + error.error.message : '');
            }
        }
    }

}
