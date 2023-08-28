import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LabsecService {

  private readonly PATH: string = 'labseq';

  constructor(private http: HttpClient) { }

    labseqLoad(index: number):Observable<any>{
    return this.http.get(`${environment.urlApi}/${this.PATH}/${index}`);
  }
}
