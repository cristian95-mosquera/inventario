import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cargo } from '../models/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  CargoURL = environment.CargoURL;

  constructor(private httpClient: HttpClient) { }

  public listarCargo(): Observable<Cargo[]>{
    return this.httpClient.get<Cargo[]>(this.CargoURL );
  }

  public crearCargo(cargo: Cargo): Observable<any>{
    return this.httpClient.post<any>(this.CargoURL , cargo);
  } 

  public actualizarCargo(id: number, cargo: Cargo): Observable<any>{
    return this.httpClient.put<any>(this.CargoURL + id, cargo);
  } 

  public eliminarCargo(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.CargoURL + '/'+id);
  }
}
