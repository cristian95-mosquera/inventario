import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Mercancia } from '../models/mercancia';

@Injectable({
  providedIn: 'root'
})
export class MercanciaService {

  MercanciaURL = environment.MercanciaURL;

  constructor(private httpClient: HttpClient) { }

  public listar(): Observable<Mercancia[]>{
    return this.httpClient.get<Mercancia[]>(this.MercanciaURL );
  }

  public consultarPorNombre(nombreProducto: string): Observable<any>{
    return this.httpClient.get<any>(this.MercanciaURL + '/' + nombreProducto);
  }

  public guardarMercancia(mercancia: Mercancia): Observable<any>{
    return this.httpClient.post<any>(this.MercanciaURL , mercancia);
  } 

  public editar(id: number, mercancia: Mercancia): Observable<any>{
    return this.httpClient.put<any>(this.MercanciaURL + id, mercancia);
  } 

  public eliminar(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.MercanciaURL + '/'+ id);
  }
}
