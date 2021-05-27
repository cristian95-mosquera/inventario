import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-nuevo-mercancia',
  templateUrl: './nuevo-mercancia.component.html',
  styleUrls: ['./nuevo-mercancia.component.css']
})
export class NuevoMercanciaComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(private usuarioService: UsuarioService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.cargarUsuario();
  }

  cargarUsuario(){
    this.usuarioService.listarUsuario().subscribe((listarUsuario) => this.usuarios = listarUsuario);
  }
  
  

}
