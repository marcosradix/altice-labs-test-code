import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {LabseqResponse} from '../model/labseeq-response.model';

@Injectable({
  providedIn: 'root'
})
export class LabsecService {

  private readonly PATH: string = 'labseq';

  constructor(private http: HttpClient) { }

    labseqLoad(index: number):Observable<LabseqResponse>{
    return this.http.get<LabseqResponse>(`${environment.urlApi}/${this.PATH}/${index}`);
  }
}
