import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css']
})
export class ListaUsuarioComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(private usuarioService: UsuarioService, private toastr: ToastrService ) { }

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
  eliminarUsuario(id:number): void{
    this.usuarioService.eliminarUsuario(id).subscribe(
      () => {
        this.toastr.success('Usuario eliminado', 'información');
        this.listarUsuario();
      },
      err => {
        this.toastr.error(err.error?.mensaje,'Error');
      }
    )
  }


}
