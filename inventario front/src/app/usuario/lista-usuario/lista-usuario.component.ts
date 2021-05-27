import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css']
})
export class ListaUsuarioComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(private usuarioService: UsuarioService ) { }

  ngOnInit() {
    this.listarUsuario();
  }

  listarUsuario(): void{
    this.usuarioService.listarUsuario().subscribe(
      data => {
        this.usuarios = data;
      },
      err => {
        console.log(err);
      }
    )     
  }

}
