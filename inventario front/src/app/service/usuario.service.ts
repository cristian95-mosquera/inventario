import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  UsuarioURL = environment.UsuarioURL;
  
  constructor(private httpClient: HttpClient) { }

  public listarUsuario(): Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(this.UsuarioURL );
  }

  public guardarUsuario(usuario: Usuario): Observable<any>{
    return this.httpClient.post<any>(this.UsuarioURL , usuario);
  } 

  public actualizarUsuario(id: number, usuario: Usuario): Observable<any>{
    return this.httpClient.put<any>(this.UsuarioURL + {id}, usuario);
  } 

  public eliminarUsuario(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.UsuarioURL + {id});
  }

}
