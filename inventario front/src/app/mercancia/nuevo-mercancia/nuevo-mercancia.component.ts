import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/models/usuario';
import { MercanciaService } from 'src/app/service/mercancia.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-nuevo-mercancia',
  templateUrl: './nuevo-mercancia.component.html',
  styleUrls: ['./nuevo-mercancia.component.css']
})
export class NuevoMercanciaComponent implements OnInit {

  usuarios: Usuario[] = [];
  
  formularioMercancia: FormGroup;

  constructor(private mercanciaService: MercanciaService ,private usuarioService: UsuarioService, private formBuilder: FormBuilder, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.formularioMercancia = this.formBuilder.group({
      nombreProducto: ['', Validators.required],
      cantidad: ['', Validators.required],
      fechaIngreso: ['', Validators.required],
      usuario: ['', Validators.required],
    });
    this.listarUsuario();
  }

  listarUsuario(){
    this.usuarioService.listarUsuario().subscribe((listarUsuario) => this.usuarios = listarUsuario);
  }

  guardarMercancia() {
    if(this.formularioMercancia.valid){
      this.mercanciaService.guardarMercancia(this.formularioMercancia.value).subscribe(
       ( )=> {
        this.toastr.success('Mercancia creada con exitosamente','información');
       },
       (error:any)=> {
        this.toastr.error(error.error?.mensaje,'Error'); 
       }
      )
    }
  }
  

}
